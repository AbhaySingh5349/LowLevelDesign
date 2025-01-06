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
}
