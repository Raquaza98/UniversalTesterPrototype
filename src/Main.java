
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.hyperic.sigar.SigarException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows
 */
public class Main {

    
    public static void main(String[] args) throws InterruptedException, SigarException {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
    method.setAccessible(true);   
    if (method.getName().startsWith("get")&& Modifier.isPublic(method.getModifiers())) {
            Object value;
        try {
            value = method.invoke(operatingSystemMXBean);
        } catch (Exception e) {
            value = e;
        } // try
        System.out.println(method.getName() + " = " + value);
    } // if
  } // for
  
        SystemListener s = new SystemListener();
        s.output(args);
        
        //Thread t = new Thread(new SystemListener(operatingSystemMXBean,"file.txt"));
        //t.start();
    }

    
    
}
