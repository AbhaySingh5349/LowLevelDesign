package Questions.OnlineMeetingScheduler.sol1.model;

public class CustomDate {
    private Integer month;
    private Integer days;

    public CustomDate(Integer month, Integer days) {
        this.month = month;
        this.days = days;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDays() {
        return days;
    }

    public Integer getDelta(CustomDate other){
        Integer d1 = this.month*30 + this.days;
        Integer d2 = other.month*30 + other.days;

        return Math.abs(d1 - d2);
    }

    public CustomDate addDays(Integer n){
        Integer totalDays = this.month*30 + this.days + n;
        Integer newMonth = totalDays/30;
        Integer newDays = totalDays%30;

        return new CustomDate(newMonth, newDays);
    }

    public static String serializeDate(CustomDate date){
        return String.valueOf(date.getMonth()) + ":" + String.valueOf(date.getDays());
    }
}
