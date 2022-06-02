/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cartoon.battle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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
    public static void main(String[] args) {
        // TODO code application logic here
        Sound sound = new Sound(new File("src\\music\\Good Night, Liyue.wav"));
        Login l = new Login(sound);
        ArrayList <User> u = new ArrayList<>();
        
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
                            Shop s = new Shop(/*Parameter*/);
                            s.setLocationRelativeTo(null);
                            s.setResizable(false);
                            h.setVisible(false);
                            s.setVisible(true);
                            s.getBack().addMouseListener(new MouseAdapter(){
                                public void mousePressed(MouseEvent me){
                                    s.dispose();
                                    h.setVisible(true);
                                }
                            });
                        }
                    });
                    
                    //Kingdom <Jessica>
                    h.getKingdom().addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
//                            Kingdom k = new Kingdom(/*Parameter*/);
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
                            Battle b = new Battle(u.get(u.size()-1));
                            b.setLocationRelativeTo(null);
                            b.setResizable(false);
                            h.setVisible(false);
                            b.setVisible(true);
                            b.getBack().addMouseListener(new MouseAdapter(){
                                public void mousePressed(MouseEvent me){
                                    b.dispose();
                                    b.StopAllTimer();
                                    h.setVisible(true);
                                    if(b.getFinal().getText().equalsIgnoreCase("You Win")){
                                        u.get(u.size()-1).setGold(u.get(u.size()-1).getGold()+50*u.get(u.size()-1).getLevelEnemy());
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
