package DesignPatterns.ImmutableClass.method_2;

import java.util.Date;

public record Employee(String name, Date joiningDate) {

    // Canonical constructor with defensive copy
    public Employee {
        if (name == null || joiningDate == null) {
            throw new IllegalArgumentException("Name and joiningDate cannot be null");
        }

        // Defensive copy to protect internal state
        joiningDate = new Date(joiningDate.getTime());
    }

    // Override the accessor to return a defensive copy
    @Override
    public Date joiningDate() {
        return new Date(joiningDate.getTime());
    }
}
