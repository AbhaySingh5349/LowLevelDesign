package Questions.CronParserSystem.Sol1.utils;

import Questions.CronParserSystem.Sol1.enums.ComponentType;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

public class Constants {
    public static final EnumMap<ComponentType, int[]> VALID_RANGES = new EnumMap<>(ComponentType.class);
    public static final Set<String> VALID_COMMANDS = new HashSet<>();

    static {
        // Add ranges for numeric components
        VALID_RANGES.put(ComponentType.MINUTE, new int[]{0, 59});
        VALID_RANGES.put(ComponentType.HOUR, new int[]{0, 23});
        VALID_RANGES.put(ComponentType.DAY_OF_MONTH, new int[]{1, 31});
        VALID_RANGES.put(ComponentType.MONTH, new int[]{1, 12});
        VALID_RANGES.put(ComponentType.DAY_OF_WEEK, new int[]{0, 6}); // 0 = Sunday, 6 = Saturday

        // Add valid commands
        VALID_COMMANDS.add("/usr/bin/find");
        VALID_COMMANDS.add("/usr/bin/backup");
        VALID_COMMANDS.add("/usr/bin/clean");
    }
}
