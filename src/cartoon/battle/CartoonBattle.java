/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cartoon.battle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CartoonBattle {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList <User> u = new ArrayList<>();
    
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            FileInputStream fin = new FileInputStream("user.dat");
            ObjectInputStream ois = new ObjectInputStream(fin);
            ArrayList <User> read = (ArrayList <User>) ois.readObject();
            u = read;
        } catch (Exception e) {
            System.out.println(e);
        }
        Sound sound = new Sound(new File("src\\music\\Home.wav"));
        Login l = new Login(sound, u);
        
        //Set tampilan form di tengah
        l.setLocationRelativeTo(null);
        l.setResizable(false);
        l.setVisible(true);
        
        //Masuk Home
        l.getPlay().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                if (!l.getIsiUser().getText().equals("")) {
                    if (u.size() == 5) {
                        JOptionPane.showMessageDialog(l, "The oldest save would be deleted!", "Warning",  JOptionPane.WARNING_MESSAGE);
                        u.remove(0);
                    }
                    u.add(new User(l.getIsiUser().getText()));
                    l.setVisible(false);
                    Home h = new Home(u.get(u.size() - 1).getUsername(), String.valueOf(u.get(u.size() - 1).getGold()), sound);
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
                            Shop s = new Shop(u.get(u.size()-1));
                            s.setLocationRelativeTo(null);
                            s.setResizable(false);
                            h.setVisible(false);
                            s.setVisible(true);
                            s.getBack().addMouseListener(new MouseAdapter(){
                                public void mousePressed(MouseEvent me){
                                    s.dispose();
                                    h.setVisible(true);
                                    h.getGold().setText(String.valueOf(u.get(u.size()-1).getGold()));
                                }
                            });
                        }
                    });
                    
                    //Kingdom <Jessica>
                    h.getKingdom().addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            Kingdom k = new Kingdom(u.get(u.size()-1));
                            k.setLocationRelativeTo(null);
                            k.setResizable(false);
                            h.setVisible(false);
                            k.setVisible(true);
                            k.getBack().addMouseListener(new MouseAdapter(){
                                public void mousePressed(MouseEvent me){
                                    k.dispose();
                                    h.setVisible(true);
                                    h.getGold().setText(String.valueOf(u.get(u.size()-1).getGold()));
                                }
                            });
                        }
                    });
                    
                    //Battle <Febrian>
                    h.getBattle().addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            sound.changeMusic(new File("src\\music\\Battle.wav"));
                            Battle b = new Battle(u.get(u.size()-1), sound);
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
                                        int tempGold = u.get(u.size()-1).getGold()+50*u.get(u.size()-1).getLevelEnemy();
                                        u.get(u.size()-1).setGold(tempGold);
                                        u.get(u.size()-1).setLevelEnemy(u.get(u.size()-1).getLevelEnemy()+1);
                                        h.getGold().setText(String.valueOf(u.get(u.size()-1).getGold()));
                                    }
                                }
                            });
                        }
                    });
                } else {
                    l.warnMessage();
                }
            }
        });
    }
    
}
