
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarPermissionDeniedException;
import org.hyperic.sigar.cmd.SigarCommandBase;

/**
 *
 * @author Gasperini "Raquaza98" Luca
 */
public class SystemListener extends SigarCommandBase implements Runnable {
    //private OperatingSystemMXBean o;      Part of a older prototype
    private FileWriter f;
    private static String pPath, pName;
    private static boolean alive=true;
    private static int time;
    
    SystemListener(){
        
    }
    
    SystemListener(String f, String pPath, int time, String pName){
        this.pPath=pPath;
        this.pName=pName;
        this.time = time;
        try {
            this.f= new FileWriter(f, true);
        } catch (IOException ex) {
            try{
                this.f = new FileWriter(f, false);
            }catch(IOException exx){
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, exx);
            }
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*SystemListener(OperatingSystemMXBean o, String f) {
        this.o=o;
        try {
            this.f= new FileWriter(f, true);
        } catch (IOException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    
    public void run() {
        try {
            output(null);
        } catch (SigarException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*private void oldrun(){
        while(true){
        for (Method method : o.getClass().getDeclaredMethods()) {
            method.setAccessible(true);   
            if (method.getName().startsWith("get")&& Modifier.isPublic(method.getModifiers())) {
                Object value;
                try {
                    value = method.invoke(o);
                } catch (Exception e) {
                    value = e;
                } // try
                try {
                    f.write(value+"|");
                } catch (IOException ex) {
                    Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            } // if
        }
            try {
                f.write("\r\n");
            } catch (IOException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
            }
    }}*/
    
    public void output(String[] args) throws SigarException, SigarPermissionDeniedException {
        int timeTot=0;
        boolean exit=true;
        Process p;
        Runtime rt = Runtime.getRuntime();  
        try {
            p = rt.exec(pPath);     //Starting the program to test
            /*OutputStream outC = p.getOutputStream ();
            BufferedWriter printOut = new BufferedWriter(new OutputStreamWriter(outC));
            printOut.write("cd C:");
            printOut.write("C:/Users/Windows/Documents/NetBeansProjects/UniversalTesterPrototype/test.bat -v");
            System.out.println(rt.toString());*/
            TimeUnit.SECONDS.sleep(1);
        } catch (IOException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        long[] Pids = this.sigar.getProcList();     //I get the process list and search the tested program
        int i=0;
        long fPid=0;
        boolean found =false;
        //System.out.println(Arrays.toString(this.sigar.getProcList()));
        while(Pids.length>i && !found){      
            //System.out.println(this.sigar.getProcState(Pids[i]));
            if(this.sigar.getProcState(Pids[i]).getName().equals(pName)){
                fPid = Pids[i];
                found = true;
            }            
            i++;
        }
        //System.out.println(fPid);
        try {
            f.write(this.sigar.getMem().getRam()+"|"+time+"|"+fPid+"|"+this.sigar.getProcState(fPid)+"\r\n");
            f.flush();
        } catch (IOException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        while(exit){            //Every second infos of system gets written on a file
            Mem m = this.sigar.getMem();
            CpuPerc c = this.sigar.getCpuPerc();
            try {
                Long Free = (Long) m.getFree(), Used = (Long) m.getUsed();
                Double CpuT = c.getUser(), CpuI = c.getIdle();
                           
                
                
                f.write(MBconversion(Used)+"|"+CpuConversion(CpuT));
                f.write("\r\n");
                f.flush();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeTot++;
            if(timeTot>time)  exit=false;  //When time runs out the program exits and saves the file
        }
        try {
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        alive=false;
        MainFrame.end();        //It will also signal the Main frame the end of the test
    }
    
    private static String MBconversion(long bytes) {        //Functions for conversion of long values into a readable format
        String _tempString = bytes / Math.pow(1024, 2)+"";        
        return _tempString.substring(0, _tempString.indexOf("."));
}
    
    private static String CpuConversion(Double data){
        data = data*100;
        String _tempString = data.toString();
        return _tempString.substring(0, _tempString.indexOf("."));
    }
    

    public static boolean working(){    //Function for the timer interaction
        return alive;
    }

}
