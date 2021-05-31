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
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Throw the shield? (Yes/No)");
        String choice = kReader.readLine();
        while(ready && newShield.getHealth() > 0 && choice.equalsIgnoreCase("yes") && getEnemyHealth() > 0 && getAlive()){
            if(newShield.thrown()){
                setEnemyHealth(getEnemyHealth()-10);
                System.out.println("Enemy Health: " + getEnemyHealth());
                Attacked();
            }else
                Attacked();
            if(getEnemyHealth() > 0 && newShield.getHealth() > 0 && getAlive()){
                System.out.println("Throw the shield? (Yes/No)");
                choice = kReader.readLine();
            }
        }if(!ready){
            System.out.println(getHeroName() + " is not ready!");
        }
        /**if(newShield.getHealth() <= 0){
            System.out.println(this.getHeroName()+"'s shield's broken!");
            Attacked();
        }
        */
        if(getEnemyHealth() <= 0){
            System.out.println("Enemy down!");
        }
    }
    public void Attacked(){
        if(newShield.getHealth() <= 0 && getEnemyHealth() > 0 && getAlive()){
            System.out.println("Last stand! (Do 20 damage to enemy when shield breaks)");
            setEnemyHealth(getEnemyHealth()-2*(getEnemyAttack()));
            System.out.println("Enemy Health: " + getEnemyHealth());
            System.out.println("Enemy attack! (" + 2*getEnemyAttack() + " damage)");
            if(getEnemyHealth() > 0){
                setAlive(false);
                System.out.println("Captain America has fallen.");
                setHealth(0);
            }
            setHealth(getHealth()-20);
            System.out.println("Health: "+this.getHealth());

        }else if(getEnemyHealth() > 0 && getAlive()){
            System.out.println("Enemy attack! (" + getEnemyAttack() + " damage)");
            setHealth(this.getHealth()-getEnemyAttack());
            System.out.println("Health: "+this.getHealth());
        }if(getHealth() <= 0 && newShield.getHealth() > 0 && getAlive()){
            setAlive(false);
            System.out.println("Captain America has fallen.");
        }
    }
    public void printCap(){
        
    }
}

