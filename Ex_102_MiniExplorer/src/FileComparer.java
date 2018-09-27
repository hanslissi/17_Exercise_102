
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class FileComparer implements Comparator<myFile>{

    @Override
    public int compare(myFile f1, myFile f2) {
        if(f1.isDirectory()&&f2.isDirectory()){
            return f1.getName().compareTo(f2.getName());
        }
        else if(f1.isFile()&&f2.isFile()){
            return f1.getName().compareTo(f2.getName());
        }
        else if(f1.isDirectory()){
            return -1;
        }
        return 1;
    }

    
    
}
