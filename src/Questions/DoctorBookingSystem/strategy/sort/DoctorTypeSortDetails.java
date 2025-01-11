package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.SortType;

public class DoctorTypeSortDetails implements ISortDetails{
    DoctorType preferredDoctor;

    public DoctorTypeSortDetails(DoctorType preferredDoctor) {
        this.preferredDoctor = preferredDoctor;
    }

    public DoctorType getPreferredDoctor() {
        return preferredDoctor;
    }

    @Override
    public boolean doesSupport(SortType sortType) {
        return sortType.equals(SortType.DOCTOR_TYPE);
    }
}
