
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
            p = rt.exec(pPath);     //Fa partire il file
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
        long[] Pids = this.sigar.getProcList();     //Ottiene la lista di processi attivi sul pc
        int i=0;
        long fPid=0;
        boolean found =false;
        //System.out.println(Arrays.toString(this.sigar.getProcList()));
        while(Pids.length>i && !found){         //Cerca il processo nel sistema
            //System.out.println(this.sigar.getProcState(Pids[i]));
            if(this.sigar.getProcState(Pids[i]).getName().equals(pName)){
                fPid = Pids[i];
                found = true;
            }            
            i++;
        }
        //System.out.println(fPid);
        
        while(exit){            //Ogni secondo ottiene informazioni sul sistema e le inserisce nel sistema
            Mem m = this.sigar.getMem();
            CpuPerc c = this.sigar.getCpuPerc();
            try {
                Long Ram = (Long) m.getRam(), Free = (Long) m.getFree(), Used = (Long) m.getUsed();
                Double CpuT = c.getCombined(), CpuI = c.getIdle();
                           
                
                
                f.write(Ram+"|"+MBconversion(Free)+"|"+MBconversion(Used)+"|"+fPid+"|"+this.sigar.getProcState(fPid).toString()+"|"+CpuConversion(CpuT)+"|"+CpuConversion(CpuI));
                f.write("\r\n");
                f.flush();
                TimeUnit.SECONDS.sleep(1);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            timeTot++;
            if(timeTot>time)  exit=false;  //Raggiunto il tempo massimo esce
        }
        try {
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(SystemListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        alive=false;
        MainFrame.end();        //Avvisa il Frame principale la fine del test
    }
    
    private static String MBconversion(long bytes) {
        String _tempString = bytes / Math.pow(1024, 2)+"";        
        return _tempString.substring(0, _tempString.indexOf("."));
}
    
    private static String CpuConversion(Double data){
        data = data*100;
        String _tempString = data.toString();
        return _tempString.substring(0, _tempString.indexOf("."));
    }
    

    public static boolean working(){    //Variabile per il timer
        return alive;
    }

}
