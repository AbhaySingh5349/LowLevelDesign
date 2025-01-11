package Questions.DoctorBookingSystem.service;

import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.Slot;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.repository.SlotRepository;
import Questions.DoctorBookingSystem.repository.UserRepository;
import Questions.DoctorBookingSystem.strategy.actions.AddSlotsActionDetails;
import Questions.DoctorBookingSystem.strategy.actions.IActionDetails;
import Questions.DoctorBookingSystem.strategy.actions.SearchDoctorActionDetails;
import Questions.DoctorBookingSystem.strategy.filter.IFilter;
import Questions.DoctorBookingSystem.strategy.filter.IFilterDetails;
import Questions.DoctorBookingSystem.strategy.sort.ISort;
import Questions.DoctorBookingSystem.strategy.sort.ISortDetails;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private final List<IFilter> systemFilters;
    private final List<ISort> systemSortings;
    private final SlotRepository slotRepository;

    public UserService(UserRepository userRepository, List<IFilter> systemFilters, List<ISort> systemSortings, SlotRepository slotRepository) {
        this.userRepository = userRepository;
        this.systemFilters = systemFilters;
        this.systemSortings = systemSortings;
        this.slotRepository = slotRepository;
    }

    public List<User> getDoctors(IActionDetails actionDetails){
        if(!(actionDetails instanceof SearchDoctorActionDetails)){
            System.out.println("Invalid Data provided for SearchDoctorActionDetails");
            return null;
        }

        SearchDoctorActionDetails searchDoctorActionDetails = (SearchDoctorActionDetails) actionDetails;

        UserType userType = searchDoctorActionDetails.getUserType();
        if(!searchDoctorActionDetails.doesSupport(userType)){
            System.out.println("Unauthorized user for searching doctors");
        }

        List<User> doctors = userRepository.getAllDoctors();

        List<IFilterDetails> userFilters = searchDoctorActionDetails.getUserFilterDetails();
        for (IFilter filter : systemFilters){
            for(IFilterDetails filterDetails : userFilters){
                if(filter.doesSupport(filterDetails)){
                    doctors = filter.support(filterDetails, doctors);
                }
            }
        }

        List<ISortDetails> userSortDetails = searchDoctorActionDetails.getUserSortDetails();

        doctors.sort((u1, u2) -> {
            for(ISort sort : systemSortings){
                for(ISortDetails sortDetails : userSortDetails){
                    if(sort.doesSupport(sortDetails)){

                        int result = sort.support(sortDetails, u1, u2);

                        if(result != 0){
                            return result;
                        }
                    }
                }
            }
            return 0;
        });

        String userId = searchDoctorActionDetails.getUserId();

        return doctors;
    }

    public void addDoctorSlots(IActionDetails actionDetails){
        if(!(actionDetails instanceof AddSlotsActionDetails)){
            System.out.println("Invalid Data provided for AddSlotsActionDetails");
            return;
        }

        AddSlotsActionDetails addSlotsActionDetails = (AddSlotsActionDetails) actionDetails;

        UserType userType = addSlotsActionDetails.getUserType();
        if(!addSlotsActionDetails.doesSupport(userType)){
            System.out.println("Unauthorized user for adding slots for doctor");
            return;
        }

        List<Slot> slots = addSlotsActionDetails.getSlots();
        String doctorId = addSlotsActionDetails.getDoctorId();

        slotRepository.add(slots, doctorId);
    }

    public List<Slot> getAvailableSlotsForDoctor(String doctorId){
        return slotRepository.getAvailableSlots(doctorId);
    }
}
