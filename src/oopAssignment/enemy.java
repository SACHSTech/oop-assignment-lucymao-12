package oopAssignment;

public class enemy {
    private int health;
    private String name;
    private int attackDamage;

    public enemy(int hlth, String nme, int damage){
        health = hlth;
        name = nme;
        attackDamage = damage;
    }
    public int getHealth(){
        return health;
    }
    public String getName(){
        return name;
    }
    public int getAttack(){
        return attackDamage;
    }

}
