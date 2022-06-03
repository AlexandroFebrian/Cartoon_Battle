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
public class Melee extends Troops implements Serializable {
    //HP, ATK
    public Melee() {
        super(25, 4);
    }
    
    public Melee(int HP, int Atk) {
        super(HP, Atk);
    }
}
