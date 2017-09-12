
/**
 * Mars Rover Challege test class.
 * 
 * @author (Purity Ngwenya) 
 * @version (08/09/2017)
 */

import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.*;
public class TestRover              
{
    public static void main(String [] args)
    {
        String path = "";
        JFileChooser  fileCh = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TEXT FILES","txt","text");
        fileCh.setFileFilter(fileFilter);
        fileCh.setCurrentDirectory(new File(System.getProperty("user.home")));
        File choosenFile;
        int result = fileCh.showOpenDialog(new JPanel());
        
        if(result == JFileChooser.APPROVE_OPTION)
        {
            choosenFile = fileCh.getSelectedFile();
            path = choosenFile.getAbsolutePath();
        }
        //String path = "/input.txt";
        Rover rover = new Rover(path);
        String output = rover.genNewPosition();
        System.out.println(output);
    }
}
