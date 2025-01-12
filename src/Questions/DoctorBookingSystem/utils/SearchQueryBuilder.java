package Questions.DoctorBookingSystem.utils;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.repository.SlotRepository;
import Questions.DoctorBookingSystem.strategy.actions.SearchDoctorActionDetails;
import Questions.DoctorBookingSystem.strategy.filter.*;
import Questions.DoctorBookingSystem.strategy.sort.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchQueryBuilder {
    public static SearchDoctorActionDetails buildSearchQuery(
            List<IFilter> systemFilters,
            List<ISort> systemSortings,
            SlotRepository slotRepository) {

        Scanner scanner = new Scanner(System.in);

        // Prompt user to select filters
        System.out.println("Available Filters:");
        for (int i = 0; i < systemFilters.size(); i++) {
            System.out.println((i + 1) + ". " + systemFilters.get(i).getClass().getSimpleName());
        }
        System.out.println("Enter filter numbers separated by commas (e.g., 1,2): ");
        String filterInput = scanner.nextLine();
        List<IFilterDetails> userFilterDetails = parseFilterInput(filterInput, systemFilters, scanner);

        // Prompt user to select sorting strategies
        System.out.println("Available Sorting Strategies:");
        for (int i = 0; i < systemSortings.size(); i++) {
            System.out.println((i + 1) + ". " + systemSortings.get(i).getClass().getSimpleName());
        }
        System.out.println("Enter sorting numbers separated by commas (e.g., 1,3):");
        String sortInput = scanner.nextLine();
        List<ISortDetails> userSortDetails = parseSortInput(sortInput, systemSortings, slotRepository, scanner);

        // Create SearchDoctorActionDetails
        System.out.println("Enter user type (e.g., PATIENT):");
        UserType userType = UserType.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Enter user ID:");
        String userId = scanner.nextLine();

        return new SearchDoctorActionDetails(userFilterDetails, userSortDetails, userType, userId);
    }

    private static List<IFilterDetails> parseFilterInput(String input, List<IFilter> filters, Scanner scanner) {
        List<IFilterDetails> filterDetails = new ArrayList<>();
        for (String index : input.split(",")) {
            int filterIndex = Integer.parseInt(index.trim()) - 1;
            IFilter filter = filters.get(filterIndex);

            if (filter instanceof UserTypeFilter) {
                System.out.println("Enter User Type (e.g., DOCTOR):");
                UserType userType = UserType.valueOf(scanner.nextLine().toUpperCase());
                filterDetails.add(new UserTypeFilterDetails(userType));
            } else if (filter instanceof DoctorTypeFilter) {
                System.out.println("Enter Doctor Type (e.g., CARDIOLOGIST):");
                DoctorType doctorType = DoctorType.valueOf(scanner.nextLine().toUpperCase());
                filterDetails.add(new DoctorTypeFilterDetails(doctorType));
            } else if (filter instanceof RatingFilter) {
                System.out.println("Enter minimum rating (e.g., 1):");
                int rating = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                filterDetails.add(new RatingFilterDetails(rating));
            }
        }
        return filterDetails;
    }

    private static List<ISortDetails> parseSortInput(String input, List<ISort> sorts, SlotRepository slotRepository, Scanner scanner) {
        List<ISortDetails> sortDetails = new ArrayList<>();
        for (String index : input.split(",")) {
            int sortIndex = Integer.parseInt(index.trim()) - 1;
            ISort sort = sorts.get(sortIndex);

            if (sort instanceof RatingSort) {
                sortDetails.add(new RatingSortDetails());
            } else if (sort instanceof EarliestSlotAvailabilitySort) {
                sortDetails.add(new EarliestSlotAvailabilitySortDetails(slotRepository));
            }
        }
        return sortDetails;
    }
}
