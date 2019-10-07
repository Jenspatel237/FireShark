/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import iptableswing.GUI.iptableSwing;
import static java.lang.Compiler.command;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jens
 */
public class Rules {

    public static String runCmd(String cmd) throws IOException {
        Process p1 = Runtime.getRuntime().exec(cmd);
        System.out.println(cmd);
        
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p1.getInputStream()));

        BufferedReader stdError = new BufferedReader(new InputStreamReader(p1.getErrorStream()));

// read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        String s = null;
        String s1 = "";
        while ((s = stdInput.readLine()) != null) {
         //   s1 = s1+"\n"+s;
            System.out.println(s);
        }
        

// read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null) {
            s1=s1+"\n"+s;
            System.out.println(s);
        }
        return s1;
    }
    
    
    
    public static String runCmdP(String cmd)
    {
        String s = null;
        String s1 = "";
        
        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            
            Process p = pb.start();
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            
            System.out.println("Here is the standard output of the command:\n");
            
            while ((s = stdInput.readLine()) != null) {
                s1 = s1+s;
                System.out.println(s);
            }


    // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                s1=s1+"\n"+s;
                System.out.println(s);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Rules.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s1;
    }
    
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void errorBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.ERROR_MESSAGE);
    }

}