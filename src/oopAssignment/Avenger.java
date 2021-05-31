package oopAssignment;

import java.io.IOException;

public abstract class Avenger {
    private String heroName;
    private String secretIdentity;
    private Boolean alive;
    private enemy newEnemy;
    private int health;

    public Avenger(String name, String superHero, enemy badGuy, int hlth){
        secretIdentity = name;
        heroName = superHero;
        newEnemy = badGuy;
        health = hlth;
        alive = true;
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
    public int getHealth(){
        return health;
    }
    public void setHealth(int hp){
        health = hp;
    }
    public abstract void fight() throws IOException;
    public abstract void Attacked();
}
