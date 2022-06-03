/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartoon.battle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class User implements Serializable {
    private String username;
    private int levelEnemy;
    private int gold;
    private int skill;
    private ArrayList <Troops> troop = new ArrayList<>();
    private Tower tower;

    public User(String username) {
        this.username = username;
        this.levelEnemy = 1;
        this.gold = 0;
        this.skill = 0;
        this.troop.add(new Melee());
        this.tower = new Tower();
    }    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(int level, int hp) {
        this.tower.setLevel(level);
        this.tower.setHp(hp);
    }
    
    public int getLevelEnemy() {
        return levelEnemy;
    }

    public void setLevelEnemy(int levelEnemy) {
        this.levelEnemy = levelEnemy;
    }

    public ArrayList<Troops> getTroop() {
        return troop;
    }
    
    //Hanya menerima parameter new Tank()/new Range()
    public void addTroop(Troops troop) {
        this.troop.add(troop);
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }
}
