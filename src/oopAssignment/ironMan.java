package oopAssignment;
import oopAssignment.*;
import java.io.*;
import java.util.Random;

// iron man is an avenger
public class ironMan extends Avenger{
    
    // variables for the class
    private Boolean fly;
    private suit nSuit;

    // constructor method
    public ironMan(suit newSuit, String name, enemy newEnemy){
        super(name, "Iron Man", newEnemy, 80);
        this.nSuit = newSuit;
        fly = false;
    
    // getter and setter methods
    }
    public Boolean getFly(){
        return fly;

    /**
     * fight method, based on repulsor power
     */
    }
    public void fight() throws IOException{
        /**
         * ask user input to fire repulsor
         * Rchoice variable initialized for recharge method later
         * choice variable for asking if player will use repulsor
         */
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String Rchoice = "";
        // prints out suit details at beginning
        nSuit.suitUp();
        // print out health at begninning
        System.out.println("Iron Man's Health: " + getHealth());
        System.out.println("Fire Repulsors? (Yes/No/Stop)");
        String choice = kReader.readLine();
        this.fly = true;
        // nSuit.getRepulsor() > 0 && 

        /**
         * run code while user has not requested to stop, ironMan is alive, and enemy is alive
         */
        while(!choice.equalsIgnoreCase("stop") && getAlive() && getEnemyHealth() > 0){
            /**
             * if user chooses to shoot repulsor
             * do the damage = repulsor power/4
             * print out health of enemy
             */
            if(choice.equalsIgnoreCase("yes")){
                setEnemyHealth(getEnemyHealth() - (nSuit.getRepulsor())/4);
                nSuit.suitBlast();
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                
                /**
                 * check if enemy has been defeated
                 */
                if(getEnemyHealth() <= 0){
                    System.out.println(getEnemyName() + " is defeated.");
                }

                /**
                 * check suit power
                 * if 20 or less, set fly to false
                 */
                if(nSuit.getRepulsor() <= 20 && getAlive() && getEnemyHealth() > 0){
                    this.fly = false;
                    System.out.println(this.getName() + " cannot fly! (Less than 20% repulsor power)");
                }

                /**
                 * after each action enemy attacks
                 */
                Attacked();
            }
            /**
             * ask again to fire repulsor to restart loop
             */
            if(nSuit.getRepulsor() > 0 && getAlive() && choice.equalsIgnoreCase("yes") && getEnemyHealth() > 0){
                System.out.println("Fire Repulsors? (Yes/No/Stop)");
                choice = kReader.readLine();
            }

            /**
             * if user chooses no
             */
            if(getAlive()){
                if(choice.equalsIgnoreCase("no") && !choice.equalsIgnoreCase("stop") && getEnemyHealth() > 0|| nSuit.getRepulsor() <= 0){
                    
                    /**
                     * ask to recharge suit
                     */
                    System.out.println("Recharge suit? (Yes/No)");
                    Rchoice = kReader.readLine();
                    
                    /**
                     * if user chooses yes
                     * run recharge method from suit class
                     */
                    if(Rchoice.equalsIgnoreCase("yes")){
                        nSuit.Recharge();
                        
                        /**
                         * check suit charge percentage
                         * if over 20 renable flight
                         */
                        if(nSuit.getRepulsor() > 20){
                            this.fly = true;
                            System.out.println("Mark " + nSuit.getMarkNum() + " is airborn. (Take less damage)");
                        }

                        /**
                         * during recharge there is a 50% chance of being attacked by enemy
                         */
                        Random random = new Random();
                        int randInt = random.nextInt(2);
                        if(randInt == 0){
                            System.out.println("Enemy attacked while repulsors recharged!");
                            Attacked();
                            System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                            /**if(getAlive()){
                                System.out.println("Fire Repulsors? (Yes/No/Stop)");
                                choice = kReader.readLine();
                            }
                            */
                        }

                        /**
                         * ask user again for input
                         */
                        if(getAlive() && getEnemyHealth() > 0){
                            System.out.println("Fire Repulsors? (Yes/No/Stop)");
                            choice = kReader.readLine();
                        }
                    }
                }
            } 

            /**
             * if user choice for recharge is no, ironMan gets attacked
             * asks user again for repulsor fire input
             */
            if(choice.equalsIgnoreCase("no") && Rchoice.equalsIgnoreCase("no") && nSuit.getRepulsor() > 0 && getAlive()){
                System.out.println("Iron Man doesn't move, he gets hit.");
                Attacked(); 
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                if(getAlive()){
                    System.out.println("Fire Repulsors? (Yes/No/Stop)");
                    choice = kReader.readLine();
                }
                
            }
            /**if(getAlive() && getEnemyHealth() > 0 && nSuit.getRepulsor() > 0 && getAlive()){
                System.out.println("Enemy attacks");
                Attacked();
            }
            */
        }
        //nSuit.setPower(nSuit.getRepulsor());
        
    }
    /**
     * attack method
     * will deal damage (subtracting from health) to iron Man
     * with suit it is base damage from inputted enemy attack value
     * without it is 2* damage
     */
    public void Attacked(){
        if(!this.fly && getEnemyHealth() >= 0){
            setHealth(getHealth() - 2*(getEnemyAttack()));
            System.out.println("Enemy attacks. Iron Man is grounded! (" + 2*getEnemyAttack() + " damage)");
            System.out.println("Iron Man's Health: " + getHealth());
            // check if iron man is dead
            if(getHealth() <= 0){
                setAlive(false);
                System.out.println("Iron man is down!");
            }
        }
        else if(fly && getEnemyHealth() >= 0){
            setHealth(getHealth() - (getEnemyAttack()));
            System.out.println("Enemy attacks (" + getEnemyAttack() + " damage)");
            System.out.println("Iron Man's Health: " + getHealth());
            // check if iron  man is dead
            if(getHealth() <= 0){
                setAlive(false);
                System.out.println("Iron man is down!");
            }
        }
        /** else if(nSuit.getRepulsor() <= 0 && getEnemyHealth() >= 0){
            System.out.println("No more energy, Iron Man is defeated.");
            setAlive(false);
        }
        */
    }
    /**
     * print statement to repeat the variables given to the program
     */
    public void printShellHead(){
        System.out.println(getHeroName() + ": " + getName());
        System.out.println("Suit: A " + nSuit.getColour() + " mark " + nSuit.getMarkNum());
    }
}
