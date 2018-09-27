
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class FileListRenderer implements ListCellRenderer{
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = new JLabel(value.toString());
        label.setOpaque(true);
        if(value instanceof myFile){
            myFile file = (myFile) value;
            label.setForeground(file.getColor());
            if(file.isDirectory()){
                label.setFont(new Font("Courier New", Font.ITALIC, 12));
            }
            else{
                label.setFont(new Font("Courier New", Font.PLAIN, 12));
            }
        }
        label.setBackground(isSelected ? Color.lightGray : Color.white);
        
        return label;
    }
}
