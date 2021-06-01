package oopAssignment;
import java.io.*;
import oopAssignment.*;

public class captainAmerica extends Avenger{
    private int yearsOutOfIce;
    private shield newShield;

    public captainAmerica(int ice, shield capShield, String secret, enemy newEnemy){
        super(secret, "Captain America", newEnemy, 100);
        this.yearsOutOfIce = ice;
        this.newShield = capShield;
    }
    public int getIce(){
        return yearsOutOfIce;
    }
    public Boolean fightReady(){
        if(yearsOutOfIce > 0 && getAlive()){
            //System.out.println("Captain America is ready to fight!" + "\n");
            return true;
        }
        else
        //System.out.println("He's still asleep!");
        return false;
    }
    public void fight() throws IOException{
        Boolean ready = this.fightReady();
        System.out.println("Captain America's health: " + getHealth());
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Throw the shield? (Yes/No/Stop)");
        String choice = kReader.readLine();
        Boolean hit = false;
        
        while(ready && newShield.getHealth() > 0 && !choice.equalsIgnoreCase("stop") && getEnemyHealth() > 0 && getAlive()){
            if(choice.equalsIgnoreCase("yes")){
                hit = newShield.thrown();
            }
            if(newShield.getHealth() <= 0){
                System.out.println(this.getHeroName()+"'s shield's broken!");
                Attacked();
            }
            if(choice.equalsIgnoreCase("yes") && hit){
                setEnemyHealth(getEnemyHealth()-10);
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());

                Attacked();
            }else if(choice.equalsIgnoreCase("no")){
                System.out.println("Captain America attacks with his fist! (5 damage)");
                setEnemyHealth(getEnemyHealth()-5);
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                Attacked();
            }else if(choice.equalsIgnoreCase("yes") && !hit && getEnemyHealth() > 0){
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                Attacked();
            }
            if(getEnemyHealth() > 0 && newShield.getHealth() > 0 && getAlive()){
                System.out.println("Throw the shield? (Yes/No/Stop)");
                choice = kReader.readLine();
            }if(getEnemyHealth() <= 0 && newShield.getHealth() > 0){
                System.out.println("Captain America wins!");
            }
        }if(!ready){
            System.out.println(getHeroName() + " is not ready!");
        }
        
        
    }
    public void Attacked(){
        if(newShield.getHealth() <= 0 && getEnemyHealth() > 0 && getAlive()){
            System.out.println("Last stand! (Do 20 damage to enemy when shield breaks)");
            setEnemyHealth(getEnemyHealth()-2*(getEnemyAttack()));
            System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
            if(getEnemyHealth() <= 0){
                System.out.println("Enemy down!");
            }
            if(getEnemyHealth() > 0){
                System.out.println(getEnemyName() + " is attacking, Captain America is defenseless.");
                setAlive(false);
                System.out.println("Without a shield, Captain America has fallen.");
                setHealth(0);
            }
        }
        else if(getEnemyHealth() > 0 && getAlive()){
            System.out.println("Enemy attack! (" + getEnemyAttack() + " damage)");
            setHealth(this.getHealth()-getEnemyAttack());
            System.out.println("Captain America's Health: "+this.getHealth());
        }if(getHealth() <= 0 && newShield.getHealth() > 0 && getAlive()){
            setAlive(false);
            System.out.println("Captain America has fallen.");
        }
    }
    public void printCap(){
        System.out.println(getHeroName() + ": " + getName());
        System.out.println("Shield: " + newShield.getMaterial());
        System.out.println("Years out of ice: " + getIce());
    }
}

