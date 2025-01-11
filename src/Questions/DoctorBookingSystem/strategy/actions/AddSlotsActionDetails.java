package Questions.DoctorBookingSystem.strategy.actions;

import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.Slot;

import java.util.List;

public class AddSlotsActionDetails implements IActionDetails{
    private final List<Slot> slots;
    private final UserType userType;
    private final String doctorId;

    public AddSlotsActionDetails(List<Slot> slots, UserType userType, String doctorId) {
        this.slots = slots;
        this.userType = userType;
        this.doctorId = doctorId;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getDoctorId() {
        return doctorId;
    }

    @Override
    public boolean doesSupport(UserType userType) {
        return userType.equals(UserType.DOCTOR);
    }
}
