
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoundedRangeModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Windows
 */
public class SimpleTimer implements Runnable{
    BoundedRangeModel editor;
    int timeEnd;
    
    public SimpleTimer(BoundedRangeModel editor, int timeEnd){
        this.editor = editor;
        this.timeEnd=timeEnd;
    }
    
    public void run(){
        while(SystemListener.working()){
            try {
                while(editor.getValue()<timeEnd){
                    TimeUnit.SECONDS.sleep(1);
                    editor.setValue(editor.getValue()+1);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleTimer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        editor.setValue(timeEnd);
    }
}
