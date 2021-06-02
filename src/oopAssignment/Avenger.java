package oopAssignment;

import java.io.IOException;

public abstract class Avenger {
    // set variables for class
    private String heroName;
    private String secretIdentity;
    private Boolean alive;
    private enemy newEnemy;
    private int health;

    // constructor method
    public Avenger(String name, String superHero, enemy badGuy, int hlth){
        secretIdentity = name;
        heroName = superHero;
        newEnemy = badGuy;
        health = hlth;
        // all avengers will being alive
        alive = true;
    
    // getter and setter methods
    }
    public String getName(){
        return secretIdentity;
    }
    public String getHeroName(){
        return heroName;
    }
    public Boolean getAlive(){
        return alive;
    }
    public void setAlive(Boolean alv){
        alive = alv;
    }
    public int getEnemyAttack(){
        return newEnemy.getAttack();
    }
    public int getEnemyHealth(){
        return newEnemy.getHealth();
    }
    public void setEnemyHealth(int hp){
        newEnemy.setHealth(hp);
    }
    public String getEnemyName(){
        return newEnemy.getName();
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int hp){
        health = hp;
    }
    // abstract methods
    public abstract void fight() throws IOException;
    public abstract void Attacked();
}
