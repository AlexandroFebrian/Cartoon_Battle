/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author User
 */
public class Kingdom extends javax.swing.JFrame {

    /**
     * Creates new form Kingdom
     */
    
    private ArrayList<Troops> troop = new ArrayList<>();
    
    public Kingdom() {
        initComponents();
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
    }
    
    public Kingdom(String gold, String hpTower, String levelTower, ArrayList<Troops> t) {
        initComponents();
//        Warning.setVisible(false);
        Gold.setText(gold);
        HpTower.setText(hpTower);
        LevelTower.setText(levelTower);
        troop = t;
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
    }
    

    public JButton getBack() {
        return Back;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gold = new javax.swing.JLabel();
        Warning = new javax.swing.JLabel();
        HpTower = new javax.swing.JLabel();
        LevelTower = new javax.swing.JLabel();
        AtkTank1 = new javax.swing.JLabel();
        HpTank1 = new javax.swing.JLabel();
        AtkTank = new javax.swing.JLabel();
        HpTank = new javax.swing.JLabel();
        AtkMelee = new javax.swing.JLabel();
        HpMelee = new javax.swing.JLabel();
        UpgradeTower = new javax.swing.JButton();
        UpgradeRanged = new javax.swing.JButton();
        UpgradeTank = new javax.swing.JButton();
        UpgradeMelee = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Gold.setFont(new java.awt.Font("Lato Black", 1, 30)); // NOI18N
        Gold.setForeground(new java.awt.Color(255, 255, 51));
        Gold.setText("x");
        getContentPane().add(Gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 30, 20, -1));

        Warning.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Warning.setForeground(new java.awt.Color(255, 255, 255));
        Warning.setText("Warning GOLD ga cukup pas upgrade");
        getContentPane().add(Warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, -1, -1));

        HpTower.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        HpTower.setForeground(new java.awt.Color(255, 255, 255));
        HpTower.setText("0");
        getContentPane().add(HpTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 430, -1, -1));

        LevelTower.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        LevelTower.setForeground(new java.awt.Color(255, 255, 255));
        LevelTower.setText("0");
        getContentPane().add(LevelTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, -1, -1));

        AtkTank1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkTank1.setForeground(new java.awt.Color(255, 255, 255));
        AtkTank1.setText("0");
        getContentPane().add(AtkTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        HpTank1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpTank1.setForeground(new java.awt.Color(255, 255, 255));
        HpTank1.setText("0");
        getContentPane().add(HpTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        AtkTank.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkTank.setForeground(new java.awt.Color(255, 255, 255));
        AtkTank.setText("0");
        getContentPane().add(AtkTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        HpTank.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpTank.setForeground(new java.awt.Color(255, 255, 255));
        HpTank.setText("0");
        getContentPane().add(HpTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, -1));

        AtkMelee.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkMelee.setForeground(new java.awt.Color(255, 255, 255));
        AtkMelee.setText("0");
        getContentPane().add(AtkMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, -1, -1));

        HpMelee.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpMelee.setForeground(new java.awt.Color(255, 255, 255));
        HpMelee.setText("0");
        getContentPane().add(HpMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        UpgradeTower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Tower.png"))); // NOI18N
        UpgradeTower.setBorderPainted(false);
        UpgradeTower.setContentAreaFilled(false);
        UpgradeTower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeTowerActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 530, -1, -1));

        UpgradeRanged.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeRanged.setBorderPainted(false);
        UpgradeRanged.setContentAreaFilled(false);
        getContentPane().add(UpgradeRanged, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, -1, -1));

        UpgradeTank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeTank.setBorderPainted(false);
        UpgradeTank.setContentAreaFilled(false);
        getContentPane().add(UpgradeTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        UpgradeMelee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeMelee.setBorderPainted(false);
        UpgradeMelee.setContentAreaFilled(false);
        UpgradeMelee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeMeleeActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, -1, -1));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Kingdom Map.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpgradeMeleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeMeleeActionPerformed
        // TODO add your handling code here:
        int tempGold = Integer.parseInt(Gold.getText());
        int bayar = ((Integer.parseInt(AtkMelee.getText()))*5) + 5;
        if(tempGold >= bayar){ // berhasil
            tempGold-=bayar;
            Gold.setText(String.valueOf(tempGold));
            int atk = Integer.parseInt(AtkMelee.getText()) + 5;
            AtkMelee.setText(String.valueOf(atk));
            int hp = Integer.parseInt(HpMelee.getText()) + 10;
            HpMelee.setText(String.valueOf(hp));
        } else { //gold ga cukup
//            Warning.setVisible(true);
        }
    }//GEN-LAST:event_UpgradeMeleeActionPerformed

    private void UpgradeTowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeTowerActionPerformed
        int tempGold = Integer.parseInt(Gold.getText());
        int bayar = ((Integer.parseInt(LevelTower.getText())-1)*50) + 50;
        if(tempGold >= bayar){ // berhasil
            tempGold-=bayar;
            Gold.setText(String.valueOf(tempGold));
            int temp = Integer.parseInt(LevelTower.getText()) + 1;
            LevelTower.setText(String.valueOf(temp));
        } else {
//            Warning.setVisible(true);
        }
    }//GEN-LAST:event_UpgradeTowerActionPerformed

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
            java.util.logging.Logger.getLogger(Kingdom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kingdom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kingdom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kingdom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kingdom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AtkMelee;
    private javax.swing.JLabel AtkTank;
    private javax.swing.JLabel AtkTank1;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Gold;
    private javax.swing.JLabel HpMelee;
    private javax.swing.JLabel HpTank;
    private javax.swing.JLabel HpTank1;
    private javax.swing.JLabel HpTower;
    private javax.swing.JLabel LevelTower;
    private javax.swing.JButton UpgradeMelee;
    private javax.swing.JButton UpgradeRanged;
    private javax.swing.JButton UpgradeTank;
    private javax.swing.JButton UpgradeTower;
    private javax.swing.JLabel Warning;
    // End of variables declaration//GEN-END:variables
}
