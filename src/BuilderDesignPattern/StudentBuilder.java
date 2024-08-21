package BuilderDesignPattern;

import java.util.List;

public abstract class StudentBuilder {
    Integer rollNum;
    String name;
    String address;
    List<String> subjects;

    public StudentBuilder setRollNum(Integer rollNum) {
        this.rollNum = rollNum;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StudentBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    abstract public StudentBuilder setSubjects();

    public  Student build(){
        return new Student(this);
    }
}
