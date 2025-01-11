package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.SortType;
import Questions.DoctorBookingSystem.model.User;
import Questions.DoctorBookingSystem.repository.SlotRepository;


public class EarliestSlotAvailabilitySort implements ISort {
    @Override
    public boolean doesSupport(ISortDetails sortDetails) {
        return sortDetails.doesSupport(SortType.EARLIEST_SLOT);
    }

    @Override
    public int support(ISortDetails sortDetails, User u1, User u2) {
        EarliestSlotAvailabilitySortDetails earliestSlotAvailabilitySortDetails = (EarliestSlotAvailabilitySortDetails) sortDetails;

        SlotRepository slotRepository = earliestSlotAvailabilitySortDetails.getSlotRepository();

        EarliestSlotAvailabilityComparator comparator = new EarliestSlotAvailabilityComparator(slotRepository);

        return comparator.compare(u1, u2);
    }
}
