/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cartoon.battle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import static cartoon.battle.CartoonBattle.listUser;

/**
 *
 * @author User
 */

//JTextField class limit
class JTextFieldLimit extends PlainDocument {
    private int limit;
    
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null) {
            return;
        }
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    private Sound sound;
    private Timer t;
    private static int waktu = 0;
    
    private void invisibleIcon() {
        BlackBackground.setVisible(false);
        Background.setVisible(false);
        Username.setVisible(false);
        IsiUser.setVisible(false);
        Warning.setVisible(false);
        Play.setVisible(false);
        Title.setVisible(false);
        New.setVisible(false);
        Load.setVisible(false);
        Setting.setVisible(false);
        Help.setVisible(false);
        Volume.setVisible(false);
        VolumeControl.setVisible(false);
        Back.setVisible(false);
        XMark.setVisible(false);
        Help1.setVisible(false);
        Help2.setVisible(false);
        Help3.setVisible(false);
        Help4.setVisible(false);
        Help5.setVisible(false);
        Help6.setVisible(false);
        Tap.setVisible(false);
        LoadGameBackground.setVisible(false);
        UserIndex0.setVisible(false);
        UserNameIndex0.setVisible(false);
        UserIndex1.setVisible(false);
        UserNameIndex1.setVisible(false);
        UserIndex2.setVisible(false);
        UserNameIndex2.setVisible(false);
        UserIndex3.setVisible(false);
        UserNameIndex3.setVisible(false);
        UserIndex4.setVisible(false);
        UserNameIndex4.setVisible(false); 
    }
    
    public void menuUtama() {
        IsiUser.setText("");
        Troop.setVisible(false);
        VolumeControl.setVisible(false);
        BlackBackground.setVisible(false);
        Background1.setVisible(false);
        Cartoon.setVisible(false);
        Back.setVisible(false);
        Username.setVisible(false);
        IsiUser.setVisible(false);
        Warning.setVisible(false);
        Play.setVisible(false);
        Loading.setVisible(false);
        Volume.setVisible(false);
        Background.setVisible(true);
        Title.setVisible(true);
        New.setVisible(true);
        Load.setVisible(true);
        Setting.setVisible(true);
        Help.setVisible(true);
        XMark.setVisible(false);
        Help1.setVisible(false);
        Help2.setVisible(false);
        Help3.setVisible(false);
        Help4.setVisible(false);
        Help5.setVisible(false);
        Help6.setVisible(false);
        Tap.setVisible(false);
        LoadGameBackground.setVisible(false);
        UserIndex0.setVisible(false);
        UserNameIndex0.setVisible(false);
        UserIndex1.setVisible(false);
        UserNameIndex1.setVisible(false);
        UserIndex2.setVisible(false);
        UserNameIndex2.setVisible(false);
        UserIndex3.setVisible(false);
        UserNameIndex3.setVisible(false);
        UserIndex4.setVisible(false);
        UserNameIndex4.setVisible(false);
    }
    
    private void newGame() {
        New.setVisible(false);
        Load.setVisible(false);
        Setting.setVisible(false);
        Help.setVisible(false);
        Back.setVisible(true);
        Background.setVisible(true);
        Username.setVisible(true);
        IsiUser.setVisible(true);
        Play.setVisible(true);
    }
    
    private void loadGame(ArrayList <User> u, Sound s) {
        LoadGameBackground.setVisible(true);
        Back.setVisible(true);
        if (!u.isEmpty()) {
            UserIndex0.setVisible(true);
            UserNameIndex0.setVisible(true);
            if (u.size() > 1) {
                UserIndex1.setVisible(true);
                UserNameIndex1.setVisible(true);
                if (u.size() > 2) {
                    UserIndex2.setVisible(true);
                    UserNameIndex2.setVisible(true);
                    if (u.size() > 3) {
                        UserIndex3.setVisible(true);
                        UserNameIndex3.setVisible(true);
                        if (u.size() > 4) {
                            UserIndex4.setVisible(true);
                            UserNameIndex4.setVisible(true);
                        }
                    }
                }
            }
        }
        
        for (int i = 0; i < u.size(); i++) {
            if (i == 0) {
                UserNameIndex0.setText(u.get(i).getUsername());
            } else if (i == 1) {
                UserNameIndex1.setText(u.get(i).getUsername());
            } else if (i == 2) {
                UserNameIndex2.setText(u.get(i).getUsername());
            } else if (i == 3) {
                UserNameIndex3.setText(u.get(i).getUsername());
            } else if (i == 4) {
                UserNameIndex4.setText(u.get(i).getUsername());
            }
        }
        UserIndex0.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                homeUser(u.get(0), s);
            }   
        });
        UserIndex1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                homeUser(u.get(1), s);
            }   
        });
        UserIndex2.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                homeUser(u.get(2), s);
            }   
        });
        UserIndex3.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                homeUser(u.get(3), s);
            }   
        });
        UserIndex4.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                homeUser(u.get(4), s);
            }   
        });
    }
    
    
    private void setting() {
        BlackBackground.setVisible(true);
        Volume.setVisible(true);
        XMark.setVisible(true);
        VolumeControl.setVisible(true);
    }
    
    private void help() {
        invisibleIcon();
        Tap.setVisible(true);
        Help1.setVisible(true);
        Help1.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Help1.setVisible(false);
                Help2.setVisible(true);
            }   
        });
        Help2.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Help2.setVisible(false);
                Help3.setVisible(true);
            }   
        });
        Help3.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Help3.setVisible(false);
                Help4.setVisible(true);
            }   
        });
        Help4.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Help4.setVisible(false);
                Help5.setVisible(true);
            }   
        });
        Help5.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Help5.setVisible(false);
                Help6.setVisible(true);
            }   
        });
        Help6.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Help6.setVisible(false);
                menuUtama();
            }   
        });
    }
    
    public void playMusic(Sound sound) {
        VolumeControl.setValue((int)sound.getVolume());
        VolumeControl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sound.changeVolume(VolumeControl.getValue());
            }
        });
    }
    
    private void homeUser(User u, Sound sound) {
        Login l = this;
        l.setVisible(false);
        Home h = new Home(u.getUsername(), String.valueOf(u.getGold()), sound);
        h.setLocationRelativeTo(null);
        h.setResizable(false);
        h.setVisible(true);

        //Logout
        h.getLogout().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                h.setVisible(false);
                l.setVisible(true);
                l.playMusic(sound);
                l.menuUtama();
            }
        });

        //Shop <Daniello>
        h.getShop().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Shop s = new Shop(u);
                s.setLocationRelativeTo(null);
                s.setResizable(false);
                h.setVisible(false);
                s.setVisible(true);
                s.getBack().addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        s.dispose();
                        h.setVisible(true);
                        h.getGold().setText(String.valueOf(u.getGold()));
                    }
                });
            }
        });

        //Kingdom <Jessica>
        h.getKingdom().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                Kingdom k = new Kingdom(u);
                k.setLocationRelativeTo(null);
                k.setResizable(false);
                h.setVisible(false);
                k.setVisible(true);
                k.getBack().addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        k.dispose();
                        h.setVisible(true);
                        h.getGold().setText(String.valueOf(u.getGold()));
                    }
                });
            }
        });

        //Battle <Febrian>
        h.getBattle().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                sound.changeMusic(new File("src\\music\\Battle.wav"));
                Battle b = new Battle(u, sound);
                b.setLocationRelativeTo(null);
                b.setResizable(false);
                h.setVisible(false);
                b.setVisible(true);
                b.getBack().addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent me){
                        sound.changeMusic(new File("src\\music\\Home.wav"));
                        b.dispose();
                        b.StopAllTimer();
                        h.setVisible(true);
                        if(b.getEnemyTowerHP() <= 0){
                            int tempGold = u.getGold()+50*u.getLevelEnemy();
                            u.setGold(tempGold);
                            u.setLevelEnemy(u.getLevelEnemy()+1);
                            h.getGold().setText(String.valueOf(u.getGold()));
                        }
                        try {            
                            FileOutputStream fout = new FileOutputStream("user.dat");
                            ObjectOutputStream oos = new ObjectOutputStream(fout);
                            oos.writeObject(listUser);
                            oos.close();
                            fout.close();
                        }catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                });
            }
        });
    }
    
    public Login(Sound sound, ArrayList <User> u) {
        initComponents();
        
        //JTextField Limit
        IsiUser.setDocument(new JTextFieldLimit(10));
        
        //Center Text Field
        IsiUser.setHorizontalAlignment(JTextField.CENTER);
        
        //Icon Image <Wajib di tiap form>
        ImageIcon img = new ImageIcon("src\\images\\Icon.jpg");
        this.setIconImage(img.getImage());
        
        //Default Display
        invisibleIcon();
        
        //Music
        playMusic(sound);
        
        //Timer
        ActionListener act = new ActionListener(){
            public void actionPerformed(ActionEvent event){
                waktu++;
                Troop.setLocation(Troop.getLocation().x + 5, Troop.getLocation().y);
                Loading.setValue(waktu);
                if (waktu == 100) {
                    menuUtama();
                    Back.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            menuUtama();
                        }
                    });
                    New.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            newGame();
                        }
                    });
                    Load.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            loadGame(u, sound);
                        }
                    });
                    Setting.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            setting();
                        }
                    });
                    XMark.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            menuUtama();
                        }
                    });
                    Help.addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            help();
                        }
                    });
                    t.stop();
                }
            }
        };
        t = new Timer(30, act);
        t.start();
    }
    
    public Login() {
        initComponents();
    }

    public int getWaktu() {
        return waktu;
    }

    public JButton getPlay() {
        return Play;
    }

    public JTextField getIsiUser() {
        return IsiUser;
    }
    public void warnMessage() {
        Warning.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserNameIndex4 = new javax.swing.JLabel();
        UserNameIndex3 = new javax.swing.JLabel();
        UserNameIndex2 = new javax.swing.JLabel();
        UserNameIndex1 = new javax.swing.JLabel();
        UserNameIndex0 = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        UserIndex4 = new javax.swing.JButton();
        UserIndex3 = new javax.swing.JButton();
        UserIndex2 = new javax.swing.JButton();
        UserIndex1 = new javax.swing.JButton();
        UserIndex0 = new javax.swing.JButton();
        LoadGameBackground = new javax.swing.JLabel();
        Tap = new javax.swing.JLabel();
        Help1 = new javax.swing.JLabel();
        Help2 = new javax.swing.JLabel();
        Help3 = new javax.swing.JLabel();
        Help4 = new javax.swing.JLabel();
        Help5 = new javax.swing.JLabel();
        Help6 = new javax.swing.JLabel();
        Troop = new javax.swing.JLabel();
        Cartoon = new javax.swing.JLabel();
        Loading = new javax.swing.JProgressBar();
        Background1 = new javax.swing.JLabel();
        XMark = new javax.swing.JButton();
        VolumeControl = new javax.swing.JSlider();
        Volume = new javax.swing.JLabel();
        BlackBackground = new javax.swing.JLabel();
        New = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        Setting = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        Load = new javax.swing.JButton();
        Warning = new javax.swing.JLabel();
        IsiUser = new javax.swing.JTextField();
        Username = new javax.swing.JLabel();
        Play = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cartoon Battle");
        setSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserNameIndex4.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        UserNameIndex4.setForeground(new java.awt.Color(255, 255, 255));
        UserNameIndex4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameIndex4.setText("User.get(4)");
        getContentPane().add(UserNameIndex4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 350, -1));

        UserNameIndex3.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        UserNameIndex3.setForeground(new java.awt.Color(255, 255, 255));
        UserNameIndex3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameIndex3.setText("User.get(3)");
        getContentPane().add(UserNameIndex3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 360, -1));

        UserNameIndex2.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        UserNameIndex2.setForeground(new java.awt.Color(255, 255, 255));
        UserNameIndex2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameIndex2.setText("User.get(2)");
        getContentPane().add(UserNameIndex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 330, -1));

        UserNameIndex1.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        UserNameIndex1.setForeground(new java.awt.Color(255, 255, 255));
        UserNameIndex1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameIndex1.setText("User.get(1)");
        getContentPane().add(UserNameIndex1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 340, -1));

        UserNameIndex0.setFont(new java.awt.Font("Lato Black", 0, 36)); // NOI18N
        UserNameIndex0.setForeground(new java.awt.Color(255, 255, 255));
        UserNameIndex0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserNameIndex0.setText("User.get(0)");
        getContentPane().add(UserNameIndex0, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 280, -1));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Back.png"))); // NOI18N
        Back.setBorderPainted(false);
        Back.setContentAreaFilled(false);
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        UserIndex4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game User.png"))); // NOI18N
        UserIndex4.setBorderPainted(false);
        UserIndex4.setContentAreaFilled(false);
        getContentPane().add(UserIndex4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 590, -1, -1));

        UserIndex3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game User.png"))); // NOI18N
        UserIndex3.setBorderPainted(false);
        UserIndex3.setContentAreaFilled(false);
        getContentPane().add(UserIndex3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, -1, -1));

        UserIndex2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game User.png"))); // NOI18N
        UserIndex2.setBorderPainted(false);
        UserIndex2.setContentAreaFilled(false);
        getContentPane().add(UserIndex2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 368, -1, -1));

        UserIndex1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game User.png"))); // NOI18N
        UserIndex1.setBorderPainted(false);
        UserIndex1.setContentAreaFilled(false);
        getContentPane().add(UserIndex1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, -1, -1));

        UserIndex0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game User.png"))); // NOI18N
        UserIndex0.setBorderPainted(false);
        UserIndex0.setContentAreaFilled(false);
        getContentPane().add(UserIndex0, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        LoadGameBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game Background.png"))); // NOI18N
        getContentPane().add(LoadGameBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Tap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Tap.png"))); // NOI18N
        getContentPane().add(Tap, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, -1, -1));

        Help1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help1.png"))); // NOI18N
        getContentPane().add(Help1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Help2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help2.png"))); // NOI18N
        getContentPane().add(Help2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Help3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help3.png"))); // NOI18N
        getContentPane().add(Help3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Help4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help4.png"))); // NOI18N
        getContentPane().add(Help4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Help5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help5.png"))); // NOI18N
        getContentPane().add(Help5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Help6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help6.png"))); // NOI18N
        getContentPane().add(Help6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Troop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Melee1.gif"))); // NOI18N
        getContentPane().add(Troop, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, -1, -1));

        Cartoon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cartoon.png"))); // NOI18N
        Cartoon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CartoonMouseEntered(evt);
            }
        });
        getContentPane().add(Cartoon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 920, -1));

        Loading.setBackground(new java.awt.Color(255, 255, 255));
        Loading.setForeground(new java.awt.Color(0, 255, 51));
        Loading.setBorderPainted(false);
        getContentPane().add(Loading, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, 510, 40));

        Background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Intro1.gif"))); // NOI18N
        getContentPane().add(Background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        XMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/X Mark.png"))); // NOI18N
        XMark.setBorderPainted(false);
        XMark.setContentAreaFilled(false);
        getContentPane().add(XMark, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, -1, -1));

        VolumeControl.setBackground(new java.awt.Color(0, 208, 196));
        VolumeControl.setMaximum(6);
        VolumeControl.setMinimum(-30);
        VolumeControl.setValue(-15);
        getContentPane().add(VolumeControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 430, -1));

        Volume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Volume.png"))); // NOI18N
        getContentPane().add(Volume, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, -1, -1));

        BlackBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Black.png"))); // NOI18N
        getContentPane().add(BlackBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        New.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/New Game.png"))); // NOI18N
        New.setBorderPainted(false);
        New.setContentAreaFilled(false);
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        getContentPane().add(New, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Title.png"))); // NOI18N
        Title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TitleMouseEntered(evt);
            }
        });
        getContentPane().add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        Setting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Setting.png"))); // NOI18N
        Setting.setBorderPainted(false);
        Setting.setContentAreaFilled(false);
        Setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingActionPerformed(evt);
            }
        });
        getContentPane().add(Setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        Help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Help.png"))); // NOI18N
        Help.setBorderPainted(false);
        Help.setContentAreaFilled(false);
        getContentPane().add(Help, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, -1, -1));

        Load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Load Game.png"))); // NOI18N
        Load.setBorderPainted(false);
        Load.setContentAreaFilled(false);
        getContentPane().add(Load, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, -1, -1));

        Warning.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Warning.png"))); // NOI18N
        getContentPane().add(Warning, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, -1, -1));

        IsiUser.setFont(new java.awt.Font("Lato Black", 1, 48)); // NOI18N
        IsiUser.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        IsiUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IsiUserActionPerformed(evt);
            }
        });
        getContentPane().add(IsiUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 410, -1));

        Username.setFont(new java.awt.Font("Lato Black", 1, 36)); // NOI18N
        Username.setText("Username");
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, -1, -1));

        Play.setFont(new java.awt.Font("Lato Black", 1, 48)); // NOI18N
        Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Play.png"))); // NOI18N
        Play.setBorderPainted(false);
        Play.setContentAreaFilled(false);
        Play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayActionPerformed(evt);
            }
        });
        getContentPane().add(Play, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Intro.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IsiUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IsiUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IsiUserActionPerformed

    private void PlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlayActionPerformed

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewActionPerformed

    private void CartoonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartoonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CartoonMouseEntered

    private void TitleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TitleMouseEntered

    private void SettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SettingActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Background1;
    private javax.swing.JLabel BlackBackground;
    private javax.swing.JLabel Cartoon;
    private javax.swing.JButton Help;
    private javax.swing.JLabel Help1;
    private javax.swing.JLabel Help2;
    private javax.swing.JLabel Help3;
    private javax.swing.JLabel Help4;
    private javax.swing.JLabel Help5;
    private javax.swing.JLabel Help6;
    private javax.swing.JTextField IsiUser;
    private javax.swing.JButton Load;
    private javax.swing.JLabel LoadGameBackground;
    private javax.swing.JProgressBar Loading;
    private javax.swing.JButton New;
    private javax.swing.JButton Play;
    private javax.swing.JButton Setting;
    private javax.swing.JLabel Tap;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel Troop;
    private javax.swing.JButton UserIndex0;
    private javax.swing.JButton UserIndex1;
    private javax.swing.JButton UserIndex2;
    private javax.swing.JButton UserIndex3;
    private javax.swing.JButton UserIndex4;
    private javax.swing.JLabel UserNameIndex0;
    private javax.swing.JLabel UserNameIndex1;
    private javax.swing.JLabel UserNameIndex2;
    private javax.swing.JLabel UserNameIndex3;
    private javax.swing.JLabel UserNameIndex4;
    private javax.swing.JLabel Username;
    private javax.swing.JLabel Volume;
    private javax.swing.JSlider VolumeControl;
    private javax.swing.JLabel Warning;
    private javax.swing.JButton XMark;
    // End of variables declaration//GEN-END:variables
}
