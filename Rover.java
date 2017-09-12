
/**
 * Mars Rover Challenge
 * 
 * @author (Purity Ngwenya) 
 * @version (08/09/2017)
 */

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Rover
{
    
    private int x; // current x position of the rover
    private int y;// current y position of the rover

    private int xBound; // x boundary
    private int yBound;// y boundary
    
    private char dir;//current direction
    
    private String p_rtnsts;
    private String p_rtnMsg;
    private String line1;
    private String line2;
    private String line3;
    private String checkL3="";
    
    private String rtnStr;
    /**
     * Constructor for objects of class rover
     */
    public Rover(String path)
    {
        if(  path !=null || path != " "){
                p_rtnsts ="" ;
                try{ 
                    File textF = new File( path );
                    Scanner input = new Scanner(textF);
                
                 
                    if(textF.exists())
                    {
                       line1 = input.nextLine();
                       line2 = input.nextLine();
                       line3 = input.nextLine();
                        }
                    else
                    {
                       p_rtnMsg = "File not found";
                       p_rtnsts = "e";
                    }
                }catch(Exception e)
                {
                    p_rtnMsg = "File not found";
                    p_rtnsts = "e";
                }
            }       
    }
    public   void checkFormatErr()
    {
        line1 = line1.trim();
        line2 = line2.trim();
        line3 = line3.trim();
        
        //checking line 1
        String pattern1 = "\\d*\\s\\d*";
        String [] arr1;
        Pattern r = Pattern.compile(pattern1); 
        Matcher m = r.matcher(line1);
        
        if(m.find())
        {
            try
            {
                arr1 = line1.split(" ");
                if(arr1.length != 2)
                {
                    p_rtnMsg = "Error in the first line: More than 2 coordinates entered";
                    p_rtnsts = "e";
                    return;
                }else
                {
                    xBound = Integer.parseInt(arr1[0]);
                    yBound = Integer.parseInt(arr1[1]);
                }
            }catch(NumberFormatException e)
            {
                p_rtnMsg = "Error in the first line: Coordinates are in an incorrect format";
                p_rtnsts = "e";
                return;
            }
        }
        else
        {
            p_rtnMsg = "Error in the first line: Incorrect format used!";
            p_rtnsts = "e";
            return;
         }
        
        
        //checking errors in line 2
        String pattern2 = "\\d*\\s\\d*\\s[NEWSnews]";
        String [] arr2;
        r = Pattern.compile(pattern2);
        m = r.matcher(line2);
        if(m.find())
        {
                try
                {
                    arr2 = line2.split(" ");
                    x = Integer.parseInt(arr2[0]);
                    y = Integer.parseInt(arr2[1]);
                    dir = arr2[2].charAt(0);
                }catch(NumberFormatException e)
                {
                    p_rtnMsg = "Error on the second line: Incorrect format used";
                    p_rtnsts = "e";
                    return;
                }
                catch(Exception e)
                {
                    p_rtnMsg = "Error on the second line!";
                    p_rtnsts = "e";
                    return;
                }
        }
        
        //checking line 3
        for(int i = 0; i<line3.length();i++)
        {
            if(line3.substring(i,i+1).equalsIgnoreCase("M")||line3.substring(i,i+1).equalsIgnoreCase("L")||line3.substring(i,i+1).equalsIgnoreCase("R") )
            {
                   checkL3 = "ok";
            }
            else
            {
                p_rtnMsg ="Error on the third line: Unknown instructions entered!";
                p_rtnsts = "e";
                return;
            }
        }
     }
    
    public String genNewPosition()//generates the new position
    {
        checkFormatErr();
        if(p_rtnsts != "e")
        {
            for(int i = 0;i<line3.length();i++)
            {
                char instr = line3.charAt(i);
                if(Character.toUpperCase(instr)== 'M')
                {
                    move();
                }
                else
                {
                    rotate(instr);
                }
                
            }
            if(x < 0 || y < 0 || x > xBound || y > yBound)
            {
                p_rtnMsg ="The new position is outside the boundaries of the zone!";
                p_rtnsts = "e";
                return p_rtnMsg;
            }else
            {
               rtnStr = "The new position of the rover is "+ x + " " + y + " "+dir;
               return rtnStr;
            }
        }
        else
            return p_rtnMsg;
    }
     
    public void rotate(char rotation)
    {
        if(Character.toUpperCase(rotation) == 'R')
        {
            switch(Character.toUpperCase(dir))
            {
               case 'S': dir = 'W';
               break;
               case 'E': dir = 'S';
               break;
               case 'N': dir = 'E';
               break;
               case 'W': dir = 'N';
               break;
               default: p_rtnMsg = "Error in the rotation!";
            }
        }else if(Character.toUpperCase(rotation) =='L')
        {
            switch(Character.toUpperCase(dir))
            {
               case 'S': dir = 'E';
               break;
               case 'E': dir = 'N';
               break;
               case 'N': dir = 'W';
               break;
               case 'W': dir = 'S';
               break;
               default: p_rtnMsg = "Error in the rotation";
            }
        }else
        {
            p_rtnMsg = "An unknown error occured!!!";
            p_rtnsts = "e";
            return;
        }
    }
    
    public void move()
    {
        switch(Character.toUpperCase(dir))
        {
            case 'S': y = y-1;
            break;
            case 'W': x = x-1;
            break;
            case 'N': y = y+1;
            break;
            case 'E': x = x+1;
            break;
            default: p_rtnMsg = "Error in the rotation";
        }   
    }
     
}
