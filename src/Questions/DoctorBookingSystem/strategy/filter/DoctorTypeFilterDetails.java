package Questions.DoctorBookingSystem.strategy.filter;

import Questions.DoctorBookingSystem.enums.DoctorType;
import Questions.DoctorBookingSystem.enums.FilterType;
import Questions.DoctorBookingSystem.model.User;

import java.util.List;

public class DoctorTypeFilterDetails implements IFilterDetails{
    private final DoctorType doctorType;

    public DoctorTypeFilterDetails(DoctorType doctorType) {
        this.doctorType = doctorType;
    }

    public DoctorType getDoctorType() {
        return doctorType;
    }

    @Override
    public boolean doesSupport(FilterType filterType) {
        return filterType.equals(FilterType.DOCTOR_TYPE);
    }
}
