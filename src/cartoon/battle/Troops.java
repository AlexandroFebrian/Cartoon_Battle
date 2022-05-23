/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartoon.battle;

/**
 *
 * @author User
 */
public abstract class Troops {
    protected static int BaseHP, BaseAtk;
    protected int HP, Atk;

    public Troops(int BaseHP, int BaseAtk) {
        this.BaseHP = BaseHP;
        this.BaseAtk = BaseAtk;
    }

    public Troops() {
        HP = BaseHP;
        Atk = BaseAtk;
    }
    
    

    public static int getBaseHP() {
        return BaseHP;
    }

    public static void setBaseHP(int BaseHP) {
        Troops.BaseHP = BaseHP;
    }

    public static int getBaseAtk() {
        return BaseAtk;
    }

    public static void setBaseAtk(int BaseAtk) {
        Troops.BaseAtk = BaseAtk;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtk() {
        return Atk;
    }

    public void setAtk(int Atk) {
        this.Atk = Atk;
    }

    
    
    
}
