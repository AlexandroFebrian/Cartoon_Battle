/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private int UserTowerHP;
    private int MaxMineral = 100;
    
    private ArrayList<JLabel> Enemylab = new ArrayList<>();
    private ArrayList<Integer> EnemyX = new ArrayList<>();
    private Timer EnemyMove;
    private Timer EnemySpawnT;
    private int SpawnTime = 0;
    
    private int EnemyHP = 20;
    private int EnemyAtk = 4;
    private int EnemyTowerHP = 1000;
    private ArrayList<Integer> EnemyList = new ArrayList<>();
    private Timer EnemyAtkTime;
    
    private int Mineral = 0;
    private Timer MineralT;
    
    
    public javax.swing.JButton getBack() {
        return Back;
    }

    public Timer getTroopMove() {
        return TroopMove;
    }

    public void setTroopMove(Timer TroopMove) {
        this.TroopMove = TroopMove;
    }

    public Timer getTroopAtkTime() {
        return TroopAtkTime;
    }

    public void setTroopAtkTime(Timer TroopAtkTime) {
        this.TroopAtkTime = TroopAtkTime;
    }

    public Timer getEnemyMove() {
        return EnemyMove;
    }

    public void setEnemyMove(Timer EnemyMove) {
        this.EnemyMove = EnemyMove;
    }

    public Timer getEnemySpawnT() {
        return EnemySpawnT;
    }

    public void setEnemySpawnT(Timer EnemySpawnT) {
        this.EnemySpawnT = EnemySpawnT;
    }

    public Timer getEnemyAtkTime() {
        return EnemyAtkTime;
    }

    public void setEnemyAtkTime(Timer EnemyAtkTime) {
        this.EnemyAtkTime = EnemyAtkTime;
    }

    public Timer getMineralT() {
        return MineralT;
    }

    public void setMineralT(Timer MineralT) {
        this.MineralT = MineralT;
    }
    
    public void StopAllTimer(){
        if(getTroopMove() != null){
            getTroopMove().stop();
            setTroopMove(null);
        }
        if(getTroopAtkTime() != null){
            getTroopAtkTime().stop();
            setTroopAtkTime(null);
        }
        if(getEnemyMove() != null){
            getEnemyMove().stop();
            setEnemyMove(null);
        }
        if(getEnemySpawnT() != null){
            getEnemySpawnT().stop();
            setEnemySpawnT(null);
        }
        if(getEnemyAtkTime() != null){
            getEnemyAtkTime().stop();
            setEnemyAtkTime(null);
        }
        if(getMineralT() != null){
            getMineralT().stop();
            setMineralT(null);
        }
    }
    
    public void Win(User user){
        StopAllTimer();
        ETowerHP.setText("HP : 0");
        Final.setVisible(true);
        Final.setText("You Win");
        Back.setLocation(600, 300);
    }

    public JLabel getFinal() {
        return Final;
    }
    
    
    
    public Battle() {
        initComponents();
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
        
    }

    public Battle(User user){
        initComponents();
        getContentPane().setLayout(null);
        
        EnemyHP += (user.getLevelEnemy()-1)*15;
        EnemyAtk += (user.getLevelEnemy()-1)*4;
        EnemyTowerHP += (user.getLevelEnemy()-1)*100;
        
        UserTowerHP = user.getTower().getHp();
        UTowerHP.setText("HP : " + String.valueOf(UserTowerHP));
        ETowerHP.setText("HP : " + String.valueOf(EnemyTowerHP));
        Level.setText("Level : " + String.valueOf(user.getLevelEnemy()));
        
        MineralT = new Timer(50, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Mineral < MaxMineral){
                    Mineral++;
                }
                Minerallab.setText(String.valueOf(Mineral) + "/" + String.valueOf(MaxMineral));
            }
        });
        
        MineralT.start();

        AddRange.setVisible(false);
        AddTank.setVisible(false);
        Laser.setVisible(false);
        Final.setVisible(false);
        
        //Mengambil data troop dari user
        userT = user.getTroop();
        
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
                    Enemylab.get(Enemylab.size()-1).setBounds(1030, 419, 200, 133); //x, y, lebar, tinggi
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
                        if(Enemylab.get(i).getLocation().x <= 175 && Enemylab.get(i).getIcon() != Eicon2){
                            Enemylab.get(i).setIcon(Eicon2);
                        }else if(Enemylab.get(i).getIcon() == Eicon){
                            Enemylab.get(i).setLocation(Enemylab.get(i).getLocation().x-1, Enemylab.get(i).getLocation().y);
                        }
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
                            if(Enemylab.get(i).getLocation().x <= 175){
                                UserTowerHP -= EnemyAtk;
                                UserHpBar.setValue((int)(UserTowerHP * 100) / user.getTower().getHp());
//                                UTowerHP.setText("HP : " + String.valueOf(UserTowerHP));
                                if(UserTowerHP <= 0){
                                    StopAllTimer();
                                    UTowerHP.setText("HP : 0");
                                    Final.setVisible(true);
                                    Final.setText("You Lose");
                                    Back.setLocation(600, 300);
                                }
                            }else{
                                Enemylab.get(i).setIcon(Eicon);
                            }
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
                            if(Trooplab.get(i).getLocation().x >= 1010 && Trooplab.get(i).getIcon() != Micon2){
                                Trooplab.get(i).setIcon(Micon2);
                            }else if(Trooplab.get(i).getIcon() == Micon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+20 && Trooplab.get(i).getIcon() != Micon2){
                                //ganti icon nyerang
                                Trooplab.get(i).setBounds(TroopX.get(i), 480, 105, 70); //x, y, lebar, tinggi
                                Trooplab.get(i).setIcon(Micon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Micon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }else if(Troop.get(i) instanceof Ranged){
                        if(Trooplab.get(i).getIcon() == Ricon && Enemylab.size() == 0){
                            if(Trooplab.get(i).getLocation().x >= 780 && Trooplab.get(i).getIcon() != Ricon2){
                                Trooplab.get(i).setIcon(Ricon2);
                            }else if(Trooplab.get(i).getIcon() == Ricon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+250 && Trooplab.get(i).getIcon() != Ricon2){
                                //ganti icon nyerang
                                Trooplab.get(i).setBounds(TroopX.get(i), 435, 300, 120); //x, y, lebar, tinggi
                                Trooplab.get(i).setIcon(Ricon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Ricon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }else{
                        if(Trooplab.get(i).getIcon() == Ticon && Enemylab.size() == 0){
                            if(Trooplab.get(i).getLocation().x >= 955 && Trooplab.get(i).getIcon() != Ticon2){
                                Trooplab.get(i).setIcon(Ticon2);
                            }else if(Trooplab.get(i).getIcon() == Ticon){
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+75 && Trooplab.get(i).getIcon() != Ticon2){
                                //ganti icon nyerang
                                Trooplab.get(i).setBounds(TroopX.get(i), 430, 195, 130); //x, y, lebar, tinggi
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
                            if(Trooplab.get(i).getLocation().x >= 1010){
                                    EnemyTowerHP -= Troop.get(i).getAtk();
                                    EnemyHpBar.setValue((int)(EnemyTowerHP * 100) / (1000 + (user.getLevelEnemy()-1)*100));
//                                    ETowerHP.setText("HP : " + String.valueOf(EnemyTowerHP));
                                    if(EnemyTowerHP <= 0){
                                        Win(user);
                                    }
                            }else{
                                Trooplab.get(i).setIcon(Micon);
                            }
                        }
                    }else if(Trooplab.get(i).getIcon() == Ricon2 && Troop.get(i) instanceof Ranged){
                        if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+250){
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
                            if(Trooplab.get(i).getLocation().x >= 780){
                                    EnemyTowerHP -= Troop.get(i).getAtk();
                                    ETowerHP.setText("HP : " + String.valueOf(EnemyTowerHP));
                                    if(EnemyTowerHP <= 0){
                                        Win(user);
                                    }
                            }else{
                                Trooplab.get(i).setIcon(Ricon);
                            }
                        }
                    }else if(Trooplab.get(i).getIcon() == Ticon2 && Troop.get(i) instanceof Tank){
                        if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+75){
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
                            if(Trooplab.get(i).getLocation().x >= 955){
                                    EnemyTowerHP -= Troop.get(i).getAtk();
                                    ETowerHP.setText("HP : " + String.valueOf(EnemyTowerHP));
                                    if(EnemyTowerHP <= 0){
                                        Win(user);
                                    }
                            }else{
                                Trooplab.get(i).setIcon(Ticon);
                            }
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

        ETowerHP = new javax.swing.JLabel();
        UTowerHP = new javax.swing.JLabel();
        LaserValue = new javax.swing.JLabel();
        EnemyHpBar = new javax.swing.JProgressBar();
        UserHpBar = new javax.swing.JProgressBar();
        Level = new javax.swing.JLabel();
        Final = new javax.swing.JLabel();
        Minerallab = new javax.swing.JLabel();
        MineralIcon = new javax.swing.JLabel();
        LaserIcon = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        AddMelee = new javax.swing.JButton();
        AddRange = new javax.swing.JButton();
        AddTank = new javax.swing.JButton();
        Laser = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        ETowerHP.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        ETowerHP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ETowerHP.setText("HP : ");

        UTowerHP.setBackground(new java.awt.Color(0, 0, 0));
        UTowerHP.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        UTowerHP.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UTowerHP.setText("HP : ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cartoon Battle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LaserValue.setFont(new java.awt.Font("Lato Black", 0, 28)); // NOI18N
        LaserValue.setForeground(new java.awt.Color(255, 255, 255));
        LaserValue.setText("0");
        getContentPane().add(LaserValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(998, 668, -1, -1));

        EnemyHpBar.setBackground(new java.awt.Color(255, 255, 255));
        EnemyHpBar.setForeground(new java.awt.Color(0, 255, 0));
        EnemyHpBar.setValue(100);
        EnemyHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(EnemyHpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 580, -1, 10));

        UserHpBar.setBackground(new java.awt.Color(255, 255, 255));
        UserHpBar.setForeground(new java.awt.Color(0, 255, 0));
        UserHpBar.setValue(100);
        UserHpBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(UserHpBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, 10));

        Level.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        Level.setText("Level : ");
        getContentPane().add(Level, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 140, 40));

        Final.setBackground(new java.awt.Color(255, 255, 255));
        Final.setFont(new java.awt.Font("Lato Black", 1, 24)); // NOI18N
        Final.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Final.setText("WIN");
        Final.setOpaque(true);
        getContentPane().add(Final, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 230, 170, 50));

        Minerallab.setBackground(new java.awt.Color(0, 0, 0));
        Minerallab.setFont(new java.awt.Font("Lato Black", 1, 27)); // NOI18N
        Minerallab.setForeground(new java.awt.Color(255, 255, 255));
        Minerallab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Minerallab.setText("0");
        getContentPane().add(Minerallab, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 39, 150, 40));

        MineralIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mineral.png"))); // NOI18N
        getContentPane().add(MineralIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, -1, -1));

        LaserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Laser Icon.png"))); // NOI18N
        LaserIcon.setBorderPainted(false);
        LaserIcon.setContentAreaFilled(false);
        LaserIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaserIconActionPerformed(evt);
            }
        });
        getContentPane().add(LaserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 580, -1, -1));

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
        getContentPane().add(AddMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 130, 120));

        AddRange.setBackground(new java.awt.Color(0, 0, 0));
        AddRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ranged Icon.png"))); // NOI18N
        AddRange.setBorderPainted(false);
        AddRange.setContentAreaFilled(false);
        AddRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRangeActionPerformed(evt);
            }
        });
        getContentPane().add(AddRange, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 580, 130, 120));

        AddTank.setBackground(new java.awt.Color(0, 0, 0));
        AddTank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tank Icon.png"))); // NOI18N
        AddTank.setBorderPainted(false);
        AddTank.setContentAreaFilled(false);
        AddTank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTankActionPerformed(evt);
            }
        });
        getContentPane().add(AddTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 580, 130, 120));

        Laser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Laser.gif"))); // NOI18N
        getContentPane().add(Laser, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Battle Map.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Add Melee
    private void AddMeleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddMeleeActionPerformed
        // TODO add your handling code here:
        if(Mineral >= 10){
            TroopX.add(0);
            Troop.add(new Melee(userT.get(0).getHP(), userT.get(0).getAtk()));
            Trooplab.add(new JLabel());
            Trooplab.get(Trooplab.size()-1).setIcon(Micon);
            Trooplab.get(Trooplab.size()-1).setBounds(150, 480, 68, 68); //x, y, lebar, tinggi
            getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
            Mineral -= 10;
        }
    }//GEN-LAST:event_AddMeleeActionPerformed

    //Add Ranged
    private void AddRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRangeActionPerformed
        // TODO add your handling code here:
        if(Mineral >= 30){
            if(userT.get(1) instanceof Ranged){
                Troop.add(new Ranged(userT.get(1).getHP(), userT.get(1).getAtk()));
            }else{
                Troop.add(new Ranged(userT.get(2).getHP(), userT.get(2).getAtk()));
            }
            TroopX.add(0);
            Trooplab.add(new JLabel());
            Trooplab.get(Trooplab.size()-1).setIcon(Ricon);
            Trooplab.get(Trooplab.size()-1).setBounds(120, 435, 120, 120); //x, y, lebar, tinggi
            getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
            Mineral -= 30;
        }
    }//GEN-LAST:event_AddRangeActionPerformed

    //Add Tank
    private void AddTankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddTankActionPerformed
        // TODO add your handling code here:
        if(Mineral >= 20){
            if(userT.get(1) instanceof Tank){
                Troop.add(new Tank(userT.get(1).getHP(), userT.get(1).getAtk()));
            }else{
                Troop.add(new Tank(userT.get(2).getHP(), userT.get(2).getAtk()));
            }
            TroopX.add(0);
            Trooplab.add(new JLabel());
            Trooplab.get(Trooplab.size()-1).setIcon(Ticon);
            Trooplab.get(Trooplab.size()-1).setBounds(119, 430, 130, 130); //x, y, lebar, tinggi
            getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
            Mineral -= 20;
        }
    }//GEN-LAST:event_AddTankActionPerformed

    //Add Enemy
    private void AddEnemy(){
        
    }
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

int waktu;
private Timer las;
    private void LaserIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaserIconActionPerformed
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
                    for(int i = 0; i < Enemylab.size(); i++){
                        getContentPane().remove(Enemylab.get(i));
                    }
                    Enemylab.clear();
                    EnemyX.clear();
                    EnemyList.clear();
                    getContentPane().validate();
                    getContentPane().repaint();
                    Laser.setVisible(false);
                    las.stop();
                }
            }
        };
        las = new Timer(1000, act);
        las.start();
    }//GEN-LAST:event_LaserIconActionPerformed

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
    private javax.swing.JLabel ETowerHP;
    private javax.swing.JProgressBar EnemyHpBar;
    private javax.swing.JLabel Final;
    private javax.swing.JLabel Laser;
    private javax.swing.JButton LaserIcon;
    private javax.swing.JLabel LaserValue;
    private javax.swing.JLabel Level;
    private javax.swing.JLabel MineralIcon;
    private javax.swing.JLabel Minerallab;
    private javax.swing.JLabel UTowerHP;
    private javax.swing.JProgressBar UserHpBar;
    // End of variables declaration//GEN-END:variables
}
