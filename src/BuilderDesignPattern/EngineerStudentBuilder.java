package BuilderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class EngineerStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects() {
        List<String> subjects = new ArrayList<>();
        subjects.add("Physics");
        subjects.add("Maths");
        subjects.add("CS");

        this.subjects = subjects;
        return this;
    }
}
