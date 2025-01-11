package Questions.DoctorBookingSystem.strategy.user;

public class PatientUserProfileDetails implements IUserProfileDetails {
    private String medicalHistory;

    public PatientUserProfileDetails(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "PatientUserProfileDetails{" +
                "medicalHistory='" + medicalHistory + '\'' +
                '}';
    }
}
