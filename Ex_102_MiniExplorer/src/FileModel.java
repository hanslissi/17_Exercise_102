
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
    private ArrayList<File> allFiles = new ArrayList<>();
    private ArrayList<File> filteredFiles = new ArrayList<>();
    
    @Override
    public int getSize() {
        return filteredFiles.size();
    }

    @Override
    public Object getElementAt(int index) {
        return filteredFiles.get(index);
    }
    
}
