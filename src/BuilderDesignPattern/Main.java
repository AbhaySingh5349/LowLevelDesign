package BuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("time to build builder design pattern");

        StudentBuilder engineerBuilder = new EngineerStudentBuilder();
        Student s1 = engineerBuilder.setRollNum(1).setName("Abhay").setSubjects().build();

        StudentBuilder mbaBuilder = new MBAStudentBuilder();
        Student s2 = mbaBuilder.setRollNum(2).setName("Shivangi").setAddress("Meerut").setSubjects().build();

        System.out.println("student 1: " + s1);
        System.out.println("student 2: " + s2);
    }
}
