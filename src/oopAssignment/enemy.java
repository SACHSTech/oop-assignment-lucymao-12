package oopAssignment;

// enemy class seperate from avenger parent class
public class enemy {
    // variables for this class
    private int health;
    private String name;
    private int attackDamage;

    // constructor method
    public enemy(int hlth, String nme, int damage){
        health = hlth;
        name = nme;
        attackDamage = damage;
    
    // getter/setter methods
    }
    public int getHealth(){
        return health;
    }
    // take in hp to set new health for enemy
    public void setHealth(int hp){
        health = hp;
    }
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attackDamage;
    }

}
