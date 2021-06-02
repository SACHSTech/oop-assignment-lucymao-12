package oopAssignment;
import java.io.*;
import oopAssignment.*;

// captain america class is an avenger
public class captainAmerica extends Avenger{
    // class's own variables
    private int yearsOutOfIce;
    private shield newShield;

    // constructor method
    public captainAmerica(int ice, shield capShield, String secret, enemy newEnemy){
        super(secret, "Captain America", newEnemy, 100);
        this.yearsOutOfIce = ice;
        this.newShield = capShield;
    
    // getter and setter methods
    }
    public int getIce(){
        return yearsOutOfIce;

    // method to determine whether captain america is able to fight, mostly based on whether he is in or out of the ice
    }
    public Boolean fightReady(){
        if(yearsOutOfIce > 0 && getAlive()){
            //System.out.println("Captain America is ready to fight!" + "\n");
            return true;
        }
        else
        //System.out.println("He's still asleep!");
        return false;
    /** 
     * method that simulates a fight with an enemy object
     * based on the shield object
     * asks useer whether cap throws the shield
     */
    }
    public void fight() throws IOException{
        /**
         * variables specific for this method
         * ready: holds value for method fightReady
         * coice: holds player input value
         * hit: holds the boolean value for whether the shield hits or misses
         */
        Boolean ready = this.fightReady();
        String choice  = "";
        Boolean hit = false;
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        if(ready){
            /**
             * user input to throw shield
             * stop to stop program
             */
            System.out.println("Captain America's health: " + getHealth());
            System.out.println("Throw the shield? (Yes/No/Stop)");
            choice = kReader.readLine();
            hit = false;
        }
        
        /**
         * while loop runs while shield is not broken, cap and the enemy are alive, program has not been stopped, and cap is out of ice
         */
        while(ready && newShield.getHealth() > 0 && !choice.equalsIgnoreCase("stop") && getEnemyHealth() > 0 && getAlive()){
            if(choice.equalsIgnoreCase("yes")){
                // runs the shield.thrown method to calculate whether shield hits or misses
                hit = newShield.thrown();
            }

            // checks if shield has broken
            if(newShield.getHealth() <= 0){
                System.out.println(this.getHeroName()+"'s shield's broken!");
                Attacked();
            }

            // checks if shield has hit, does 10 damage if it does
            if(choice.equalsIgnoreCase("yes") && hit){
                setEnemyHealth(getEnemyHealth()-10);
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                // enemy attacks after each action
                Attacked();
            
            // check if user inputted no, will switch to a punch, 100% hit rate
            }else if(choice.equalsIgnoreCase("no")){
                System.out.println("Captain America attacks with his fist! (5 damage)");
                setEnemyHealth(getEnemyHealth()-5);
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                Attacked();

            // check if shield misses, enemy attacks
            }else if(choice.equalsIgnoreCase("yes") && !hit && getEnemyHealth() > 0){
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                Attacked();
            
            // re-ask for input to have code loop, make sure all things are still alive/not broken
            }
            if(getEnemyHealth() > 0 && newShield.getHealth() > 0 && getAlive()){
                System.out.println("Throw the shield? (Yes/No/Stop)");
                choice = kReader.readLine();
            
            // check if enemy has been defeated
            }if(getEnemyHealth() <= 0 && newShield.getHealth() > 0){
                System.out.println("Captain America wins!");
            }
        
        // outside of loop, check if cap is still in ice
        }if(!ready){
            System.out.println("But, " + getHeroName() + " is not ready!");
        }
    }
    // method for the enemy attack
    public void Attacked(){

        /** check if shield is broken when enemy attacks
         * if it has cap gets a powerful attack (20 damage)
         * but if the attack doesn't win cap instantly loses
         */
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
        
        /**
         * if shield is still unbroken, cap is alive and enemy is alive, take damage equal to enemy attack value
         */
        }
        else if(getEnemyHealth() > 0 && getAlive()){
            System.out.println("Enemy attack! (" + getEnemyAttack() + " damage)");
            setHealth(this.getHealth()-getEnemyAttack());
            System.out.println("Captain America's Health: "+this.getHealth());
        
        /**
         * if cap is defeated while shield is still unbroken
         */
        }if(getHealth() <= 0 && newShield.getHealth() > 0 && getAlive()){
            setAlive(false);
            System.out.println("Captain America has fallen.");
        }
    }
    // method to print out the description of cap back to player
    public void printCap(){
        System.out.println(getHeroName() + ": " + getName());
        System.out.println("Shield: " + newShield.getMaterial());
        System.out.println("Years out of ice: " + getIce());
    }
}

