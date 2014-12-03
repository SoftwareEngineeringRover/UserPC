/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userpc;

import communication.Client;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Eddy
 */
public class RoverGUI extends javax.swing.JFrame {

    /**
     * Creates new form RoverGUI
     */
    public RoverGUI() {
        initComponents();
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
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        GuessButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Command PC");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 490, 490));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 480, 490));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton1.setText("Front");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, 30));

        jButton2.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton2.setText("Rear");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 211, 90, 30));

        jButton3.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton3.setText("Tower");
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 251, 90, 30));

        jButton4.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton4.setText("Left");
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 291, 90, 30));

        jButton5.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton5.setText("Right");
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 331, 90, 30));

        jButton6.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton6.setText("Front Left");
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 373, 90, 30));

        jButton7.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton7.setText("Front Right");
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 415, 90, 30));

        jButton8.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton8.setText("Rear Tower");
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 455, 90, 30));

        jButton10.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton10.setText("Rear");
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 210, 90, 30));

        jButton11.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton11.setText("Tower");
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 252, 90, 30));

        jButton12.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton12.setText("Left");
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 293, 90, 30));

        jButton13.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton13.setText("Right");
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 333, 90, 30));

        jButton14.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton14.setText("Front Left");
        jButton14.setContentAreaFilled(false);
        jButton14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 373, 90, 30));

        jButton9.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton9.setText("Front");
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setMaximumSize(new java.awt.Dimension(87, 25));
        jButton9.setMinimumSize(new java.awt.Dimension(87, 25));
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 170, 90, 30));

        jButton15.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton15.setText("Front Right");
        jButton15.setContentAreaFilled(false);
        jButton15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 414, 90, 30));

        jButton16.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton16.setText("Rear Tower");
        jButton16.setContentAreaFilled(false);
        jButton16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 454, 90, 30));

        GuessButton.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        GuessButton.setText("Connect");
        GuessButton.setContentAreaFilled(false);
        GuessButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GuessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuessButtonActionPerformed(evt);
            }
        });
        getContentPane().add(GuessButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 160, 50));

        jTextArea1.setBackground(new java.awt.Color(247, 253, 244));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 616, 1000, 90));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Eddy\\Pictures\\GUI\\RoverBackground5.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 730));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GuessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuessButtonActionPerformed

            JOptionPane.showMessageDialog(null, "Super Duper!");
            String[] args = null;
            jTextArea1.setText("Meow");
            try {
                Client.main(args);
            } catch (IOException ex) {
                Logger.getLogger(RoverGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_GuessButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RoverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoverGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoverGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GuessButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
