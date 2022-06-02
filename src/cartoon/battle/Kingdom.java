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
                UpgradeTank1.addMouseListener(new MouseAdapter(){
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
                            HpTank2.setText(String.valueOf(t.getHP()));
                            AtkTank2.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Tank");
                    }
                });
            } else if(troop.get(1) instanceof Ranged){
                UpgradeRanged2.addMouseListener(new MouseAdapter(){
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
                            HpTank2.setText(String.valueOf(t.getHP()));
                            AtkTank2.setText(String.valueOf(t.getAtk()));
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
                UpgradeTank1.addMouseListener(new MouseAdapter(){
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
                            HpTank2.setText(String.valueOf(t.getHP()));
                            AtkTank2.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Tank");
                    }
                });
            } else if(troop.get(1) instanceof Ranged){
                UpgradeRanged2.addMouseListener(new MouseAdapter(){
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
                            HpTank2.setText(String.valueOf(t.getHP()));
                            AtkTank2.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Ranged");
                    }
                });
            } else if(troop.get(2) instanceof Tank){
                UpgradeTank1.addMouseListener(new MouseAdapter(){
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
                            HpTank2.setText(String.valueOf(t.getHP()));
                            AtkTank2.setText(String.valueOf(t.getAtk()));
                        } else { //gold ga cukup
        //                    Warning.setVisible(true);
                        }
        //                System.out.println("Berhasil Upgrade Tank");
                    }
                });
            } else if(troop.get(2) instanceof Ranged){
                UpgradeRanged2.addMouseListener(new MouseAdapter(){
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
                            HpTank2.setText(String.valueOf(t.getHP()));
                            AtkTank2.setText(String.valueOf(t.getAtk()));
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

        HpRanged1 = new javax.swing.JLabel();
        AtkRanged1 = new javax.swing.JLabel();
        HpTank2 = new javax.swing.JLabel();
        AtkTank2 = new javax.swing.JLabel();
        AtkTank1 = new javax.swing.JLabel();
        HpTank1 = new javax.swing.JLabel();
        RangedIcon1 = new javax.swing.JLabel();
        RangedIcon = new javax.swing.JLabel();
        TankIcon1 = new javax.swing.JLabel();
        TankIcon = new javax.swing.JLabel();
        Gold = new javax.swing.JLabel();
        Warning = new javax.swing.JLabel();
        HpTower = new javax.swing.JLabel();
        LevelTower = new javax.swing.JLabel();
        AtkRanged2 = new javax.swing.JLabel();
        HpRanged2 = new javax.swing.JLabel();
        AtkMelee = new javax.swing.JLabel();
        HpMelee = new javax.swing.JLabel();
        UpgradeTower = new javax.swing.JButton();
        UpgradeRanged1 = new javax.swing.JButton();
        UpgradeRanged2 = new javax.swing.JButton();
        UpgradeTank1 = new javax.swing.JButton();
        UpgradeTank2 = new javax.swing.JButton();
        UpgradeMelee = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cartoon Battle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HpRanged1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpRanged1.setForeground(new java.awt.Color(255, 255, 255));
        HpRanged1.setText("0");
        getContentPane().add(HpRanged1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, -1));

        AtkRanged1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkRanged1.setForeground(new java.awt.Color(255, 255, 255));
        AtkRanged1.setText("0");
        getContentPane().add(AtkRanged1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        HpTank2.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpTank2.setForeground(new java.awt.Color(255, 255, 255));
        HpTank2.setText("0");
        getContentPane().add(HpTank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

        AtkTank2.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkTank2.setForeground(new java.awt.Color(255, 255, 255));
        AtkTank2.setText("0");
        getContentPane().add(AtkTank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        AtkTank1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkTank1.setForeground(new java.awt.Color(255, 255, 255));
        AtkTank1.setText("0");
        getContentPane().add(AtkTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 390, -1, -1));

        HpTank1.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpTank1.setForeground(new java.awt.Color(255, 255, 255));
        HpTank1.setText("0");
        getContentPane().add(HpTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, -1, -1));

        RangedIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ranged Icon.png"))); // NOI18N
        getContentPane().add(RangedIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 520, -1, -1));

        RangedIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ranged Icon.png"))); // NOI18N
        getContentPane().add(RangedIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 360, -1, -1));

        TankIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tank Icon.png"))); // NOI18N
        getContentPane().add(TankIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 520, -1, -1));

        TankIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tank Icon.png"))); // NOI18N
        getContentPane().add(TankIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 360, -1, -1));

        Gold.setFont(new java.awt.Font("Lato Black", 1, 30)); // NOI18N
        Gold.setForeground(new java.awt.Color(255, 255, 51));
        Gold.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Gold.setText("0");
        getContentPane().add(Gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 240, -1));

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

        AtkRanged2.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        AtkRanged2.setForeground(new java.awt.Color(255, 255, 255));
        AtkRanged2.setText("0");
        getContentPane().add(AtkRanged2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        HpRanged2.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        HpRanged2.setForeground(new java.awt.Color(255, 255, 255));
        HpRanged2.setText("0");
        getContentPane().add(HpRanged2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, -1, -1));

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

        UpgradeRanged1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeRanged1.setBorderPainted(false);
        UpgradeRanged1.setContentAreaFilled(false);
        UpgradeRanged1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeRanged1ActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeRanged1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        UpgradeRanged2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeRanged2.setBorderPainted(false);
        UpgradeRanged2.setContentAreaFilled(false);
        UpgradeRanged2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeRanged2ActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeRanged2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, -1));

        UpgradeTank1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeTank1.setBorderPainted(false);
        UpgradeTank1.setContentAreaFilled(false);
        UpgradeTank1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeTank1ActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeTank1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        UpgradeTank2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Troop.png"))); // NOI18N
        UpgradeTank2.setBorderPainted(false);
        UpgradeTank2.setContentAreaFilled(false);
        UpgradeTank2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeTank2ActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeTank2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, -1, -1));

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

    private void UpgradeTank1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeTank1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpgradeTank1ActionPerformed

    private void UpgradeRanged2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeRanged2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpgradeRanged2ActionPerformed

    private void UpgradeRanged1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeRanged1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpgradeRanged1ActionPerformed

    private void UpgradeTank2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeTank2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpgradeTank2ActionPerformed

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
    private javax.swing.JLabel AtkRanged1;
    private javax.swing.JLabel AtkRanged2;
    private javax.swing.JLabel AtkTank1;
    private javax.swing.JLabel AtkTank2;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Gold;
    private javax.swing.JLabel HpMelee;
    private javax.swing.JLabel HpRanged1;
    private javax.swing.JLabel HpRanged2;
    private javax.swing.JLabel HpTank1;
    private javax.swing.JLabel HpTank2;
    private javax.swing.JLabel HpTower;
    private javax.swing.JLabel LevelTower;
    private javax.swing.JLabel RangedIcon;
    private javax.swing.JLabel RangedIcon1;
    private javax.swing.JLabel TankIcon;
    private javax.swing.JLabel TankIcon1;
    private javax.swing.JButton UpgradeMelee;
    private javax.swing.JButton UpgradeRanged1;
    private javax.swing.JButton UpgradeRanged2;
    private javax.swing.JButton UpgradeTank1;
    private javax.swing.JButton UpgradeTank2;
    private javax.swing.JButton UpgradeTower;
    private javax.swing.JLabel Warning;
    // End of variables declaration//GEN-END:variables
}
