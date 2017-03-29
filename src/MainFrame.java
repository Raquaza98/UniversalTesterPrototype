
/**
 *
 * @author Gasperini "Raquaza98" Luca
 * 
 */

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainFrame extends javax.swing.JFrame{
    final JFileChooser fc = new JFileChooser();
    
    private static int nInst;
    private static String startTime;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        jProgressBar1.setVisible(false);        //Hide the progress bar to remove clutter on the frame
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Pname = new javax.swing.JLabel();
        Ppath = new javax.swing.JLabel();
        openButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jProgressBar1 = new javax.swing.JProgressBar();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openButton.setText("Seleziona File");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        jButton2.setText("Inizia Test");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        log.setColumns(20);
        log.setRows(5);
        jScrollPane1.setViewportView(log);

        jLabel1.setText("Durata Test in secondi");

        jLabel2.setText("Nome Programma");

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });

        jButton1.setText("Apri Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Ppath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(openButton))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(openButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Ppath, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(Pname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addGap(26, 26, 26)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        //Handle open button action.
        String newline="\r\n";
    if (evt.getSource() == openButton) {
        int returnVal = fc.showOpenDialog(MainFrame.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            Ppath.setText(file.getAbsolutePath());
            Pname.setText(file.getName());
            
            log.append("File selezionato: " + file.getName() + "." + newline);
        } else {
            log.append("" + newline);
        }}
    }//GEN-LAST:event_openButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(Ppath.getText().isEmpty() || Pname.getText().isEmpty() || (int)jSpinner1.getValue()<30){
            log.append("Valori non completi e/o non validi");
        }else{
            
            jProgressBar1.setMaximum((int)jSpinner1.getValue());        //Show and start progress bar
            jProgressBar1.setValue(0);
            jProgressBar1.setVisible(true);
            
            Thread t = new Thread(new SimpleTimer(jProgressBar1.getModel(), (int)jSpinner1.getValue()));    //Starting thread that handles progress bar 
            
        
            nInst = SearchProgramTestLog(Pname.getText());  //Get infos on previous tests for indexing the current one
            startTime = currentTime();      //Get the start time of the test
        
            //Creating and starting the test thread with the necessary infos (savefile name, program path, time limit, program name)
            String _listenerFileName = "TestLog "+Pname.getText()+" N "+nInst+".txt";
            
            SystemListener central = new SystemListener(_listenerFileName, Ppath.getText(), (int)jSpinner1.getValue(), Pname.getText());
             
                t.start();
                Thread tt= new Thread(central);
                tt.start();
                    
            
            
            
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ThreadedReporter t = new ThreadedReporter("TestLog "+(String) jComboBox1.getSelectedItem()+".txt");
        Thread tt = new Thread(t);  //Starting the report with the savefile name to view
        tt.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        fileCheck();            //Everytime the mouse enters the combobox, the file with the log of the savefiles gets visualized and the results get inserted into the combobox
        FileReader f = null;
        BufferedReader fIN = null;
        String s;
        StringTokenizer st;
        boolean exist=false;
        
        
    try{
        f=new FileReader("UTProgramLogs.txt");
        fIN= new BufferedReader(f);
    }catch(IOException e){
        System.out.println("Errore nell'apertura del file");
        System.exit(1);
    }
    
    try{
        s=fIN.readLine();
        while(s != null){
            st=new StringTokenizer(s, "|");
            String stt = st.nextToken();
            String sttN = st.nextToken();
            for(int i=0;i<jComboBox1.getItemCount();i++){
                if(jComboBox1.getItemAt(i).equals(stt+" N "+sttN)){
                    exist=true;
                }
            }
            if(!exist){
                jComboBox1.addItem(stt+" N "+sttN);
            }else{
                exist=false;
            }            
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
    
    
    }//GEN-LAST:event_jComboBox1MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    
    private static void SaveTestLog(String line){       //Function to put the log of the test into the log file
        FileWriter f;
        try {
            f= new FileWriter("UTProgramLogs.txt", true);
            f.write(line);
            f.flush();
            f.close();
        } catch (IOException ex) {
            System.out.println("File non trovato");          
        }               
    }
    
    private static void fileCheck(){    //Function to see if the log file exists and if not the program will create it
        FileWriter f;
        try {
            f= new FileWriter("UTProgramLogs.txt", true);
           f.close();
        } catch (IOException ex) {
            System.out.println("File non trovato, creazione file");
            try{
                f= new FileWriter("UTProgramLogs.txt", false);
                f.close();
            }
            catch(IOException exx){
                System.out.println("Fallita creazione file, spegnimento programma");
                exx.printStackTrace();
                System.exit(1);
            }
          
        }
        
    }
    
    private static int SearchProgramTestLog(String programName){    //Search the program name inside the log file and returns its index
        fileCheck();
        FileReader f = null;
        BufferedReader fIN = null;
        String s;
        StringTokenizer st;
        boolean exists=false;
        int nInst=0;
        
    try{
        f=new FileReader("UTProgramLogs.txt");
        fIN= new BufferedReader(f);
    }catch(IOException e){
        System.out.println("Errore nell'apertura del file");
        System.exit(1);
    }
        
    
    try{
        s=fIN.readLine();
        while(s != null){
            st=new StringTokenizer(s, "|");
            if(programName.equals(st.nextToken())){
                exists=true;
                nInst++;
            }
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
    
    if(exists){
        System.out.println("Trovato programma, bentornato nel campo da test");
        return nInst;
    }
    else{
        System.out.println("Nuovo programma! Felice di averti nel sistema");
        return 0;
    }
    }   
   

    private static String currentTime() {   //Function to get the system's time
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(cal.getTime());
    }
    
    public static void end(){   //Function of end test and save log
        String fileName = Pname.getText()+ "|" + (nInst) + "|" + startTime + "|" + currentTime()+"\r\n";
        SaveTestLog(fileName);
        log.append("Esecuzione terminata");
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel Pname;
    private javax.swing.JLabel Ppath;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private static javax.swing.JTextArea log;
    private javax.swing.JButton openButton;
    // End of variables declaration//GEN-END:variables
}
