package DesignPatterns.CompositeDesignPattern.FileSystem.Problem;

public class File {
    String filename;

    public File(String filename) {
        this.filename = filename;
    }

    public void ls(){
        System.out.println("filename: " + filename);
    }
}


