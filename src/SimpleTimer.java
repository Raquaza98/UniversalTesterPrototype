
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;

/**
 *
 * @author Gasperini "Raquaza98" Luca
 */
public class SimpleTimer implements Runnable{
    BoundedRangeModel editor;
    int timeEnd;
    
    public SimpleTimer(BoundedRangeModel editor, int timeEnd){
        this.editor = editor;
        this.timeEnd=timeEnd;
    }
    
    public void run(){
        editor.setValue(editor.getMinimum()); //Resets progress bar
        while(!SystemListener.inExe()){ //Wait until program is found working
            try{
                TimeUnit.SECONDS.sleep(1);
            }   catch (InterruptedException ex) {
                Logger.getLogger(SystemListener.class.getName()).log(Level.WARNING, null, ex);
            }
        }
        while(SystemListener.working()){    //Work until the test ends
            try {
                while(editor.getValue()<timeEnd){
                    TimeUnit.SECONDS.sleep(1);
                    editor.setValue(editor.getValue()+1);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        editor.setValue(timeEnd);   //In case test ends early
    }
}
