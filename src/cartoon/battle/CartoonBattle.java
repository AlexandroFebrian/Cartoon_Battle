/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cartoon.battle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer.Form;
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
        Login l = new Login();
        Home h = new Home();
        ArrayList <User> u = new ArrayList<>();
        
        l.setLocationRelativeTo(null);
        l.setResizable(false);
        l.setVisible(true);
        l.getT().start();
        l.getPlay().addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                if (!l.getIsiUser().getText().equals("") && u.size() < 5) {
                    u.add(new User(l.getIsiUser().getText()));
                    l.setVisible(false);
                    Home h = new Home(u.get(u.size() - 1).getUsername(), String.valueOf(u.get(u.size() - 1).getGold()));
                    h.setLocationRelativeTo(null);
                    h.setResizable(false);
                    h.setVisible(true);
                    h.getLogout().addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            l.setVisible(true);
                            l.menuUtama();
                        }
                    });
                } else if (!l.getIsiUser().getText().equals("") && u.size() == 5) {
                    JOptionPane.showMessageDialog(l, "The oldest save would be deleted!", "Warning",  JOptionPane.WARNING_MESSAGE);
                    u.remove(0);
                    u.add(new User(l.getIsiUser().getText()));
                    l.setVisible(false);
                    Home h = new Home(u.get(4).getUsername(), String.valueOf(u.get(4).getGold()));
                    h.setLocationRelativeTo(null);
                    h.setResizable(false);
                    h.setVisible(true);
                    h.getLogout().addMouseListener(new MouseAdapter(){
                        public void mousePressed(MouseEvent me){
                            l.setVisible(true);
                            l.menuUtama();
                        }
                    });
                } else {
                    l.warnMessage();
                }
            }
        });
    }
    
}
