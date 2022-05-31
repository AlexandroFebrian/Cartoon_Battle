/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Battle extends javax.swing.JFrame {

    /**
     * Creates new form Battle
     */
    private ImageIcon Micon = new ImageIcon("src\\images\\Melee1.gif");
    private ImageIcon Micon2 = new ImageIcon("src\\images\\Melee2.gif");
    private ImageIcon Ricon = new ImageIcon("src\\images\\Ranged1.gif");
    private ImageIcon Ricon2 = new ImageIcon("src\\images\\Ranged2.gif");
    private ImageIcon Ticon = new ImageIcon("src\\images\\Tank1.gif");
    private ImageIcon Ticon2 = new ImageIcon("src\\images\\Tank2.gif");
    private ImageIcon Eicon = new ImageIcon("src\\images\\Enemy1.gif");
    private ImageIcon Eicon2 = new ImageIcon("src\\images\\Enemy2.gif");
    
    private ArrayList<JLabel> Trooplab = new ArrayList<>();
    private ArrayList<Troops> Troop = new ArrayList<>();
    private Timer TroopMove;
    private ArrayList<Troops> userT = new ArrayList<>();
    private ArrayList<Integer> TroopX = new ArrayList<>();
    private Timer TroopAtkTime;
    
    private ArrayList<JLabel> Enemylab = new ArrayList<>();
    private ArrayList<Integer> EnemyX = new ArrayList<>();
    private Timer EnemyMove;
    private Timer EnemySpawnT;
    private int SpawnTime = 0;
    
    private int EnemyHP = 20;
    private int EnemyAtk = 4;
    private ArrayList<Integer> EnemyList = new ArrayList<>();
    private Timer EnemyAtkTime;
    
    private int Mineral = 0;
    private Timer MineralT;
    
    public javax.swing.JButton getBack() {
        return Back;
    }

    public void setTrooplab(ArrayList<JLabel> Trooplab) {
        this.Trooplab = Trooplab;
    }

    public void setTroop(ArrayList<Troops> Troop) {
        this.Troop = Troop;
    }

    public void setTroopT(Timer TroopT) {
        this.TroopMove = TroopT;
    }

    public Timer getTroopT() {
        return TroopMove;
    }
    
    
    
    public Battle() {
        initComponents();
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
        
    }

    public Battle(ArrayList<Troops> t){
        initComponents();
        
//        MineralT = new Timer(1000, new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Mineral++;
//                Minerallab.setText(String.valueOf(Mineral));
//            }
//        });
//        
//        MineralT.start();

        AddRange.setVisible(false);
        AddTank.setVisible(false);
        Laser.setVisible(false);
        
        //Mengambil data troop dari user
        userT = t;
        
        if(userT.size() == 2){
            if(userT.get(1) instanceof Ranged){
                AddRange.setVisible(true);
            }else{
                AddTank.setVisible(true);
            }
        }else if(userT.size() == 3){
            AddRange.setVisible(true);
            AddTank.setVisible(true);
        }
        
        //Spawn Enemy
        ActionListener spawn = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                SpawnTime+=1;
                if(SpawnTime == 5){
                    SpawnTime = 0;
                    EnemyX.add(0);
                    EnemyList.add(EnemyHP);
                    Enemylab.add(new JLabel());
                    Enemylab.get(Enemylab.size()-1).setIcon(Eicon);
                    Enemylab.get(Enemylab.size()-1).setBounds(1000, 419, 200, 133); //x, y, lebar, tinggi
                    getContentPane().add(Enemylab.get(Enemylab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
                }
            }
        };
        EnemySpawnT = new Timer(1500, spawn);
        EnemySpawnT.start();
        
        //Enemy Gerak
        ActionListener Emove = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                for(int i = 0; i < Enemylab.size(); i++){
                    if(Enemylab.get(i).getLocation().x != 0){
                        EnemyX.set(i, Enemylab.get(i).getLocation().x);
                    }else{
                        Enemylab.get(i).setLocation(EnemyX.get(i), 419);
                    }
                    if(Enemylab.get(i).getIcon() == Eicon && Trooplab.size() == 0){
                        Enemylab.get(i).setLocation(Enemylab.get(i).getLocation().x-1, Enemylab.get(i).getLocation().y);
                    }else if(Trooplab.size() >= 1){
                        if(Trooplab.get(0).getLocation().x <= Enemylab.get(i).getLocation().x && Trooplab.get(0).getLocation().x >= Enemylab.get(i).getLocation().x-75 && Enemylab.get(i).getIcon() != Eicon2){
                            //ganti icon nyerang
                            Enemylab.get(i).setIcon(Eicon2);
                        }
                        else if(Enemylab.get(i).getIcon() == Eicon){
                            Enemylab.get(i).setLocation(Enemylab.get(i).getLocation().x-1, Enemylab.get(i).getLocation().y);
                        }
                    }
                }
            }
        };
        
        EnemyMove = new Timer(25, Emove);
        EnemyMove.start();
        
        //Enemy attack
        ActionListener Eatk = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                for(int i = 0; i < Enemylab.size(); i++){
                    if(Enemylab.get(i).getIcon() == Eicon2){
                        if(Troop.size() >= 1){
                            if(Trooplab.get(0).getLocation().x <= Enemylab.get(i).getLocation().x && Trooplab.get(0).getLocation().x >= Enemylab.get(i).getLocation().x-50){
                                if(Troop.get(0).getHP() <= 0){
                                    Enemylab.get(i).setIcon(Eicon);
                                    getContentPane().remove(Trooplab.get(0));
                                    Troop.remove(0);
                                    Trooplab.remove(0);
                                    TroopX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    Troop.get(0).setHP(Troop.get(0).getHP()-EnemyAtk);
                                }
                            }else{
                                Enemylab.get(i).setIcon(Eicon);
                            }
                        }else{
                            Enemylab.get(i).setIcon(Eicon);
                        }
                    }
                }
            }
        };
        
        EnemyAtkTime = new Timer(750, Eatk);
        EnemyAtkTime.start();
        
        //Troop gerak
        ActionListener Tmove = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                for(int i = 0; i < Trooplab.size(); i++){
                    if(Trooplab.get(i).getLocation().x != 0){
                        TroopX.set(i, Trooplab.get(i).getLocation().x);
                    }else{
                        if(Troop.get(i) instanceof Melee){
                            Trooplab.get(i).setLocation(TroopX.get(i), 480);
                        }else if(Troop.get(i) instanceof Ranged){
                            Trooplab.get(i).setLocation(TroopX.get(i), 435);
                        }else{
                            Trooplab.get(i).setLocation(TroopX.get(i), 430);
                        }
                    }
                    if(Troop.get(i) instanceof Melee){
                        if(Trooplab.get(i).getIcon() == Micon && Enemylab.size() == 0){
                            Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+20 && Trooplab.get(i).getIcon() != Micon2){
                                //ganti icon nyerang
                                Trooplab.get(i).setIcon(Micon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Micon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }else if(Troop.get(i) instanceof Ranged){
                        if(Trooplab.get(i).getIcon() == Ricon && Enemylab.size() == 0){
                            Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+100 && Trooplab.get(i).getIcon() != Ricon2){
                                //ganti icon nyerang
                                Trooplab.get(i).setIcon(Ricon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Ricon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }else{
                        if(Trooplab.get(i).getIcon() == Ticon && Enemylab.size() == 0){
                            Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+25 && Trooplab.get(i).getIcon() != Ticon2){
                                //ganti icon nyerang
                                Trooplab.get(i).setIcon(Ticon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Ticon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }
                }
            }
        };
        
        TroopMove = new Timer(10, Tmove);
        TroopMove.start();
        
        //Troop Attack
        ActionListener Tatk = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                for(int i = 0; i < Trooplab.size(); i++){
                    if(Trooplab.get(i).getIcon() == Micon2 && Troop.get(i) instanceof Melee){
                        if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+20){
                                if(EnemyList.get(0) <= 0){
                                    Trooplab.get(i).setIcon(Micon);
                                    getContentPane().remove(Enemylab.get(0));
                                    EnemyList.remove(0);
                                    Enemylab.remove(0);
                                    EnemyX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    EnemyList.set(0, EnemyList.get(0)-Troop.get(i).getAtk());
                                }
                            }else{
                                Trooplab.get(i).setIcon(Micon);
                            }
                        }else{
                            Trooplab.get(i).setIcon(Micon);
                        }
                    }else if(Trooplab.get(i).getIcon() == Ricon2 && Troop.get(i) instanceof Ranged){
                        if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+100){
                                if(EnemyList.get(0) <= 0){
                                    Trooplab.get(i).setIcon(Ricon);
                                    getContentPane().remove(Enemylab.get(0));
                                    EnemyList.remove(0);
                                    Enemylab.remove(0);
                                    EnemyX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    EnemyList.set(0, EnemyList.get(0)-Troop.get(i).getAtk());
                                }
                            }else{
                                Trooplab.get(i).setIcon(Ricon);
                            }
                        }else{
                            Trooplab.get(i).setIcon(Ricon);
                        }
                    }else if(Trooplab.get(i).getIcon() == Ticon2 && Troop.get(i) instanceof Tank){
                        if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+25){
                                if(EnemyList.get(0) <= 0){
                                    Trooplab.get(i).setIcon(Ticon);
                                    getContentPane().remove(Enemylab.get(0));
                                    EnemyList.remove(0);
                                    Enemylab.remove(0);
                                    EnemyX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    EnemyList.set(0, EnemyList.get(0)-Troop.get(i).getAtk());
                                }
                            }else{
                                Trooplab.get(i).setIcon(Ticon);
                            }
                        }else{
                            Trooplab.get(i).setIcon(Ticon);
                        }
                    }
                }
            }
        };
        
        TroopAtkTime = new Timer(750, Tatk);
        TroopAtkTime.start();
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Minerallab = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        AddMelee = new javax.swing.JButton();
        AddRange = new javax.swing.JButton();
        AddTank = new javax.swing.JButton();
        Laser = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cartoon Battle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Minerallab.setBackground(new java.awt.Color(0, 0, 0));
        Minerallab.setFont(new java.awt.Font("Lato Black", 1, 24)); // NOI18N
        Minerallab.setForeground(new java.awt.Color(0, 0, 0));
        Minerallab.setText("0");
        getContentPane().add(Minerallab, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, 90, 40));

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 120, 40));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 100));

        AddMelee.setBackground(new java.awt.Color(0, 0, 0));
        AddMelee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Melee Icon.png"))); // NOI18N
        AddMelee.setBorderPainted(false);
        AddMelee.setContentAreaFilled(false);
        AddMelee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMeleeActionPerformed(evt);
            }
        });
        getContentPane().add(AddMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 580, 130, 120));

        AddRange.setBackground(new java.awt.Color(0, 0, 0));
        AddRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tank Icon.png"))); // NOI18N
        AddRange.setBorderPainted(false);
        AddRange.setContentAreaFilled(false);
        AddRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRangeActionPerformed(evt);
            }
        });
        getContentPane().add(AddRange, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 580, 130, 120));

        AddTank.setBackground(new java.awt.Color(0, 0, 0));
        AddTank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ranged Icon.png"))); // NOI18N
        AddTank.setBorderPainted(false);
        AddTank.setContentAreaFilled(false);
        AddTank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTankActionPerformed(evt);
            }
        });
        getContentPane().add(AddTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 130, 120));

        Laser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Laser.gif"))); // NOI18N
        getContentPane().add(Laser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Battle Map.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Add Melee
    private void AddMeleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMeleeActionPerformed
        // TODO add your handling code here:
        TroopX.add(0);
        Troop.add(new Melee(userT.get(0).getHP(), userT.get(0).getAtk()));
        Trooplab.add(new JLabel());
        Trooplab.get(Trooplab.size()-1).setIcon(Micon);
        Trooplab.get(Trooplab.size()-1).setBounds(150, 480, 68, 68); //x, y, lebar, tinggi
        getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
    }//GEN-LAST:event_AddMeleeActionPerformed

    //Add Ranged
    private void AddRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRangeActionPerformed
        // TODO add your handling code here:
        if(userT.get(1) instanceof Ranged){
            Troop.add(userT.get(1));
        }else{
            Troop.add(userT.get(2));
        }
        Trooplab.add(new JLabel());
        Trooplab.get(Trooplab.size()-1).setIcon(Ricon);
        Trooplab.get(Trooplab.size()-1).setBounds(120, 435, 120, 120); //x, y, lebar, tinggi
        getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
    }//GEN-LAST:event_AddRangeActionPerformed

    //Add Tank
    private void AddTankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTankActionPerformed
        // TODO add your handling code here:
        if(userT.get(1) instanceof Tank){
            Troop.add(userT.get(1));
        }else{
            Troop.add(userT.get(2));
        }
        Trooplab.add(new JLabel());
        Trooplab.get(Trooplab.size()-1).setIcon(Ticon);
        Trooplab.get(Trooplab.size()-1).setBounds(119, 430, 130, 130); //x, y, lebar, tinggi
        getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
    }//GEN-LAST:event_AddTankActionPerformed

    //Add Enemy
    private void AddEnemy(){
        
    }
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

int waktu;
private Timer las;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:0
//        getContentPane().remove(Trooplab.get(Trooplab.size()-1));
//        Troop.remove(Troop.get(Troop.size()-1));
//        Trooplab.remove(Trooplab.get(Trooplab.size()-1));
//        TroopX.remove(TroopX.get(TroopX.size()-1));
//        getContentPane().validate();
//        getContentPane().repaint();
        waktu = 0;
        Laser.setVisible(true);
        ActionListener act = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                waktu++;
                if(waktu == 1){
                    Laser.setVisible(false);
                    las.stop();
                    
                }
            }
        };
        las = new Timer(1000, act);
        las.start();
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Battle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddMelee;
    private javax.swing.JButton AddRange;
    private javax.swing.JButton AddTank;
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Laser;
    private javax.swing.JLabel Minerallab;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
