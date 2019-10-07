package project;

/**
 *
 * @author jens
 */
public class ClientLogBean 
{
    private static String user;
    private static String zone;
    private static String SourceIP;
    private static String DestinationIP;
    private static String Port;
    private static String Policy;
    private static String Protocol;
    private static String Target;

    public static void setZone(String zone) {
        ClientLogBean.zone = zone;
    }

    public static void setSourceIP(String SourceIP) {
        ClientLogBean.SourceIP = SourceIP;
    }

    public static void setDestinationIP(String DestinationIP) {
        ClientLogBean.DestinationIP = DestinationIP;
    }

    public static void setPort(String Port) {
        ClientLogBean.Port = Port;
    }

    public static void setPolicy(String Policy) {
        ClientLogBean.Policy = Policy;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        ClientLogBean.user = user;
    }

    public static void setProtocol(String Protocol) {
        ClientLogBean.Protocol = Protocol;
    }

    public static void setTarget(String Target) {
        ClientLogBean.Target = Target;
    }
    
    public static String getZone() {
        return zone;
    }

    public static String getSourceIP() {
        return SourceIP;
    }

    public static String getDestinationIP() {
        return DestinationIP;
    }

    public static String getPort() {
        return Port;
    }

    public static String getPolicy() {
        return Policy;
    }

    public static String getProtocol() {
        return Protocol;
    }

    public static String getTarget() {
        return Target;
    }
    
    // Setter Method............................................................
    
    public static void setClientData(String SIP, String DIP, String port, String Plcy, String  Prot, String Trgt)
    {
    //  zone = z;
        SourceIP = SIP;
        DestinationIP = DIP;
        Port = port;
        Policy = Plcy;
        Protocol = Prot;
        Target = Trgt;
        
    }

//    Getter Method.............................................................
    
    public static String getClientData()
    {
        String zn = getZone();
        String sip = getSourceIP();
        String dip = getDestinationIP();
        String pr = getPort();
        String plc = getPolicy();
        String prt = getProtocol();
        String tgt = getTarget();
        
        String s1 =  zn+"\t"+sip+"\t"+dip+"\t"+pr+"\t"+plc+"\t"+prt+"\t"+tgt;
        
        return s1;
    }
}


