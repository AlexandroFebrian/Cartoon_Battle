/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartoon.battle;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Tank extends Troops implements Serializable {
    //HP, ATK
    public Tank() {
        super(150, 10);
    }
    
    public Tank(int HP, int Atk) {
        super(HP, Atk);
    }
}
