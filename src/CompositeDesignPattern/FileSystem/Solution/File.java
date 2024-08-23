package CompositeDesignPattern.FileSystem.Solution;

public class File implements FileSystem{
    String filename;

    public File(String filename) {
        this.filename = filename;
    }

    public void ls(){
        System.out.println("filename: " + filename);
    }
}
