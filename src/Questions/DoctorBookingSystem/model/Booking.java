package Questions.DoctorBookingSystem.model;

import Questions.DoctorBookingSystem.enums.BookingStatus;

public class Booking {
    private final String doctorId;
    private final String patientId;
    private final Slot slot;
    private BookingStatus bookingStatus;
    private final Long createdAt;

    public Booking(String doctorId, String patientId, Slot slot, BookingStatus bookingStatus) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.slot = slot;
        this.bookingStatus = bookingStatus;
        this.createdAt = System.currentTimeMillis();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public Slot getSlot() {
        return slot;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "doctorId='" + doctorId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", slot=" + slot +
                ", bookingStatus=" + bookingStatus +
                ", createdAt=" + createdAt +
                '}';
    }
}
