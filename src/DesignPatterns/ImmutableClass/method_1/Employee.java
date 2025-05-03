package DesignPatterns.ImmutableClass.method_1;

import java.util.Date;

// Date is mutable, meaning its internal state (like time) can be changed. If we store the reference directly like: "this.joiningDate = joiningDate;"

public final class Employee {
    private final String name;
    private final Date joiningDate;

    public Employee(String name, Date joiningDate) {
        this.name = name;
        this.joiningDate = joiningDate;  // ❌ No defensive copy!
//        this.joiningDate = new Date(joiningDate.getTime()); // Defensive copy
    }

    public String getName() {
        return name;
    }

    public Date getJoiningDate() {
        return joiningDate;  // ❌ Returning the original mutable object!

//        return new Date(joiningDate.getTime()); // Defensive copy
    }
}
