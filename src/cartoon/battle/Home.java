/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author User
 */
public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private Timer t;
    
    private void defaultDisplay() {
        Kingdom.setVisible(false);
        Shop.setVisible(false);
        Battle.setVisible(false);
        Volume.setVisible(false);
        VolumeControl.setVisible(false);
        BlackBackground.setVisible(false);
        XMark.setVisible(false);
        Logout.setVisible(false);
    }
    
    private void playMusic(Sound sound) {
        VolumeControl.setValue((int)sound.getVolume());
        VolumeControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sound.changeVolume(VolumeControl.getValue());
            }
        });
    }
    
    public Home(String user, String gold, Sound sound) {
        initComponents();
        
        //Default Display
        defaultDisplay();
        
        //Music
        playMusic(sound);
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
        
        Username.setText(user);
        Gold.setText(gold);
    }
    
    public Home() {
        initComponents();
    }
    
    public javax.swing.JButton getBattle() {
        return Battle;
    }
    
    public javax.swing.JButton getLogout() {
        return Logout;
    }
    
    public javax.swing.JButton getShop() {
        return Shop;
    }
    
    public javax.swing.JButton getKingdom() {
        return Kingdom;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VolumeControl = new javax.swing.JSlider();
        Logout = new javax.swing.JButton();
        XMark = new javax.swing.JButton();
        Volume = new javax.swing.JLabel();
        BlackBackground = new javax.swing.JLabel();
        Gold = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        Setting = new javax.swing.JButton();
        Kingdom = new javax.swing.JButton();
        Shop = new javax.swing.JButton();
        Battle = new javax.swing.JButton();
        DefaultKingdom = new javax.swing.JLabel();
        DefaultShop = new javax.swing.JLabel();
        DefaultBattle = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Caroon Battle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VolumeControl.setBackground(new java.awt.Color(0, 208, 196));
        VolumeControl.setMaximum(6);
        VolumeControl.setMinimum(-30);
        VolumeControl.setValue(-15);
        getContentPane().add(VolumeControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 420, -1));

        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logout.png"))); // NOI18N
        Logout.setBorderPainted(false);
        Logout.setContentAreaFilled(false);
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, -1, -1));

        XMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/X Mark.png"))); // NOI18N
        XMark.setBorderPainted(false);
        XMark.setContentAreaFilled(false);
        XMark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XMarkActionPerformed(evt);
            }
        });
        getContentPane().add(XMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, -1, -1));

        Volume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home Volume.png"))); // NOI18N
        getContentPane().add(Volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        BlackBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Black.png"))); // NOI18N
        getContentPane().add(BlackBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Gold.setFont(new java.awt.Font("Lato Black", 1, 30)); // NOI18N
        Gold.setForeground(new java.awt.Color(255, 255, 51));
        Gold.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Gold.setText("x");
        getContentPane().add(Gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 50, -1, -1));

        Username.setFont(new java.awt.Font("Lato Black", 1, 36)); // NOI18N
        Username.setText("<username>");
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, -1, -1));

        Setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home Setting.png"))); // NOI18N
        Setting.setBorderPainted(false);
        Setting.setContentAreaFilled(false);
        Setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingActionPerformed(evt);
            }
        });
        getContentPane().add(Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, -1, -1));

        Kingdom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Kingdom1.png"))); // NOI18N
        Kingdom.setBorderPainted(false);
        Kingdom.setContentAreaFilled(false);
        Kingdom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                KingdomMouseExited(evt);
            }
        });
        getContentPane().add(Kingdom, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        Shop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Shop1.png"))); // NOI18N
        Shop.setBorderPainted(false);
        Shop.setContentAreaFilled(false);
        Shop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ShopMouseExited(evt);
            }
        });
        getContentPane().add(Shop, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 190, -1, -1));

        Battle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Battle1.png"))); // NOI18N
        Battle.setBorderPainted(false);
        Battle.setContentAreaFilled(false);
        Battle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BattleMouseExited(evt);
            }
        });
        Battle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BattleActionPerformed(evt);
            }
        });
        getContentPane().add(Battle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 460, -1, -1));

        DefaultKingdom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Kingdom.png"))); // NOI18N
        DefaultKingdom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DefaultKingdomMouseEntered(evt);
            }
        });
        getContentPane().add(DefaultKingdom, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        DefaultShop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Shop.png"))); // NOI18N
        DefaultShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DefaultShopMouseEntered(evt);
            }
        });
        getContentPane().add(DefaultShop, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 200, -1, -1));

        DefaultBattle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Battle.png"))); // NOI18N
        DefaultBattle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DefaultBattleMouseEntered(evt);
            }
        });
        getContentPane().add(DefaultBattle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 470, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Home.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BattleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BattleActionPerformed

    private void DefaultKingdomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DefaultKingdomMouseEntered
        // TODO add your handling code here:
        Kingdom.setVisible(true);
        DefaultKingdom.setVisible(false);
    }//GEN-LAST:event_DefaultKingdomMouseEntered

    private void KingdomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KingdomMouseExited
        // TODO add your handling code here:
        Kingdom.setVisible(false);
        DefaultKingdom.setVisible(true);
    }//GEN-LAST:event_KingdomMouseExited

    private void DefaultShopMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DefaultShopMouseEntered
        // TODO add your handling code here:
        Shop.setVisible(true);
        DefaultShop.setVisible(false);
    }//GEN-LAST:event_DefaultShopMouseEntered

    private void ShopMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShopMouseExited
        // TODO add your handling code here:
        Shop.setVisible(false);
        DefaultShop.setVisible(true);
    }//GEN-LAST:event_ShopMouseExited

    private void DefaultBattleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DefaultBattleMouseEntered
        // TODO add your handling code here:
        Battle.setVisible(true);
        DefaultBattle.setVisible(false);
    }//GEN-LAST:event_DefaultBattleMouseEntered

    private void BattleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BattleMouseExited
        // TODO add your handling code here:
        Battle.setVisible(false);
        DefaultBattle.setVisible(true);
    }//GEN-LAST:event_BattleMouseExited

    private void SettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingActionPerformed
        // TODO add your handling code here:
        Volume.setVisible(true);
        VolumeControl.setVisible(true);
        XMark.setVisible(true);
        BlackBackground.setVisible(true);
        Logout.setVisible(true);
    }//GEN-LAST:event_SettingActionPerformed

    private void XMarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XMarkActionPerformed
        // TODO add your handling code here:
        Volume.setVisible(false);
        VolumeControl.setVisible(false);
        XMark.setVisible(false);
        BlackBackground.setVisible(false);
        Logout.setVisible(false);
    }//GEN-LAST:event_XMarkActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LogoutActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Battle;
    private javax.swing.JLabel BlackBackground;
    private javax.swing.JLabel DefaultBattle;
    private javax.swing.JLabel DefaultKingdom;
    private javax.swing.JLabel DefaultShop;
    private javax.swing.JLabel Gold;
    private javax.swing.JButton Kingdom;
    private javax.swing.JButton Logout;
    private javax.swing.JButton Setting;
    private javax.swing.JButton Shop;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel Volume;
    private javax.swing.JSlider VolumeControl;
    private javax.swing.JButton XMark;
    // End of variables declaration//GEN-END:variables
}
