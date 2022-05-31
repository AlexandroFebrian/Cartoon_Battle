/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    
    public Kingdom(User u) {
        initComponents();
//        Warning.setVisible(false);
        Gold.setText(String.valueOf(u.getGold()));
        HpTower.setText(String.valueOf(u.getTower().getHp()));
        LevelTower.setText(String.valueOf(u.getTower().getLevel()));
        troop = u.getTroop();
        
        //detail melee
        HpMelee.setText(String.valueOf(troop.get(0).getHP()));
        AtkMelee.setText(String.valueOf(troop.get(0).getAtk()));
        
        UpgradeTower.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Tower t = u.getTower();
                int tempGold = u.getGold();
                int bayar = ((t.getLevel()-1)*50) + 50;
                if(tempGold >= bayar){ // berhasil
                    tempGold -= bayar;
                    u.setGold(tempGold);
                    int level= t.getLevel() + 1;
                    t.setLevel(level);
                    int hp = t.getHp() + (level*5) + 5;
                    t.setHp(hp);
                    Gold.setText(String.valueOf(u.getGold()));
                    HpTower.setText(String.valueOf(t.getHp()));
                    LevelTower.setText(String.valueOf(t.getLevel()));
                } else { //gold ga cukup
//                    Warning.setVisible(true);
                }
//                System.out.println("Berhasil Upgrade Tower");
            }
        });
        
        UpgradeMelee.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Troops m = troop.get(0);
                int tempGold = u.getGold();
                int bayar = (m.getAtk()*5) + 5;
                if(tempGold >= bayar){ // berhasil
                    tempGold-=bayar;
                    u.setGold(tempGold);
                    int atk = m.getAtk() + 5;
                    m.setAtk(atk);
                    int hp = m.getHP() + 10;
                    m.setHP(hp);
                    Gold.setText(String.valueOf(u.getGold()));
                    HpMelee.setText(String.valueOf(m.getHP()));
                    AtkMelee.setText(String.valueOf(m.getAtk()));
                } else { //gold ga cukup
//                    Warning.setVisible(true);
                }
//                System.out.println("Berhasil Upgrade Melee");
            }
        });
        
        if(troop.size() == 2){
            if(troop.get(1) instanceof Tank){
                UpgradeTank.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        Troops t = troop.get(1);
                        int tempGold = u.getGold();
                        int bayar = (t.getAtk()*5) + 5;
                        if(tempGold >= bayar){ // berhasil
                            tempGold-=bayar;
                            u.setGold(tempGold);
                            int atk = t.getAtk() + 5;
                            t.setAtk(atk);
                            int hp = t.getHP() + 10;
                            t.setHP(hp);
                            Gold.setText(String.valueOf(u.getGold()));
                            HpTank.setText(String.valueOf(t.getHP()));
                            AtkTank.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Tank");
                    }
                });
            } else if(troop.get(1) instanceof Ranged){
                UpgradeRanged.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        Troops t = troop.get(1);
                        int tempGold = u.getGold();
                        int bayar = (t.getAtk()*5) + 5;
                        if(tempGold >= bayar){ // berhasil
                            tempGold-=bayar;
                            u.setGold(tempGold);
                            int atk = t.getAtk() + 5;
                            t.setAtk(atk);
                            int hp = t.getHP() + 10;
                            t.setHP(hp);
                            Gold.setText(String.valueOf(u.getGold()));
                            HpTank.setText(String.valueOf(t.getHP()));
                            AtkTank.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Ranged");
                    }
                });
            }
        }
        
        if(troop.size() == 3){
            if(troop.get(1) instanceof Tank){
                UpgradeTank.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        Troops t = troop.get(1);
                        int tempGold = u.getGold();
                        int bayar = (t.getAtk()*5) + 5;
                        if(tempGold >= bayar){ // berhasil
                            tempGold-=bayar;
                            u.setGold(tempGold);
                            int atk = t.getAtk() + 5;
                            t.setAtk(atk);
                            int hp = t.getHP() + 10;
                            t.setHP(hp);
                            Gold.setText(String.valueOf(u.getGold()));
                            HpTank.setText(String.valueOf(t.getHP()));
                            AtkTank.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Tank");
                    }
                });
            } else if(troop.get(1) instanceof Ranged){
                UpgradeRanged.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        Troops t = troop.get(1);
                        int tempGold = u.getGold();
                        int bayar = (t.getAtk()*5) + 5;
                        if(tempGold >= bayar){ // berhasil
                            tempGold-=bayar;
                            u.setGold(tempGold);
                            int atk = t.getAtk() + 5;
                            t.setAtk(atk);
                            int hp = t.getHP() + 10;
                            t.setHP(hp);
                            Gold.setText(String.valueOf(u.getGold()));
                            HpTank.setText(String.valueOf(t.getHP()));
                            AtkTank.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Ranged");
                    }
                });
            } else if(troop.get(2) instanceof Tank){
                UpgradeTank.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        Troops t = troop.get(2);
                        int tempGold = u.getGold();
                        int bayar = (t.getAtk()*5) + 5;
                        if(tempGold >= bayar){ // berhasil
                            tempGold-=bayar;
                            u.setGold(tempGold);
                            int atk = t.getAtk() + 5;
                            t.setAtk(atk);
                            int hp = t.getHP() + 10;
                            t.setHP(hp);
                            Gold.setText(String.valueOf(u.getGold()));
                            HpTank.setText(String.valueOf(t.getHP()));
                            AtkTank.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Tank");
                    }
                });
            } else if(troop.get(2) instanceof Ranged){
                UpgradeRanged.addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        Troops t = troop.get(2);
                        int tempGold = u.getGold();
                        int bayar = (t.getAtk()*5) + 5;
                        if(tempGold >= bayar){ // berhasil
                            tempGold-=bayar;
                            u.setGold(tempGold);
                            int atk = t.getAtk() + 5;
                            t.setAtk(atk);
                            int hp = t.getHP() + 10;
                            t.setHP(hp);
                            Gold.setText(String.valueOf(u.getGold()));
                            HpTank.setText(String.valueOf(t.getHP()));
                            AtkTank.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Ranged");
                    }
                });
            }
        }
        
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
        AtkRanged = new javax.swing.JLabel();
        HpRanged = new javax.swing.JLabel();
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
        setTitle("Cartoon Battle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Gold.setFont(new java.awt.Font("Lato Black", 1, 30)); // NOI18N
        Gold.setForeground(new java.awt.Color(255, 255, 51));
        Gold.setText("0");
        getContentPane().add(Gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 30, 20, -1));

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

        AtkRanged.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkRanged.setForeground(new java.awt.Color(255, 255, 255));
        AtkRanged.setText("0");
        getContentPane().add(AtkRanged, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        HpRanged.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpRanged.setForeground(new java.awt.Color(255, 255, 255));
        HpRanged.setText("0");
        getContentPane().add(HpRanged, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

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
        getContentPane().add(UpgradeTower, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 530, -1, -1));

        UpgradeRanged.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeRanged.setBorderPainted(false);
        UpgradeRanged.setContentAreaFilled(false);
        UpgradeRanged.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeRangedActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeRanged, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, -1));

        UpgradeTank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeTank.setBorderPainted(false);
        UpgradeTank.setContentAreaFilled(false);
        UpgradeTank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeTankActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        UpgradeMelee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeMelee.setBorderPainted(false);
        UpgradeMelee.setContentAreaFilled(false);
        UpgradeMelee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeMeleeActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

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
    }//GEN-LAST:event_UpgradeMeleeActionPerformed

    private void UpgradeTowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeTowerActionPerformed
    }//GEN-LAST:event_UpgradeTowerActionPerformed

    private void UpgradeTankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeTankActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpgradeTankActionPerformed

    private void UpgradeRangedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeRangedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpgradeRangedActionPerformed

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
    private javax.swing.JLabel AtkRanged;
    private javax.swing.JLabel AtkTank;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Gold;
    private javax.swing.JLabel HpMelee;
    private javax.swing.JLabel HpRanged;
    private javax.swing.JLabel HpTank;
    private javax.swing.JLabel HpTower;
    private javax.swing.JLabel LevelTower;
    private javax.swing.JButton UpgradeMelee;
    private javax.swing.JButton UpgradeRanged;
    private javax.swing.JButton UpgradeTank;
    private javax.swing.JButton UpgradeTower;
    private javax.swing.JLabel Warning;
    // End of variables declaration//GEN-END:variables
}
