package Questions.OnlineMeetingScheduler.sol2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method");

//        Map<String, Object> mp = new HashMap<>();
//        mp.put("One", 1);
//        mp.put("tow", 2.0);
//        mp.put("three", "three");
//
//        System.out.println(mp);

        List<String> arr = Arrays.asList("bob", "alice", "jack");
        arr.stream()
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase())
                .forEach(System.out::println);
    }
}
