
import java.io.File;
import java.util.ArrayList;
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
public class FileModel extends AbstractListModel{
    private ArrayList<myFile> allFiles = new ArrayList<>();
    private ArrayList<myFile> filteredFiles = new ArrayList<>();
    
    public void add(String absolutePath){
        myFile toAdd = new myFile(absolutePath);
        allFiles.add(toAdd);
        filteredFiles.add(toAdd);
        fireIntervalAdded(filteredFiles, filteredFiles.size()-1, filteredFiles.size()-1);
    }
    
    @Override
    public int getSize() {
        return filteredFiles.size();
    }

    @Override
    public Object getElementAt(int index) {
        return filteredFiles.get(index);
    }
    
}
