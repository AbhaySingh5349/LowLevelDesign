package Questions.EventCalendar.model;

import Questions.EventCalendar.enums.LocationType;
import Questions.EventCalendar.strategy.ILocationTypeData;

public class Location {
    private String id;
    private String name;
    private ILocationTypeData locationTypeData; // data specific to physical or virtual location
    private LocationType locationType;
}
