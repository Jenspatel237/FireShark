/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Faltu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import net.sourceforge.jpcap.capture.CaptureTest;

/**
 *
 * @author jens
 */
public class hi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
    {
        Path path = Paths.get("/usr/local/Firewall");
        if(!Files.exists(path))
        {
            Files.createDirectories(path);
        }
    }
    
}
