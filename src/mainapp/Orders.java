package mainapp;

import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Shuaib
 */
public class Orders extends javax.swing.JFrame {
    
    ArrayList<discounts> discountCodes = new ArrayList<discounts>();
    boolean discountCodeAvailable = false;

    public Orders() {
        initComponents();
        readFromFile();
        loadDiscounts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order Panel -  Eat out more often");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Customer ID", "Name", "Address", "Price", "Order Info", "Order Date", "Disccount Applied"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jTable1.setSelectionBackground(java.awt.Color.orange);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Orders Panel");

        jButton1.setBackground(java.awt.Color.orange);
        jButton1.setText("New Record");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.Color.orange);
        jButton2.setText("Delete Selected Item");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(java.awt.Color.orange);
        jButton3.setText("Update Selected Item");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(java.awt.Color.orange);
        jButton5.setText("Apply Discount");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3)))))
                        .addGap(0, 272, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        DefaultTableModel mainTable = (DefaultTableModel) jTable1.getModel();
        int rowCounter = mainTable.getRowCount();
        boolean isExisting = false;
 
        
        try{
            int orderID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the order ID"));
            int customerID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the customer's ID"));
            String fname = JOptionPane.showInputDialog("What is the customers name");
            String faddress = JOptionPane.showInputDialog("What is the address");
            float orderprice = Float.valueOf(JOptionPane.showInputDialog("What is the order total?"));
            String orderinfo = JOptionPane.showInputDialog("What is the order?");
            String orderdate = JOptionPane.showInputDialog("What is the date?");
            for(int i = 0; i<rowCounter;i++){
                if(Integer.valueOf(mainTable.getValueAt(i, 0).toString()) == orderID){
                    isExisting = true;
                    JOptionPane.showMessageDialog(null,"Order ID already exists!");
                }
            }
            
            if (isExisting == false){
                mainTable.addRow(new Object[]{orderID,customerID,fname,faddress,orderprice,orderinfo,orderdate,false});
                JOptionPane.showMessageDialog(null,"New Record Added");
            }
            else if(isExisting == true){
                JOptionPane.showMessageDialog(null,"The record was not added!");
            }
        }
        catch (HeadlessException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"An error occured!");
        }
        saveToFile();
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        DefaultTableModel rowselec = (DefaultTableModel) jTable1.getModel();
        int rowsel =jTable1.getSelectedRow();
        rowselec.removeRow(rowsel);
        saveToFile();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        DefaultTableModel rowselec = (DefaultTableModel) jTable1.getModel(); 
        int rowsel = jTable1.getSelectedRow();
        
        try{
            String fname = JOptionPane.showInputDialog("What is the customers name");
            Integer cid = Integer.valueOf(JOptionPane.showInputDialog("What is the customers ID"));
            String faddress = JOptionPane.showInputDialog("What is the address");
            float orderprice = Float.valueOf(JOptionPane.showInputDialog("What is the order total?"));
            String orderinfo = JOptionPane.showInputDialog("What is the order?");
            String orderdate = JOptionPane.showInputDialog("What is the date?");
            Boolean orderdiscount = Boolean.valueOf(JOptionPane.showInputDialog("Discount applied, true or false?"));
            
            rowselec.setValueAt(fname, rowsel, 2);
            rowselec.setValueAt(cid, rowsel, 1);
            rowselec.setValueAt(faddress, rowsel, 3);
            rowselec.setValueAt(orderprice, rowsel, 4);
            rowselec.setValueAt(orderinfo, rowsel, 5);
            rowselec.setValueAt(orderdate, rowsel, 6);
            rowselec.setValueAt(orderdiscount, rowsel, 7);
            JOptionPane.showMessageDialog(null, "Order updated");
            saveToFile();
        }
        catch(HeadlessException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "An error occured while updating the order!");
            
        }
         
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        
        DefaultTableModel maintable = (DefaultTableModel) jTable1.getModel(); 
        int rowsel = jTable1.getSelectedRow();
        try{
            if(discountCodeAvailable){
                
                boolean disapply = (boolean) maintable.getValueAt(rowsel, 7);
                
                if(!disapply){

                    String inputCode = String.valueOf(JOptionPane.showInputDialog("What is the discount code"));
                    boolean codecheck = false;

                    for (discounts disc : discountCodes) {

                        String dcodez = disc.getDiscountCode();
                        int activations = disc.getActivations();
                        float dpercent = disc.getDprice();


                        if(inputCode.equals(dcodez)){
                            System.out.println("Code found!");

                            if(0 < activations){
                                float oprice = (float) maintable.getValueAt(rowsel, 4);
                                float newprice = oprice - (oprice * dpercent) / 100;
                                maintable.setValueAt(newprice,rowsel,4);
                                disc.setActivations(activations -= 1);
                                maintable.setValueAt(true, rowsel, 7);
                                saveDiscounts();
                                saveToFile();
                                codecheck = true;
                                JOptionPane.showMessageDialog(null, "The discount was applied successfully");
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "There are no more activations!");
                                codecheck = true;
                            }
                        }
                    }
                    if (!codecheck){
                        JOptionPane.showMessageDialog(null, "This code was not found!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "You already have a discount applied!");
                }
            }
        }
        
        catch (HeadlessException ex){
        JOptionPane.showMessageDialog(null, "An error has occured while trying to apply discount!");
        } 
        
        
    }//GEN-LAST:event_jButton5MouseClicked

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
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Orders().setVisible(true);
            }
        });
        
    }
    
    public void readFromFile(){
        DefaultTableModel tableMain = (DefaultTableModel) jTable1.getModel();
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("L-^7zmfL[AtkA~{x");

        try {
			FileReader fr = new FileReader("orders.txt");
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				String templine = br.readLine();
                                String line = encryptor.decrypt(templine);
				String elements [] = line.split(",");
                                tableMain.addRow(new Object[]{Integer.valueOf(elements[0]), Integer.valueOf(elements[1]),  elements[2], elements[3], Float.valueOf(elements[4]), elements[5], elements[6], Boolean.valueOf(elements[7])});
			}
			br.close();
			fr.close();
		}
		catch(IOException e) {
			// no error message needed if file cannot be read!
		}
    }
    
    
    public void saveToFile(){
        try {
                    DefaultTableModel tableMain = (DefaultTableModel) jTable1.getModel();
                    BasicTextEncryptor encryptor = new BasicTextEncryptor();
                    encryptor.setPassword("L-^7zmfL[AtkA~{x");

			FileWriter fw = new FileWriter("orders.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< jTable1.getRowCount(); i++) {
                            String templine = String.valueOf(tableMain.getValueAt(i, 0)) + "," + String.valueOf(tableMain.getValueAt(i, 1)) + "," + tableMain.getValueAt(i, 2) + "," + tableMain.getValueAt(i, 3) + "," + String.valueOf(tableMain.getValueAt(i, 4)) + "," + tableMain.getValueAt(i, 5)+ "," +  tableMain.getValueAt(i, 6)+ "," + String.valueOf(tableMain.getValueAt(i, 7)) ;
                            String line = encryptor.encrypt(templine);
                            bw.append(line + "\n");
                        }
			bw.close();
			fw.close();
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error the orders cannot be exported to file!");
		}
    }
    
    
    public void loadDiscounts(){
        try {
			FileReader fr = new FileReader("discounts.txt");
			BufferedReader br = new BufferedReader(fr);
                        BasicTextEncryptor de = new BasicTextEncryptor();
                        de.setPassword("L,t5xs`zM\\A(\\Yg)");
			discountCodes.clear();
			while(br.ready()) {
				String templine = br.readLine();
                                String line = de.decrypt(templine);
				String elements [] = line.split(",");
                                discountCodes.add(new discounts(elements[0], Integer.valueOf(elements[1]), Float.valueOf(elements[2])));
			}
			br.close();
			fr.close();
                        discountCodeAvailable = true;
		}
		catch(IOException e) {
			// no error message needed if file cannot be read!
		}
    }
    private void saveDiscounts() {
            try {
                    FileWriter fw = new FileWriter("discounts.txt");
                    BufferedWriter bw = new BufferedWriter(fw);
                    BasicTextEncryptor de = new BasicTextEncryptor();
                    de.setPassword("L,t5xs`zM\\A(\\Yg)");
                        
                    for (discounts dc:discountCodes) {
                        String templine = String.join(",", dc.getDiscountCode(), String.valueOf(dc.getActivations()), String.valueOf(dc.getDprice()));
                        String line = de.encrypt(templine);
                        bw.append(line +"\n");
                    }
                    bw.close();
                    fw.close();

            }
            catch(IOException e) {
                    JOptionPane.showMessageDialog(null, "An error has occured while trying to write to file!");
            }

    }    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
