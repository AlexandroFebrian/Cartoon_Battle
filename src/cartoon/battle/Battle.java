/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
    private final ImageIcon Micon = new ImageIcon("src\\images\\Melee1.gif");
    private final ImageIcon Micon2 = new ImageIcon("src\\images\\Melee2.gif");
    private final ImageIcon Ricon = new ImageIcon("src\\images\\Ranged1.gif");
    private final ImageIcon Ricon2 = new ImageIcon("src\\images\\Ranged2.gif");
    private final ImageIcon Ticon = new ImageIcon("src\\images\\Tank1.gif");
    private final ImageIcon Ticon2 = new ImageIcon("src\\images\\Tank2.gif");
    private final ImageIcon Eicon = new ImageIcon("src\\images\\Enemy1.gif");
    private final ImageIcon Eicon2 = new ImageIcon("src\\images\\Enemy2.gif");
    
    private ArrayList<JLabel> Trooplab = new ArrayList<>();
    private ArrayList<Troops> Troop = new ArrayList<>();
    private Timer TroopMove;
    private ArrayList<Troops> userT = new ArrayList<>();
    private ArrayList<Integer> TroopX = new ArrayList<>();
    private Timer TroopAtkTime;
    private int UserTowerHP;
    private int MaxMineral = 100;
    
    private ArrayList<Sound> TroopSound = new ArrayList<>();
    
    private ArrayList<JLabel> Enemylab = new ArrayList<>();
    private ArrayList<Integer> EnemyX = new ArrayList<>();
    private Timer EnemyMove;
    private Timer EnemySpawnT;
    private int SpawnTime = 0;
    
    private int EnemyHP = 30;
    private int EnemyAtk = 5;
    private int EnemyTowerHP = 1000;
    private ArrayList<Integer> EnemyList = new ArrayList<>();
    private Timer EnemyAtkTime;
    private int EnemySpawnSpeed = 2000;
    
    private ArrayList<Sound> EnemySound = new ArrayList<>();
    
    private int Mineral = 0;
    private Timer MineralT;
    private int MineralSpeed = 250;
    private int MineralPrice = 25;
    
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
    
    public int getEnemyTowerHP() {
        return EnemyTowerHP;
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
        for (int i = 0; i < TroopSound.size(); i++) {
            TroopSound.get(i).stop();
        }
        TroopSound.clear();
        for (int i = 0; i < EnemySound.size(); i++) {
            EnemySound.get(i).stop();
        }
        EnemySound.clear();
        Trooplab.clear();
    }

    private void Win(Sound sound){
        StopAllTimer();
        sound.changeMusicResult(new File("src\\music\\Win.wav"));
        BattleResult.setVisible(true);
        Gold.setVisible(true);
        BattleResult.setIcon(new ImageIcon("src\\images\\Win.png"));
        Back.setBounds(520, 365, 280, 110);
        Back.setIcon(new ImageIcon("src\\images\\Menu.png"));
    }
    
    private void Lose(Sound sound) {
        StopAllTimer();
        sound.changeMusicResult(new File("src\\music\\Lose.wav"));
        BattleResult.setVisible(true);
        Gold.setVisible(true);
        BattleResult.setIcon(new ImageIcon("src\\images\\Lose.png"));
        Back.setBounds(520, 365, 280, 110);
        Back.setIcon(new ImageIcon("src\\images\\Menu.png"));
    }
    
    public Battle() {
        initComponents();
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
        
    }

    public Battle(User user, Sound sound){
        initComponents();
        getContentPane().setLayout(null);
        
        EnemyHP += (user.getLevelEnemy()-1)*25;
        EnemyAtk += (user.getLevelEnemy()-1)*5;
        EnemyTowerHP += (user.getLevelEnemy()-1)*100;
        Level.setText("Level : " + String.valueOf(user.getLevelEnemy()));
        
        UserTowerHP = user.getTower().getHp();
        
        LaserValue.setText(String.valueOf(user.getSkill()));
        UpgradeMineralValue.setText(String.valueOf(MineralPrice));
        
        //Mineral
        MineralT = new Timer(MineralSpeed, new ActionListener(){
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
        BattleResult.setVisible(false);
        Gold.setVisible(false);
        WarningText.setVisible(false);
        
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
        EnemySpawnSpeed -= (user.getLevelEnemy()-1)*50;
        if(EnemySpawnSpeed < 1000){
            EnemySpawnSpeed = 1000;
        }
        ActionListener spawn = new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                SpawnTime+=1;
                if(SpawnTime == 5){
                    SpawnTime = 0;
                    EnemySound.add(new Sound(new File("src\\music\\Enemy.wav"), true));
                    EnemyX.add(0);
                    EnemyList.add(EnemyHP);
                    Enemylab.add(new JLabel());
                    Enemylab.get(Enemylab.size()-1).setIcon(Eicon);
                    Enemylab.get(Enemylab.size()-1).setBounds(1030, 419, 200, 133); //x, y, lebar, tinggi
                    getContentPane().add(Enemylab.get(Enemylab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
                }
            }
        };
        EnemySpawnT = new Timer(EnemySpawnSpeed, spawn);
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
                    if(Enemylab.get(i).getIcon() == Eicon && Trooplab.isEmpty()){
                        if(Enemylab.get(i).getLocation().x <= 175 && Enemylab.get(i).getIcon() != Eicon2){
                            Enemylab.get(i).setIcon(Eicon2);
                        }else if(Enemylab.get(i).getIcon() == Eicon){
                            Enemylab.get(i).setLocation(Enemylab.get(i).getLocation().x-1, Enemylab.get(i).getLocation().y);
                            EnemySound.get(i).stop();
                        }
                    }else if(Trooplab.size() >= 1){
                        if(Trooplab.get(0).getLocation().x <= Enemylab.get(i).getLocation().x && Trooplab.get(0).getLocation().x >= Enemylab.get(i).getLocation().x-75 && Enemylab.get(i).getIcon() != Eicon2){
                            //ganti icon nyerang
                            Enemylab.get(i).setIcon(Eicon2);
                        }
                        else if(Enemylab.get(i).getIcon() == Eicon){
                            Enemylab.get(i).setLocation(Enemylab.get(i).getLocation().x-1, Enemylab.get(i).getLocation().y);
                            EnemySound.get(i).stop();
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
                                    TroopSound.get(0).stop();
                                    TroopSound.remove(0);
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
                            EnemySound.get(i).start();
                        }else{
                            if(Enemylab.get(i).getLocation().x <= 175){
                                EnemySound.get(i).start();
                                UserTowerHP -= EnemyAtk;
                                UserHpBar.setValue((int)(UserTowerHP * 100) / user.getTower().getHp());
                                if(UserTowerHP <= 0){
                                    Lose(sound);
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
                        if(Trooplab.get(i).getIcon() == Micon && Enemylab.isEmpty()){
                            if(Trooplab.get(i).getLocation().x >= 1010 && Trooplab.get(i).getIcon() != Micon2){
                                Trooplab.get(i).setIcon(Micon2);
                            }else if(Trooplab.get(i).getIcon() == Micon){
                                TroopSound.get(i).stop();
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+20 && Trooplab.get(i).getIcon() != Micon2){
                                //ganti icon nyerang
//                                Trooplab.get(i).setBounds(TroopX.get(i), 480, 105, 70); //x, y, lebar, tinggi
                                Trooplab.get(i).setIcon(Micon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Micon){
                                TroopSound.get(i).stop();
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }else if(Troop.get(i) instanceof Ranged){
                        if(Trooplab.get(i).getIcon() == Ricon && Enemylab.isEmpty()){
                            if(Trooplab.get(i).getLocation().x >= 780 && Trooplab.get(i).getIcon() != Ricon2){
                                Trooplab.get(i).setIcon(Ricon2);
                            }else if(Trooplab.get(i).getIcon() == Ricon){
                                TroopSound.get(i).stop();
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+250 && Trooplab.get(i).getIcon() != Ricon2){
                                //ganti icon nyerang
//                                Trooplab.get(i).setBounds(TroopX.get(i), 435, 300, 120); //x, y, lebar, tinggi
                                Trooplab.get(i).setIcon(Ricon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Ricon){
                                TroopSound.get(i).stop();
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }
                    }else{
                        if(Trooplab.get(i).getIcon() == Ticon && Enemylab.isEmpty()){
                            if(Trooplab.get(i).getLocation().x >= 955 && Trooplab.get(i).getIcon() != Ticon2){
                                Trooplab.get(i).setIcon(Ticon2);
                            }else if(Trooplab.get(i).getIcon() == Ticon){
                                TroopSound.get(i).stop();
                                Trooplab.get(i).setLocation(Trooplab.get(i).getLocation().x+1, Trooplab.get(i).getLocation().y);
                            }
                        }else if(Enemylab.size() >= 1){
                            if(Enemylab.get(0).getLocation().x >= Trooplab.get(i).getLocation().x && Enemylab.get(0).getLocation().x <= Trooplab.get(i).getLocation().x+75 && Trooplab.get(i).getIcon() != Ticon2){
                                //ganti icon nyerang
//                                Trooplab.get(i).setBounds(TroopX.get(i), 430, 195, 130); //x, y, lebar, tinggi
                                Trooplab.get(i).setIcon(Ticon2);
                            }
                            else if(Trooplab.get(i).getIcon() == Ticon){
                                TroopSound.get(i).stop();
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
                                    EnemySound.get(0).stop();
                                    EnemySound.remove(0);
                                    EnemyList.remove(0);
                                    Enemylab.remove(0);
                                    EnemyX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    EnemyList.set(0, EnemyList.get(0)-Troop.get(i).getAtk());
                                }
                                TroopSound.get(i).start();
                            }else{
                                Trooplab.get(i).setIcon(Micon);
                            }
                        }else{
                            if(Trooplab.get(i).getLocation().x >= 1010){
                                    TroopSound.get(i).start();
                                    EnemyTowerHP -= Troop.get(i).getAtk();
                                    EnemyHpBar.setValue((int)(EnemyTowerHP * 100) / (1000 + ((user.getLevelEnemy() - 1) * 100)));
                                    if(EnemyTowerHP <= 0){
                                        Win(sound);
                                        Gold.setText("+" + String.valueOf(50*user.getLevelEnemy()));
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
                                    EnemySound.get(0).stop();
                                    EnemySound.remove(0);
                                    EnemyList.remove(0);
                                    Enemylab.remove(0);
                                    EnemyX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    EnemyList.set(0, EnemyList.get(0)-Troop.get(i).getAtk());
                                }
                                TroopSound.get(i).start();
                            }else{
                                Trooplab.get(i).setIcon(Ricon);
                            }
                        }else{
                            if(Trooplab.get(i).getLocation().x >= 780){
                                    TroopSound.get(i).start();
                                    EnemyTowerHP -= Troop.get(i).getAtk();
                                    EnemyHpBar.setValue((int)(EnemyTowerHP * 100) / (1000 + ((user.getLevelEnemy() - 1) * 100)));
                                    if(EnemyTowerHP <= 0){
                                        Win(sound);
                                        Gold.setText("+" + String.valueOf(50*user.getLevelEnemy()));
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
                                    EnemySound.get(0).stop();
                                    EnemySound.remove(0);
                                    EnemyList.remove(0);
                                    Enemylab.remove(0);
                                    EnemyX.remove(0);
                                    getContentPane().validate();
                                    getContentPane().repaint();
                                    i = 0;
                                }else{
                                    EnemyList.set(0, EnemyList.get(0)-Troop.get(i).getAtk());
                                }
                                TroopSound.get(i).start();
                            }else{
                                Trooplab.get(i).setIcon(Ticon);
                            }
                        }else{
                            if(Trooplab.get(i).getLocation().x >= 955){
                                    TroopSound.get(i).start();
                                    EnemyTowerHP -= Troop.get(i).getAtk();
                                    EnemyHpBar.setValue((int)(EnemyTowerHP * 100) / (1000 + ((user.getLevelEnemy() - 1) * 100)));
                                    if(EnemyTowerHP <= 0){
                                        Win(sound);
                                        Gold.setText("+" + String.valueOf(50*user.getLevelEnemy()));
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

        Gold = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        WarningText = new javax.swing.JLabel();
        BattleResult = new javax.swing.JLabel();
        UpgradeMineralValue = new javax.swing.JLabel();
        UpgradeMineral = new javax.swing.JButton();
        LaserValue = new javax.swing.JLabel();
        LaserIcon = new javax.swing.JButton();
        EnemyHpBar = new javax.swing.JProgressBar();
        UserHpBar = new javax.swing.JProgressBar();
        Level = new javax.swing.JLabel();
        Minerallab = new javax.swing.JLabel();
        MineralIcon = new javax.swing.JLabel();
        AddMelee = new javax.swing.JButton();
        AddRange = new javax.swing.JButton();
        AddTank = new javax.swing.JButton();
        Laser = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cartoon Battle");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Gold.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        Gold.setText("+0");
        getContentPane().add(Gold, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 322, 120, -1));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 100));

        WarningText.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        WarningText.setForeground(new java.awt.Color(255, 0, 0));
        WarningText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WarningText.setText("...");
        getContentPane().add(WarningText, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 490, 50));

        BattleResult.setBackground(new java.awt.Color(255, 255, 255));
        BattleResult.setFont(new java.awt.Font("Lato Black", 1, 24)); // NOI18N
        BattleResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BattleResult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Win.png"))); // NOI18N
        getContentPane().add(BattleResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        UpgradeMineralValue.setFont(new java.awt.Font("Lato Black", 0, 18)); // NOI18N
        UpgradeMineralValue.setForeground(new java.awt.Color(255, 255, 255));
        UpgradeMineralValue.setText("0");
        getContentPane().add(UpgradeMineralValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 669, 50, -1));

        UpgradeMineral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Upgrade Mineral Icon.png"))); // NOI18N
        UpgradeMineral.setBorderPainted(false);
        UpgradeMineral.setContentAreaFilled(false);
        UpgradeMineral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpgradeMineralActionPerformed(evt);
            }
        });
        getContentPane().add(UpgradeMineral, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 120, 120));

        LaserValue.setFont(new java.awt.Font("Lato Black", 0, 24)); // NOI18N
        LaserValue.setForeground(new java.awt.Color(255, 255, 255));
        LaserValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LaserValue.setText("0");
        getContentPane().add(LaserValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1018, 667, 30, -1));

        LaserIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Laser Icon.png"))); // NOI18N
        LaserIcon.setBorderPainted(false);
        LaserIcon.setContentAreaFilled(false);
        LaserIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaserIconActionPerformed(evt);
            }
        });
        getContentPane().add(LaserIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(907, 577, -1, -1));

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
        Level.setForeground(new java.awt.Color(255, 255, 255));
        Level.setText("Level : ");
        getContentPane().add(Level, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 590, 110, 40));

        Minerallab.setBackground(new java.awt.Color(0, 0, 0));
        Minerallab.setFont(new java.awt.Font("Lato Black", 1, 27)); // NOI18N
        Minerallab.setForeground(new java.awt.Color(255, 255, 255));
        Minerallab.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Minerallab.setText("0");
        getContentPane().add(Minerallab, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 39, 150, 40));

        MineralIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Mineral.png"))); // NOI18N
        getContentPane().add(MineralIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, -1, -1));

        AddMelee.setBackground(new java.awt.Color(0, 0, 0));
        AddMelee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Melee Icon.png"))); // NOI18N
        AddMelee.setBorderPainted(false);
        AddMelee.setContentAreaFilled(false);
        AddMelee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddMeleeActionPerformed(evt);
            }
        });
        getContentPane().add(AddMelee, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 580, 130, 120));

        AddRange.setBackground(new java.awt.Color(0, 0, 0));
        AddRange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ranged Icon.png"))); // NOI18N
        AddRange.setBorderPainted(false);
        AddRange.setContentAreaFilled(false);
        AddRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRangeActionPerformed(evt);
            }
        });
        getContentPane().add(AddRange, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 580, 130, 120));

        AddTank.setBackground(new java.awt.Color(0, 0, 0));
        AddTank.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tank Icon.png"))); // NOI18N
        AddTank.setBorderPainted(false);
        AddTank.setContentAreaFilled(false);
        AddTank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddTankActionPerformed(evt);
            }
        });
        getContentPane().add(AddTank, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 580, 130, 120));

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
            TroopSound.add(new Sound(new File("src\\music\\Melee.wav"), true));
            TroopX.add(0);
            Troop.add(new Melee(userT.get(0).getHP(), userT.get(0).getAtk()));
            Trooplab.add(new JLabel());
            Trooplab.get(Trooplab.size()-1).setIcon(Micon);
            Trooplab.get(Trooplab.size()-1).setBounds(150, 480, 105, 70); //x, y, lebar, tinggi
            getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
            Mineral -= 10;
        }else if(TimerCek == null){
            WarningText.setText("Not enough energy!");
            WarningText.setVisible(true);
            waktu = 0;
            ActionListener act = new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    waktu++;
                    if(waktu == 2){
                        WarningText.setVisible(false);
                        TimerCek.stop();
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
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
            TroopSound.add(new Sound(new File("src\\music\\Ranged.wav"), true));
            TroopX.add(0);
            Trooplab.add(new JLabel());
            Trooplab.get(Trooplab.size()-1).setIcon(Ricon);
            Trooplab.get(Trooplab.size()-1).setBounds(120, 435, 300, 120); //x, y, lebar, tinggi
            getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
            Mineral -= 30;
        }else if(TimerCek == null){
            WarningText.setText("Not enough energy!");
            WarningText.setVisible(true);
            waktu = 0;
            ActionListener act = new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    waktu++;
                    if(waktu == 2){
                        WarningText.setVisible(false);
                        TimerCek.stop();
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
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
            TroopSound.add(new Sound(new File("src\\music\\Tank.wav"), true));
            TroopX.add(0);
            Trooplab.add(new JLabel());
            Trooplab.get(Trooplab.size()-1).setIcon(Ticon);
            Trooplab.get(Trooplab.size()-1).setBounds(119, 430, 195, 130); //x, y, lebar, tinggi
            getContentPane().add(Trooplab.get(Trooplab.size()-1), new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1), 1);
            Mineral -= 20;
        }else if(TimerCek == null){
            WarningText.setText("Not enough energy!");
            WarningText.setVisible(true);
            waktu = 0;
            ActionListener act = new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    waktu++;
                    if(waktu == 2){
                        WarningText.setVisible(false);
                        TimerCek.stop();
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
        }
    }//GEN-LAST:event_AddTankActionPerformed
    
    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BackActionPerformed

    private int waktu;
    private Timer TimerCek = null;
    private Sound sou = new Sound(new File("src\\music\\Laser.wav"), true);
    private boolean UseLaser = true;

    private void LaserIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaserIconActionPerformed
        // TODO add your handling code here:
        if(UseLaser == true && !LaserValue.getText().equals("0") && TimerCek == null){
            UseLaser = false;
            LaserValue.setText(String.valueOf(Integer.parseInt(LaserValue.getText())-1));
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
                    } else if (waktu == 2) {
                        sou.stop();
                        TimerCek.stop();
                        sou = null;
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
            sou.start();
        }else if(UseLaser == false && TimerCek == null){
            WarningText.setText("Laser has been used!");
            WarningText.setVisible(true);
            waktu = 0;
            ActionListener act = new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    waktu++;
                    if(waktu == 2){
                        WarningText.setVisible(false);
                        TimerCek.stop();
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
        }else if(LaserValue.getText().equals("0") && TimerCek == null){
            WarningText.setText("You don't have any laser!");
            WarningText.setVisible(true);
            waktu = 0;
            ActionListener act = new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    waktu++;
                    if(waktu == 2){
                        WarningText.setVisible(false);
                        TimerCek.stop();
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
        }
    }//GEN-LAST:event_LaserIconActionPerformed

    private void UpgradeMineralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpgradeMineralActionPerformed
        // TODO add your handling code here:
        if(Mineral >= MineralPrice){
            Mineral -= MineralPrice;
            MineralSpeed -= 25;
            if(MineralSpeed < 50){
                MineralSpeed = 50;
            }
            MaxMineral += 25;
            MineralPrice += 25;
            UpgradeMineralValue.setText(String.valueOf(MineralPrice));
            
            MineralT.stop();
            MineralT = null;
            MineralT = new Timer(MineralSpeed, new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(Mineral < MaxMineral){
                        Mineral++;
                    }
                    Minerallab.setText(String.valueOf(Mineral) + "/" + String.valueOf(MaxMineral));
                }
            });
            MineralT.start();
        }else if(TimerCek == null){
            WarningText.setText("Not enough energy!");
            WarningText.setVisible(true);
            waktu = 0;
            ActionListener act = new ActionListener(){
                public void actionPerformed(ActionEvent event) {
                    waktu++;
                    if(waktu == 2){
                        WarningText.setVisible(false);
                        TimerCek.stop();
                        TimerCek = null;
                    }
                }
            };
            TimerCek = new Timer(1000, act);
            TimerCek.start();
        }
    }//GEN-LAST:event_UpgradeMineralActionPerformed

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
    private javax.swing.JLabel BattleResult;
    private javax.swing.JProgressBar EnemyHpBar;
    private javax.swing.JLabel Gold;
    private javax.swing.JLabel Laser;
    private javax.swing.JButton LaserIcon;
    private javax.swing.JLabel LaserValue;
    private javax.swing.JLabel Level;
    private javax.swing.JLabel MineralIcon;
    private javax.swing.JLabel Minerallab;
    private javax.swing.JButton UpgradeMineral;
    private javax.swing.JLabel UpgradeMineralValue;
    private javax.swing.JProgressBar UserHpBar;
    private javax.swing.JLabel WarningText;
    // End of variables declaration//GEN-END:variables
}
