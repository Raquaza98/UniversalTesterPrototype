
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.SigarPermissionDeniedException;

/**
 *
 * @author Gasperini "Raquaza98" Luca
 */
public class SystemListener implements Runnable {
    private FileWriter f;
    private static String pPath, pName;
    private static boolean alive=true, Exe = false;
    private static int time;
    private Long fPid = 0l;
    private boolean found =false;
    
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

    
    public void run() {
        Sigar sigar = new Sigar();
        int timeTot=0;
        boolean exit=true;
        Process p;
        
        Runtime rt = Runtime.getRuntime();  
        try {
            p = rt.exec(pPath);     //Starting the program to test
            
        } catch (IOException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.WARNING, null, ex);
        } 
        
        int timeCheck = 1;
        
        while (!found){     //Until the program is found the test will not start
            try{
                TimeUnit.SECONDS.sleep(timeCheck);
            }   catch (InterruptedException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.WARNING, null, ex);
            }
            System.out.println(pName);
            try {
                long[] Pids = sigar.getProcList();     //Function to get the process list and search the tested program
                int i=0;
                while(Pids.length>i && !found){
                    if(sigar.getProcState(Pids[i]).getName().equals(pName)){
                        fPid = Pids[i];
                        found = true;
                    }
                    i++;
                }
            }catch (SigarException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeCheck++;
            System.out.println("Programma non trovato. Prossimo controllo tra "+timeCheck);
        }
        
        System.out.println("Programma trovato");
        
        try {
            f.write(sigar.getMem().getRam()+"|"+time+"|"+fPid+"|"+sigar.getProcState(fPid)+"\r\n");
            f.flush();
        } catch (IOException | SigarException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        while(exit){                        
            try {            //Every second infos of system gets written on a file
            Exe = true;
            Mem m = sigar.getMem();
            CpuPerc c = sigar.getCpuPerc();
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
        } catch (SigarException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public static boolean inExe(){    //Function for the timer interaction
        return Exe;
    }

    public static boolean working(){    //Function for the timer interaction
        return alive;
    }

}
