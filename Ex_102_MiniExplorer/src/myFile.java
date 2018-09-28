
import java.awt.Color;
import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author johannesriedmueller
 */
public class myFile extends File{
    private Color color;
    private Color backColor;
    
    public myFile(String pathname) {
        super(pathname);
    }

    public Color getColor() {
        if(this.isDirectory()){
            color = Color.RED;
        }
        else{
            color = Color.BLUE;
        }
        return color;
    }

    public Color getBackColor() {
        if(this.isDirectory()){
            backColor = Color.LIGHT_GRAY;
        }
        else{
            backColor = new Color(220,220,220);
        }
        return backColor;
    }
    
    
    
    @Override
    public String toString() {
        if(this.isDirectory()){
           return this.getName();
        }
        else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            LocalDateTime ldt = LocalDateTime.ofEpochSecond(this.lastModified()/1000, 0, ZoneOffset.UTC);
            StringBuilder sb = new StringBuilder();
            if(this.canRead()){
                sb.append("R");
            }
            if(this.canWrite()){
                sb.append("W");
            }
            if(this.canExecute()){
                sb.append("X");
            }
            if(this.isHidden()){
                sb.append("H");
            }
            return String.format("%-30s %25s %10d KB %s", this.getName(), dtf.format(ldt), this.length()/1000, sb);
        }
    }
    
    
}
