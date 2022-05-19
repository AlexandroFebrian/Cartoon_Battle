/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cartoon.battle;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class User {
    private String username;
    private int levelEnemy;
    private int gold;
    private ArrayList <Troops> troop = new ArrayList<>();

    public User(String username) {
        this.username = username;
        this.levelEnemy = 1;
        this.gold = 0;
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

    public int getLevelEnemy() {
        return levelEnemy;
    }

    public void setLevelEnemy(int levelEnemy) {
        this.levelEnemy = levelEnemy;
    }

    public ArrayList<Troops> getTroop() {
        return troop;
    }

    public void setTroop(ArrayList<Troops> troop) {
        this.troop = troop;
    }
}
