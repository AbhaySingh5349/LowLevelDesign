package Questions.DoctorBookingSystem.strategy.sort;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.SortType;
import Questions.DoctorBookingSystem.model.User;

public class DoctorSort implements ISort{
    @Override
    public boolean doesSupport(ISortDetails sortDetails) {
        return sortDetails.doesSupport(SortType.DOCTOR_TYPE);
    }

    @Override
    public int support(ISortDetails sortDetails, User u1, User u2) {
        DoctorTypeSortDetails doctorTypeSortDetails = (DoctorTypeSortDetails) sortDetails;
        DoctorType doctorType = doctorTypeSortDetails.getPreferredDoctor();

        DoctorComparator doctorComparator = new DoctorComparator(doctorType);

        return doctorComparator.compare(u1, u2);
    }
}
