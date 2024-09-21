package DesignPatterns.CompositeDesignPattern.FileSystem.Problem;

public class Main {
    public static void main(String[] args) {
        Directory baseDir = new Directory("baseDir");
        Directory subDir = new Directory("subDir");

        File f1 = new File("file_1");
        File f2 = new File("file_2");
        File f3 = new File("file_3");

        subDir.addObject(f2);
        subDir.addObject(f3);

        baseDir.addObject(f1);
        baseDir.addObject(subDir);

        baseDir.ls();
    }
}
