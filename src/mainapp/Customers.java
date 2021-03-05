package mainapp;

import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.*;

/**
 *
 * @author Shuaib
 */
public class Customers extends javax.swing.JFrame {
    

    public Customers() {
        initComponents();
        readFromFile();
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
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Panel -  Eat out 2 help out");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Address", "Payment Method"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Customers Panel");

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

        jButton4.setText("Exit");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(236, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        DefaultTableModel mainTable = (DefaultTableModel) jTable1.getModel();
        int rowCounter = mainTable.getRowCount();
        boolean isExisting = false;
 
        
        try{
            int orderID = Integer.valueOf(JOptionPane.showInputDialog("Please enter the customer ID"));
            String fname = JOptionPane.showInputDialog("What is the customers name");
            String faddress = JOptionPane.showInputDialog("What is the address");
            String pmethod = JOptionPane.showInputDialog("What is the default payment method?");
            for(int i = 0; i<rowCounter;i++){
                if(Integer.valueOf(mainTable.getValueAt(i, 0).toString()) == orderID){
                    isExisting = true;
                    JOptionPane.showMessageDialog(null,"Customer ID already exists!");
                }
            }
            
            if (isExisting == false){
                mainTable.addRow(new Object[]{orderID,fname,faddress,pmethod});
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
            String faddress = JOptionPane.showInputDialog("What is the address");
            String pmethod = JOptionPane.showInputDialog("What is the default payment method?");
            
            rowselec.setValueAt(fname, rowsel, 1);
            rowselec.setValueAt(faddress, rowsel, 2);
            rowselec.setValueAt(pmethod, rowsel, 3);
            JOptionPane.showMessageDialog(null, "Info updated");
            saveToFile();
        }
        catch(HeadlessException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "An error occured while updating the order!");
            
        }
         
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        saveToFile();
        mainApp dashboardapp = new mainApp();
        dashboardapp.main(null);
        this.dispose();
        
    }//GEN-LAST:event_jButton4MouseClicked

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
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Customers().setVisible(true);
            }
        });
        
    }
    
    public void readFromFile(){
        DefaultTableModel tableMain = (DefaultTableModel) jTable1.getModel(); 

        try {
			FileReader fr = new FileReader("customers.txt");
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				String line = br.readLine();
				String elements [] = line.split(",");
                                tableMain.addRow(new Object[]{Integer.valueOf(elements[0]), elements[1], elements[2], elements[3]});
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

			FileWriter fw = new FileWriter("customers.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< jTable1.getRowCount(); i++) {
                            bw.append(String.valueOf(tableMain.getValueAt(i, 0)) + "," + tableMain.getValueAt(i, 1) + "," + tableMain.getValueAt(i, 2)+ "," +  tableMain.getValueAt(i, 3)+ "," + "\n");
                        }
			bw.close();
			fw.close();
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error the orders cannot be exported to file!");
		}
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
