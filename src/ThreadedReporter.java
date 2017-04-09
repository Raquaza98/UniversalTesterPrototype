
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


/**
 *
 * @author Gasperini "Raquaza98" Luca
 */


public class ThreadedReporter extends javax.swing.JFrame implements Runnable{

    private String fileName, results;
    private boolean executed=false, CPUGraphView=true, RAMGraphView=true;
    private Graphics graphRAM, graphCPU;
    
    private Double [] CPUvals = new Double[4], RAMvals = new Double[4];
    private long CPUnAvg=0, RAMnAvg=0, nLines=0;
    /**
     * Creates new form ThreadedReporter
     */
    public ThreadedReporter() {
        initComponents();
    }
    
    public ThreadedReporter(String fileName) {
        this.fileName=fileName;
        
        
    }
    
    public ThreadedReporter(String fileName, int i) {
        this.fileName=fileName;   
        initComponents();
        CPUvals[0]=Double.parseDouble("0");
        CPUvals[3]=Double.parseDouble("0");
        RAMvals[0]=Double.parseDouble("0");
        RAMvals[3]=Double.parseDouble("0");
    }

    public void run(){
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThreadedReporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThreadedReporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThreadedReporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThreadedReporter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThreadedReporter(fileName,1).setVisible(true);
                
            }
        });
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        canvas1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        canvas2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jScrollPane1.setAlignmentX(0.7F);
        jScrollPane1.setDoubleBuffered(true);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(32767, 32767));

        canvas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout canvas1Layout = new javax.swing.GroupLayout(canvas1);
        canvas1.setLayout(canvas1Layout);
        canvas1Layout.setHorizontalGroup(
            canvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        canvas1Layout.setVerticalGroup(
            canvas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(canvas1);

        jScrollPane3.setAlignmentX(0.3F);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(200, 150));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setMaximumSize(new java.awt.Dimension(160, 75));
        jScrollPane3.setViewportView(jTextArea1);

        jScrollPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jScrollPane2ComponentMoved(evt);
            }
        });

        javax.swing.GroupLayout canvas2Layout = new javax.swing.GroupLayout(canvas2);
        canvas2.setLayout(canvas2Layout);
        canvas2Layout.setHorizontalGroup(
            canvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        canvas2Layout.setVerticalGroup(
            canvas2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(canvas2);

        jToggleButton1.setText("swapGraph");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("swapGraph");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("reloadGraph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("reloadGraph");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToggleButton2)
                    .addComponent(jButton2))
                .addGap(5, 5, 5))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1)
                            .addComponent(jToggleButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if(!executed){
            GetReport();
        }
        ShowResults();
        executed=true;
    }//GEN-LAST:event_formMouseEntered

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        GetReport();
    }//GEN-LAST:event_formComponentResized

    private void jScrollPane2ComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane2ComponentMoved
        Graphics _g = canvas2.getGraphics();
        _g = graphCPU;
    }//GEN-LAST:event_jScrollPane2ComponentMoved

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        RAMGraphView=!RAMGraphView;
        drawGraph(canvas1, true, RAMGraphView);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        CPUGraphView=!CPUGraphView;
        drawGraph(canvas2, false, CPUGraphView);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        drawGraph(canvas1, true, RAMGraphView);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        drawGraph(canvas2, false, CPUGraphView);
    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void GetReport(){
           drawGraph(canvas1, true, RAMGraphView);
           drawGraph(canvas2, false, CPUGraphView);
    
    
    } 
    
    
    
    
    private Long[] GetBounds(){         //Function to get the limit values 
        FileReader f = null;
        BufferedReader fIN = null;
        String s;
        StringTokenizer st;
        
    try{
        f=new FileReader(fileName);
        fIN= new BufferedReader(f);
    }catch(IOException e){
        System.out.println("Errore nell'apertura del file");
        System.exit(1);
    }
        
    
    Long[] r =new Long[2];
    
    try{
        s=fIN.readLine();
        st=new StringTokenizer(s, "|");
        r[1]= Long.parseLong(st.nextToken());
        r[0]= Long.parseLong(st.nextToken());
        
        
    }
    catch(IOException e){
         System.out.println("Errore nella lettura del file");
        System.exit(1);
    }
    try {
        f.close();
    }catch (IOException e){
         System.out.println("Errore nella chiusura del file");
        System.exit(1);
    }
    
    if(!executed){
        results =("Secondi passati : "+r[0]+" s - Valore massimo Memoria : "+r[1]+" MB\r\n");
    }
        
    return r;
    }   
    
    private int calculateProp(int Value, int Width, int MaxVal){        //Functions to calculate the right value to fit into the graph depending on the given values
        return (Value*Width)/MaxVal;
    }
    private int calculatePropInv(int Value, int Width, int MaxVal){
        return Width - (Value*Width)/MaxVal;
    }
    
    
    
    private void drawGraph(javax.swing.JPanel graphCanvas,  boolean type , boolean view){
        
        FileReader f = null;
        BufferedReader fIN = null;
        String s;
        StringTokenizer st;
        
        Long[] rect;            //Getting limit values of the test (time in s and number of lines)
        rect = GetBounds();
        
    
        Graphics g = graphCanvas.getGraphics(); //I get canvas graphic control
        
        Rectangle Bounds = graphCanvas.getBounds();
        
        g.clearRect(0, 0, Bounds.width, Bounds.height);
        
        
        
        g.setColor(Color.black);
        g.drawLine(1, Bounds.height, 1, Bounds.y);                                    //Drawing x and y axis
        g.drawLine(1, Bounds.height-1, Bounds.width-1, Bounds.height-1);
        
        if(type){ g.drawString("Memoria usata scala 1:1024 MB", 1, 10);}      //Scrivo la scala usata per gli assi
        else {g.drawString("Percentuale uso CPU scala 1:"+calculateProp(1,Bounds.height,100), 1, 10);}
        
        g.drawString("Secondi test scala 1:"+calculateProp(1,Bounds.width, rect[0].intValue())+" s", Bounds.width-150, Bounds.height-10);
        
        
        if(type){
        for(int j=1;j<rect[1].intValue();j+=1024){            //Disegno dei marcatori ogni 10 punti di ogni asse
            int _tempPropYBound = calculatePropInv(j, Bounds.height, rect[1].intValue());
            g.drawLine(1, _tempPropYBound, 3, _tempPropYBound);
            
        }}else{
        
        for(int j=1;j<100;j+=10){
            int _tempPropYBound = calculatePropInv(j, Bounds.height, 100);
            g.drawLine(1, _tempPropYBound, 3, _tempPropYBound);
            
        }}
        
        for(int j=1;j<Bounds.width;j+=10){
            g.drawLine(Bounds.width-j, Bounds.height-2, Bounds.width-j, Bounds.height-4);
            
        }
        
        g.setColor(Color.green);
        
        
    
        Long _yValue, _yMem=Long.parseLong("0"), _yMemStart=Long.parseLong("0");
        
        int _xValue=0,__xValue=1;
    try{
        f=new FileReader(fileName);
        fIN= new BufferedReader(f);
    }catch(IOException e){
        System.out.println("Errore nell'apertura del file");
    }
        
    boolean first =true;
    
    
    if(!executed){
       
        
        if(type){
            RAMvals[1]=Double.parseDouble("0");
            RAMvals[2]=Double.MAX_VALUE;
        }else{
            CPUvals[1]=Double.parseDouble("0");
            CPUvals[2]=Double.MAX_VALUE;
        }
    }
    
    
        //Start drawing the graph by reading the file
        
    try{
        s=fIN.readLine();
        s=fIN.readLine();
        while(s != null){
            st=new StringTokenizer(s, "|");    
                        
            if(!type) st.nextToken();
            
            _yValue =_yMem;
            _yMem = Long.parseLong(st.nextToken());
            
            
            if(!executed){
            
            if(type){
                if(_yMem>RAMvals[1]){
                    RAMvals[1]=_yMem.doubleValue();
                }else if(_yMem<RAMvals[2]){
                    RAMvals[2]=_yMem.doubleValue();
                }
                RAMvals[3]+=_yMem.doubleValue();
            }else{
                if(_yMem>CPUvals[1]){
                    CPUvals[1]=_yMem.doubleValue();
                }else if(_yMem<CPUvals[2]){
                    CPUvals[2]=_yMem.doubleValue();
                }
                CPUvals[3]+=_yMem.doubleValue();
            }
            nLines++;
            }
            
            
            if(first){
                _yMemStart = _yMem;
                _yMem = Long.parseLong("0");
            }else{
               if(!view) _yMem = _yMem-_yMemStart;
            }
            
            
            int _xValueProp = calculateProp(_xValue,Bounds.width, rect[0].intValue());     //I get the test's values and transform them to fit them inside the graph
            int __xValueProp = calculateProp(__xValue,Bounds.width, rect[0].intValue());
            int _yValueProp, _yMemProp;
            
            if(type){
                _yValueProp = calculatePropInv(_yValue.intValue(),Bounds.height, rect[1].intValue());
                _yMemProp = calculatePropInv(_yMem.intValue(),Bounds.height, rect[1].intValue());
            }else{
                _yValueProp = calculatePropInv(_yValue.intValue(),Bounds.height, 100);
                _yMemProp = calculatePropInv(_yMem.intValue(),Bounds.height, 100);
            }
            
            
            if(first){          //First value starts from the 0 value of the graph
                _yValueProp= Bounds.height-1;
                first=false;
            }
            
            g.drawLine(_xValueProp,_yValueProp , __xValueProp, _yMemProp);
            
            
            
            _xValue++;
            __xValue++;
            s=fIN.readLine();
        }
    }
    catch(IOException e){
         System.out.println("Errore nella lettura del file");
        System.exit(1);
    }
    try {
        f.close();
    }catch (IOException e){
         System.out.println("Errore nella chiusura del file");
        System.exit(1);
    } 
    if(!executed){
    
    if(type){
        RAMvals[0]=RAMvals[3]/nLines;
        RAMnAvg = getNUnderAvg(RAMvals[0], type);
        graphRAM = g.create();
    }else{
        CPUvals[0]=CPUvals[3]/nLines;
        CPUnAvg = getNUnderAvg(CPUvals[0], type);
        graphCPU = g.create();
    }
    }
    
    }
    
    private long getNUnderAvg(double avg, boolean type){
        FileReader f = null;
        BufferedReader fIN = null;
        String s;
        StringTokenizer st;
        long _n=0;
        
        try{
        f=new FileReader(fileName);
        fIN= new BufferedReader(f);
    }catch(IOException e){
        System.out.println("Errore nell'apertura del file");
    }
       try{
        s=fIN.readLine();
        s=fIN.readLine();
        while(s != null){
            st=new StringTokenizer(s, "|");    
            if(!type)   st.nextToken();
            
            if(Long.parseLong(st.nextToken())<=avg) _n++;
            s=fIN.readLine();
        }
                
        }catch(IOException e){
         System.out.println("Errore nella lettura del file");
        System.exit(1);
    }
    try {
        f.close();
    }catch (IOException e){
         System.out.println("Errore nella chiusura del file");
        System.exit(1);
    } 
            
        return _n;
    }
    
    private void ShowResults(){
        
        jTextArea1.setText(results+"Valore medio RAM: "+RAMvals[0]+" MB - Valore massimo : "+RAMvals[1] +" - Valore efficenza (<0.5 non efficiente): "+RAMvals[0]/RAMvals[1]+" - \r\nValore medio CPU: "+CPUvals[0]+"");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel canvas1;
    private javax.swing.JPanel canvas2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
