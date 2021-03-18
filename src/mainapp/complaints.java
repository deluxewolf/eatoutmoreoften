package mainapp;

import java.awt.HeadlessException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Shuaib
 */
public class complaints extends javax.swing.JFrame {

    public complaints() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Complaints Panel -  Eat out more often");
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Complaint ID", "Customer ID Number", "Solved?", "Comment", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Complaints Panel");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(291, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
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
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        DefaultTableModel mainTable = (DefaultTableModel) jTable1.getModel();
        int rowCounter = mainTable.getRowCount();
        boolean isExisting = false;
 
        
        try{
            int comcode = Integer.valueOf(JOptionPane.showInputDialog("Please enter the complaint ID"));
;           int cid = Integer.valueOf(JOptionPane.showInputDialog("what is the customer ID?"));
            boolean isHandled = Boolean.valueOf(JOptionPane.showInputDialog("Is the case handled true or false"));
			String cDate = JOptionPane.showInputDialog("What date was the complaint made?");
            String ccomment= JOptionPane.showInputDialog("Any additional comments?");
            for(int i = 0; i<rowCounter;i++){
                if(mainTable.getValueAt(i, 0).equals(comcode)){
                    isExisting = true;
                    JOptionPane.showMessageDialog(null,"Complaint ID already exists!");
                }
            }
            
            if (isExisting == false){
                mainTable.addRow(new Object[]{comcode,cid,isHandled,ccomment,cDate});
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
			int cid = Integer.valueOf(JOptionPane.showInputDialog("what is the customer ID?"));
            boolean isHandled = Boolean.valueOf(JOptionPane.showInputDialog("Is the case handled true or false"));
			String cDate = JOptionPane.showInputDialog("What date was the complaint made?");
            String ccomment= JOptionPane.showInputDialog("Any additional comments?");
            
            rowselec.setValueAt(cid, rowsel, 1);
            rowselec.setValueAt(isHandled, rowsel, 2);
            rowselec.setValueAt(ccomment, rowsel, 3);
			rowselec.setValueAt(cDate, rowsel, 4);
            JOptionPane.showMessageDialog(null, "Complaint updated");
            saveToFile();
        }
        catch(HeadlessException | NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "An error occured while updating the complaint!");
            
        }
         
    }//GEN-LAST:event_jButton3MouseClicked

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
            java.util.logging.Logger.getLogger(complaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(complaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(complaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(complaints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new complaints().setVisible(true);
            }
        });
        
    }
    
    public void readFromFile(){
        DefaultTableModel tableMain = (DefaultTableModel) jTable1.getModel();
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("7$VX8q[p{;.t'!=X");

        try {
			FileReader fr = new FileReader("complaints.txt");
			BufferedReader br = new BufferedReader(fr);
			while(br.ready()) {
				String templine = br.readLine();
                                String line = encryptor.decrypt(templine);
				String elements [] = line.split(",");
                                tableMain.addRow(new Object[]{Integer.valueOf(elements[0]), Integer.valueOf(elements[1]), Boolean.valueOf(elements[2]), elements[3]});
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
                    encryptor.setPassword("7$VX8q[p{;.t'!=X");

			FileWriter fw = new FileWriter("complaints.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i< jTable1.getRowCount(); i++) {
                            String templine = String.valueOf(tableMain.getValueAt(i, 0)) + "," + String.valueOf(tableMain.getValueAt(i, 1)) + "," + String.valueOf(tableMain.getValueAt(i, 2) + "," + String.valueOf(tableMain.getValueAt(i, 3)));
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
