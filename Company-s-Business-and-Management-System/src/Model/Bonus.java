/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Bonus {
    private int Bonus_ID;
    private String Bonus_Level;
    private int Bonus_Money;
    private String Bonus_Date;

    public int getBonus_ID() {
        return Bonus_ID;
    }

    public void setBonus_ID(int Bonus_ID) {
        this.Bonus_ID = Bonus_ID;
    }

    public String getBonus_Level() {
        return Bonus_Level;
    }

    public void setBonus_Level(String Bonus_Level) {
        this.Bonus_Level = Bonus_Level;
    }

    public int getBonus_Money() {
        return Bonus_Money;
    }

    public void setBonus_Money(int Bonus_Money) {
        this.Bonus_Money = Bonus_Money;
    }

    public String getBonus_Date() {
        return Bonus_Date;
    }

    public void setBonus_Date(String Bonus_Date) {
        this.Bonus_Date = Bonus_Date;
    }

    public Bonus(int Bonus_ID, String Bonus_Level, int Bonus_Money, String Bonus_Date) {
        this.Bonus_ID = Bonus_ID;
        this.Bonus_Level = Bonus_Level;
        this.Bonus_Money = Bonus_Money;
        this.Bonus_Date = Bonus_Date;
    }

    public Bonus() {
    }

    @Override
    public String toString() {
        return Bonus_Level ;
    }

    public Bonus(String Bonus_Level, int Bonus_Money, String Bonus_Date) {
        this.Bonus_Level = Bonus_Level;
        this.Bonus_Money = Bonus_Money;
        this.Bonus_Date = Bonus_Date;
    }
    
    
}
