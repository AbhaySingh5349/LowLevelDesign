package Questions.OnlineMeetingScheduler.sol2.service;

import Questions.OnlineMeetingScheduler.sol2.model.CustomDate;

import java.util.Map;

public class DateService {
    public Integer getDelta(CustomDate d1, CustomDate d2){
        Integer days1 = d1.getMonth()*30 + d1.getDay();
        Integer days2 = d2.getMonth()*30 + d2.getDay();

        return Math.abs(days1 - days2);
    }

    public CustomDate addDays(CustomDate date, int n){
        int days = date.getMonth()*30 + date.getDay() + n;
        return new CustomDate(days/30, days%30);
    }

    public boolean isDateWithinRange(CustomDate startDate, CustomDate endDate, CustomDate targetDate) {
        return (compareDates(targetDate, startDate) >= 0 && compareDates(targetDate, endDate) <= 0);
    }

    // Returns -1 if date1 < date2, 0 if equal, 1 if date1 > date2
    private int compareDates(CustomDate date1, CustomDate date2) {
        if (!date1.getMonth().equals(date2.getMonth())) {
            return date1.getMonth().compareTo(date2.getMonth());
        }
        return date1.getDay().compareTo(date2.getDay());
    }
}
