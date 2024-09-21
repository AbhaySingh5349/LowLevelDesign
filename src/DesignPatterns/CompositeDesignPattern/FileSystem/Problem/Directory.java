package DesignPatterns.CompositeDesignPattern.FileSystem.Problem;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectList;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.objectList = new ArrayList<>();
    }

    public void addObject(Object o){
        objectList.add(o);
    }

    // we cannot have "if-else"
    public void ls(){
        System.out.println("Directory: " + directoryName);
        for (Object obj : objectList){
            if(obj instanceof Directory){
                ((Directory) obj).ls();
            }else if(obj instanceof File){
                ((File) obj).ls();
            }
        }
    }
}
