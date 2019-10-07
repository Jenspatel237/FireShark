package project;

//import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import project.AZONES;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileOpeartionNew 
{

    /* CREATE FILE Method.......................................................................   */
    public static void CreateFile(String Filename) throws IOException 
    {
        String s = ClientLogBean.getUser();
        System.out.println("User = "+s);
        Path path = Paths.get("/home/"+s+"/FireShark");
        Path path1 = Paths.get("/home/"+s+"/FireShark/ZoneName");
        Path path3 = Paths.get("/home/"+s+"/FireShark/ZoneName/ZoneMain");
        Path path2 = Paths.get("/home/"+s+"/FireShark/ZoneName/"+Filename+"");
        if(!Files.exists(path))
        {
//            System.out.println(f.exists());
//            System.out.println(f1.exists());
            Files.createDirectories(path);

           // f.mkdir();
            //f1.mkdir();
//            System.out.println(f.exists());
//            System.out.println(f1.exists());
        }
        if(!Files.exists(path1))
        {
            Files.createDirectories(path1);
        }
        if(!Files.exists(path3))
        {
            Files.createDirectories(path3);
        }
        if(!Files.exists(path2))
        {
            Files.createDirectories(path2);
        }
    }

    /* READ FILE Method.......................................................................   */
    public static ArrayList ReadFile(String Filename) 
    {
        String s = ClientLogBean.getUser();
        BufferedReader bufReader = null;
        ArrayList<String> listOfLines = new ArrayList<String>();
        try
        {
            System.out.println("/home/"+s+"/FireShark/" + Filename + ".txt");
//            if (Filename.equals("pblic")) {
//                bufReader = new BufferedReader(new FileReader("C:\\Users\\DELL\\Documents\\NetBeansProjects\\ProjectRelated\\src\\ZoneName\\pblic.txt"));
//            } else {
         bufReader = new BufferedReader(new FileReader("/home/"+s+"/FireShark/ZoneName/" + Filename + ".txt"));           
            String line = bufReader.readLine();
            System.out.println("reading : " + line);
            while (line != null) 
            {
                listOfLines.add(line);
                line = bufReader.readLine();
            }
            bufReader.close();
            System.out.println("Content of ArrayLiList:"+listOfLines);
            

//              String read = null;
//              while((read = bufReader.readLine())!= null)
//              {
//                  String[] spilted = read.split(" ");
//                  for(String part : spilted)
//                  {
//                      System.out.println(part);
//                      listOfLines.add(part);
//                      //part = bufReader.readLine();
//                      System.out.println("String in Arraylist"+part);
//                  }
//              }
              //bufReader.close();
        } 
        catch (FileNotFoundException ex) 
        {     
            System.out.println("File not found");
        }
        catch (IOException ex) 
        {
            System.out.println("hello");
        }
        finally 
        {
            try 
            {
                bufReader.close();
            }
            catch (IOException ex) 
            {
                Logger.getLogger(AZONES.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listOfLines;
    }

    /* WRITE FILE Method.......................................................................   */
    public static void WriteFile(String Filename, String Mix) 
    {
        String s = ClientLogBean.getUser();
        
        try {
            File file = new File("/home/"+s+"/FireShark/ZoneName/"+Filename+".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(), true));   //home\\jens\\
            //     System.out.println(enc_str);
            bw.write(Mix+"\n");
            //bw.newLine();
            // bw.flush();
            if(bw != null) 
            {
                bw.close();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /*DELETE FIle.................................................................................. */
    public static void DeleteData(ArrayList array,String str) 
    {
        String s = ClientLogBean.getUser();
        BufferedWriter bw = null;
        //DataOutputStream db = null;
        try 
        {
            for (int i = 0; i < array.size(); i++) 
            {
                System.out.println("--->" + array.get(i));               
            }  
            System.out.println("String in filename " + str);
            //System.out.println(str);
            File file = new File("/home/"+s+"/FireShark/ZoneName/" + str + "/"+str+".txt");
            File file1 = new File("/home/"+s+"/FireShark/ZoneName/ZoneMain/ZoneMain.txt");
            bw = new BufferedWriter(new FileWriter(file1)); //home\\jens\\
            //     System.out.println(enc_str);
            if(file.delete())
            {
                System.out.println("Delete");
            }
            else
            {
                System.out.println("yo");
            }

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
    
    public static void UpdateZoneData(String data ,String file, String zone) 
    {
        String s = ClientLogBean.getUser();
        
        BufferedWriter bw = null;
        //DataOutputStream db = null;
        try 
        {
            File file1 = new File("/home/"+s+"/FireShark/ZoneName/"+zone+"/"+file+".txt");
            bw = new BufferedWriter(new FileWriter(file1)); //home\\jens\\
            bw.write(data);
            System.out.println("Items in String"+data);
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
}
