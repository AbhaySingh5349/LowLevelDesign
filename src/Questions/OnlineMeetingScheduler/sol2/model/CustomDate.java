package Questions.OnlineMeetingScheduler.sol2.model;

import java.time.LocalDate;
import java.util.Objects;

public class CustomDate {
    private final Integer month;
    private final Integer day;

    public CustomDate(Integer month, Integer day) {
        this.month = month;
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomDate that = (CustomDate) o;
        return Objects.equals(month, that.month) && Objects.equals(day, that.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day);
    }

    @Override
    public String toString() {
        return "CustomDate{" +
                "month=" + month +
                ", day=" + day +
                '}';
    }
}
