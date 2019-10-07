package project;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jens
 */
public class LogManager 
{
    static BufferedWriter bw =null;
    public static int CheckFile() throws IOException
    {
        String s = ClientLogBean.getUser();
        String zone = ClientLogBean.getZone();
        System.out.println("User is "+s);
        boolean a = false,b = false,c = false, d = false, e = false;
        // For create DIRECTORY of LOGS.........................................
        //File FirewallLog = new File("/home/jens/FirewallLogs");
//        Path path = Paths.get("/home/"+s+"/FireShark/FirewallLogs");
//        if(!Files.exists(path))
//        {
//            //FirewallLog.mkdir();
//            Files.createDirectories(path);
//            a = Files.exists(path);
//            System.out.println(a);
//        }
//        
        // For Check CLIENTACTIVELOGS file............................................
        File ClientActiveLog = new File("/home/"+s+"/FireShark/ZoneName/"+zone+"/ClientActiveLogs.txt");
        if(!ClientActiveLog.exists())
        {
            ClientActiveLog.createNewFile();
            b = ClientActiveLog.exists();
            System.out.println(b);
        }
        
        
        // For Check CLIENTDISLOGS file............................................
        File ClientDisLog = new File("/home/"+s+"/FireShark/ZoneName/"+zone+"/ClientDisLogs.txt");
        if(!ClientDisLog.exists())
        {
            ClientDisLog.createNewFile();
            b = ClientDisLog.exists();
            System.out.println(b);
        }
        
        // For Check SYSTEMActiveLOGS file............................................
        File SysActiveLog = new File("/home/"+s+"/FireShark/ZoneName/"+zone+"/SysActiveLogs.txt");
        if(!SysActiveLog.exists())
        {
            SysActiveLog.createNewFile();
            d = SysActiveLog.exists();
            System.out.println(d);
        }
        
        
        // For Check SYSTEMDisLOGS file............................................
        File SysDisLog = new File("/home/"+s+"/FireShark/ZoneName/"+zone+"/SysDisLogs.txt");
        if(!SysDisLog.exists())
        {
            SysDisLog.createNewFile();
            e = SysDisLog.exists();
            System.out.println(e);
        }
        
        if(a == true || b == true || c == true || d == true || e == true)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    
    // Write Log in ClientActiveLog.txt ........................................
    
    public static void WriteClintActLog(String s) throws IOException
    {
        CheckFile();
        String s1 = ClientLogBean.getUser();
        String zone = ClientLogBean.getZone();
        File file = new File("/home/"+s1+"/FireShark/ZoneName/"+zone+"/ClientActiveLogs.txt");
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));   //home\\jens\\
        writeDate();
        bw.write("\t"+s);
        bw.newLine();
        bw.close();
    }
    
    // Write Log in ClientDisLog.txt ........................................
    
    public static void WriteClintDisLog(String s) throws IOException
    {
        String s1 = ClientLogBean.getUser();
        String zone = ClientLogBean.getZone();
        File file = new File("/home/"+s1+"/FireShark/ZoneName/"+zone+"/ClientDisLogs.txt");
        
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));   //home\\jens\\
        writeDate();
        bw.write("\t"+s);
        bw.newLine();
        bw.close();
    }
    
    // Write Log in SysActiveLog.txt ........................................
    
    public static void WriteSysActLog(String s) throws IOException
    {
        String s1 = ClientLogBean.getUser();
        String zone = ClientLogBean.getZone();
        File file = new File("/home/"+s1+"/FireShark/ZoneName/"+zone+"/SysActiveLogs.txt");
        
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));   //home\\jens\\
        writeDate();
        bw.write("\t"+s);
        bw.newLine();
        bw.close();
    }
    
    // Write Log in SysDisLog.txt ........................................
    
    public static void WriteSysDisLog(String s) throws IOException
    {
        String s1 = ClientLogBean.getUser();
        String zone = ClientLogBean.getZone();
        File file = new File("/home/"+s1+"/FireShark/ZoneName/"+zone+"/SysDisLogs.txt");
        
        bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));   //home\\jens\\
        writeDate();
        bw.write("\t"+s);
        bw.newLine();
        bw.close();
    }
    
    public static void DeleteData(ArrayList array,String file) 
    {
        String s = ClientLogBean.getUser();
        String zone = ClientLogBean.getZone();
        BufferedWriter bw = null;
        //DataOutputStream db = null;
        try 
        {
            for (int i = 0; i < array.size(); i++) 
            {
                System.out.println("--->" + array.get(i));               
            }  
            
            //System.out.println(str);
          //  File file = new File("/home/"+s+"/FireShark/ZoneName/" + str + "/"+str+".txt");
            File file1 = new File("/home/"+s+"/FireShark/ZoneName/"+zone+"/"+file+".txt");
            bw = new BufferedWriter(new FileWriter(file1)); //home\\jens\\
            
            StringBuilder sb = new StringBuilder();
            for (Iterator it = array.iterator(); it.hasNext();) 
            {
                String sj = (String)it.next();
                System.out.println(sj);
                    //System.out.println("space is found");
                sb.append(sj+"\n");
            }
            String sg = sb.toString();
            bw.write(sg);
            System.out.println("Items in String"+sg);
            bw.close();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FileOpeartionNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            //bw.close();
        }
    }
    
    // Write DATE in ALL Files ........................................
    
    public static void writeDate() throws IOException
    {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date date = new Date();
        String dat = df.format(date);
        System.out.println(dat);
        bw.write(dat);
      //  bw.newLine();
       // bw.close();
    }
    
    public static void writeActLog(String cmd) throws IOException
    {
        WriteSysActLog(cmd);
        String l = ClientLogBean.getClientData();
        WriteClintActLog(l);
    }
}
