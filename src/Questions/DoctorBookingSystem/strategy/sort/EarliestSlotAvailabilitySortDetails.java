package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.SortType;
import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.repository.SlotRepository;
import Questions.DoctorBookingSystem.strategy.actions.IActionDetails;

public class EarliestSlotAvailabilitySortDetails implements ISortDetails {
    private final SlotRepository slotRepository;

    public EarliestSlotAvailabilitySortDetails(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public SlotRepository getSlotRepository() {
        return slotRepository;
    }

    @Override
    public boolean doesSupport(SortType sortType) {
        return sortType.equals(SortType.EARLIEST_SLOT);
    }
}
