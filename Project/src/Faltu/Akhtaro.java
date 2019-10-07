package Faltu;

import java.io.IOException;
import project.LogManager;

/**
 *
 * @author jens
 */
public class Akhtaro 
{
    void hello() throws IOException
    {
        int a = LogManager.CheckFile();
      //  LogManager.WriteLog("");
        
        if(a == 1)
        {
            System.out.println("Files created successfully");
        }
    }
    
    
    
    public static void main(String[] args) throws IOException 
    {
        Akhtaro ak = new Akhtaro();
        ak.hello();
    }
}
