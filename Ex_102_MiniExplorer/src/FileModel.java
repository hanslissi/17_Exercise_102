
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.AbstractListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class FileModel extends AbstractListModel<myFile>{
    private ArrayList<myFile> allFiles = new ArrayList<>();
    private ArrayList<myFile> filteredFiles = new ArrayList<>();
    
    public void add(String absolutePath){
        myFile toAdd = new myFile(absolutePath);
        allFiles.add(toAdd);
        filteredFiles.add(toAdd);
        sort();
        fireIntervalAdded(filteredFiles, filteredFiles.size()-1, filteredFiles.size()-1);
        
    }
    
    public void deleteAll(){
        filteredFiles.clear();
    }
    
    public void sort(){
        Collections.sort(filteredFiles, new FileComparer());
    }
    
    @Override
    public int getSize() {
        return filteredFiles.size();
    }

    @Override
    public myFile getElementAt(int index) {
        return filteredFiles.get(index);
    }
    
}
