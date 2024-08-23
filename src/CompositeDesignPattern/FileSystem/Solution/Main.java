package CompositeDesignPattern.FileSystem.Solution;

public class Main {
    public static void main(String[] args) {
        Directory csDirectory = new Directory("CSE_Dir");
        csDirectory.add(new File("DBMS"));
        csDirectory.add(new File("OS"));
        csDirectory.add(new File("DSA"));

        Directory eeDirectory = new Directory("EE_Dir");
        eeDirectory.add(new File("Electrical Motors"));
        eeDirectory.add(new File("Power Signals"));
        eeDirectory.add(new File("Rotation"));

        Directory directory = new Directory("Books_Dir");
        directory.add(csDirectory);
        directory.add(eeDirectory);

        directory.ls();
    }
}
