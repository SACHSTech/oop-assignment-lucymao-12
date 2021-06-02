package oopAssignment;
import oopAssignment.*;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;

// iron man is an avenger
public class ironMan extends Avenger{
    
    // variables for the class
    private Boolean fly;
    private ArrayList<suit> suits;

    // constructor method
    public ironMan(String name, enemy newEnemy){
        super(name, "Iron Man", newEnemy, 80);
        fly = true;
        suits = new ArrayList<suit>();
    
    // getter and setter methods
    }
    public Boolean getFly(){
        return fly;
    }
    public void addSuit(suit newSuit){
        suits.add(newSuit);
    }
    public void printSuitList(){
        for(int i = 0; i < suits.size(); i++){
            System.out.println(i + ": " + suits.get(i).printSuit());
        }
    }

     /**
     * fight method, based on repulsor power
     */
    public void fight() throws IOException{
        /**
         * ask user input to fire repulsor
         * Rchoice variable initialized for recharge method later
         * choice variable for asking if player will use repulsor
         */
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String Rchoice = "";
        // prints out suit details at beginning
        System.out.println("Pick a suit");
        printSuitList();
        int suitNum = Integer.parseInt(kReader.readLine());
        suits.get(suitNum).suitUp();
        // print out health at begninning
        System.out.println("Iron Man's Health: " + getHealth());
        System.out.println("Fire Repulsors? (Yes/No/Stop)");
        String choice = kReader.readLine();
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
                setEnemyHealth(getEnemyHealth() - (suits.get(suitNum).getRepulsor())/4);
                suits.get(suitNum).suitBlast();
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
                if(suits.get(suitNum).getRepulsor() <= 20 && getAlive() && getEnemyHealth() > 0){
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
            if(suits.get(suitNum).getRepulsor() > 0 && getAlive() && choice.equalsIgnoreCase("yes") && getEnemyHealth() > 0){
                System.out.println("Fire Repulsors? (Yes/No/Stop)");
                choice = kReader.readLine();
            }

            /**
             * if user chooses no
             */
            if(getAlive()){
                if(choice.equalsIgnoreCase("no") && !choice.equalsIgnoreCase("stop") && getEnemyHealth() > 0|| suits.get(suitNum).getRepulsor() <= 0){
                    
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
                        suits.get(suitNum).Recharge();
                        
                        /**
                         * check suit charge percentage
                         * if over 20 renable flight
                         */
                        if(suits.get(suitNum).getRepulsor() > 20){
                            this.fly = true;
                            System.out.println("Mark " + suits.get(suitNum).getMarkNum() + " is airborn. (Take less damage)");
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
            if(choice.equalsIgnoreCase("no") && Rchoice.equalsIgnoreCase("no") && suits.get(suitNum).getRepulsor() > 0 && getAlive()){
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
        if(!getFly() && getEnemyHealth() >= 0){
            setHealth(getHealth() - 2*(getEnemyAttack()));
            System.out.println("Enemy attacks. Iron Man is grounded! (" + 2*getEnemyAttack() + " damage)");
            System.out.println("Iron Man's Health: " + getHealth());
            // check if iron man is dead
            if(getHealth() <= 0){
                setAlive(false);
                System.out.println("Iron man is down!");
            }
        }
        else if(getFly() && getEnemyHealth() >= 0){
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
    public void printShellHead(int suitNum){
        System.out.println(getHeroName() + ": " + getName());
        System.out.println("Suit: A " + suits.get(suitNum).getColour() + " mark " + suits.get(suitNum).getMarkNum());
    }
}
