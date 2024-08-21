package BuilderDesignPattern;

import java.util.List;

public class Student {
    Integer rollNum;
    String name;
    String address;
    List<String> subjects;

    public Student(StudentBuilder builder){
        this.rollNum = builder.rollNum;
        this.name = builder.name;
        this.address = builder.address;
        this.subjects = builder.subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
