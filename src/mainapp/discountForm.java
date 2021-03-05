package mainapp;

import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

/**
 *
 * @author Shuaib
 */
public class discountForm extends javax.swing.JFrame {

    public discountForm() {
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
        setTitle("Discount Panel -  Eat out 2 help out");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Activations Number", "Percentage Off %"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Discounts Panel");

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
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(201, Short.MAX_VALUE))
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
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        DefaultTableModel mainTable = (DefaultTableModel) jTable1.getModel();
        int rowCounter = mainTable.getRowCount();
        boolean isExisting = false;
 
        
        try{
            String dcode = JOptionPane.showInputDialog("What is the discount code");
            int Activations = Integer.valueOf(JOptionPane.showInputDialog("How many times can this code be used"));
            float dpercent = Float.valueOf(JOptionPane.showInputDialog("What is percentage off integer"));
            
            for(int i = 0; i<rowCounter;i++){
                if(mainTable.getValueAt(i, 0).toString() == dcode){
                    isExisting = true;
                    JOptionPane.showMessageDialog(null,"Discount code already exists!");
                }
            }
            
            if (isExisting == false){
                mainTable.addRow(new Object[]{dcode,Activations,dpercent});
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
            String dcode = JOptionPane.showInputDialog("What is the discount code");
            int Activations = Integer.valueOf(JOptionPane.showInputDialog("How many times can this code be used"));
            float dpercent = Float.valueOf(JOptionPane.showInputDialog("What is percentage off integer"));
            
            rowselec.setValueAt(dcode, rowsel, 0);
            rowselec.setValueAt(Activations, rowsel, 1);
            rowselec.setValueAt(dpercent, rowsel, 2);
            JOptionPane.showMessageDialog(null, "Code updated");
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
            java.util.logging.Logger.getLogger(discountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(discountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(discountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(discountForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new discountForm().setVisible(true);
            }
        });
        
    }
    
    public void readFromFile(){
        DefaultTableModel tableMain = (DefaultTableModel) jTable1.getModel(); 

        try {
			FileReader fr = new FileReader("discounts.txt");
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				String line = br.readLine();
				String elements [] = line.split(",");
                                tableMain.addRow(new Object[]{elements[0], Integer.valueOf(elements[1]), Float.valueOf(elements[2])});
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

			FileWriter fw = new FileWriter("discounts.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< jTable1.getRowCount(); i++) {
                            bw.append(String.valueOf(tableMain.getValueAt(i, 0)) + "," + String.valueOf(tableMain.getValueAt(i, 1)) + "," + String.valueOf(tableMain.getValueAt(i, 2)) + "\n");
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
