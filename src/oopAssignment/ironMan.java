package oopAssignment;
import oopAssignment.*;
import java.io.*;
import java.util.Random;

public class ironMan extends Avenger{
    private Boolean fly;
    private suit nSuit;

    public ironMan(suit newSuit, String name, enemy newEnemy){
        super(name, "Iron Man", newEnemy, 80);
        this.nSuit = newSuit;
        fly = false;
    }
    public Boolean getFly(){
        return fly;
    }
    public void fight() throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String Rchoice = "";
        nSuit.suitUp();
        System.out.println("Iron Man's Health: " + getHealth());
        System.out.println("Fire Repulsors? (Yes/No/Stop)");
        String choice = kReader.readLine();
        this.fly = true;
        // nSuit.getRepulsor() > 0 && 
        while(!choice.equalsIgnoreCase("stop") && getAlive() && getEnemyHealth() > 0){
            if(choice.equalsIgnoreCase("yes")){
                setEnemyHealth(getEnemyHealth() - (nSuit.getRepulsor())/4);
                nSuit.suitBlast();
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                if(getEnemyHealth() <= 0){
                    System.out.println(getEnemyName() + " is defeated.");
                }
                Attacked();
            }
            if(nSuit.getRepulsor() <= 20 && getAlive() && getEnemyHealth() > 0){
                this.fly = false;
                System.out.println(this.getName() + " cannot fly! (Less than 20% repulsor power)");
            }
            if(nSuit.getRepulsor() > 0 && getAlive() && choice.equalsIgnoreCase("yes") && getEnemyHealth() > 0){
                System.out.println("Fire Repulsors? (Yes/No/Stop)");
                choice = kReader.readLine();
            }
            if(getAlive()){
                if(choice.equalsIgnoreCase("no") && !choice.equalsIgnoreCase("stop") && getEnemyHealth() > 0|| nSuit.getRepulsor() <= 0){
                    System.out.println("Recharge suit? (Yes/No)");
                    Rchoice = kReader.readLine();
                    if(Rchoice.equalsIgnoreCase("yes")){
                        nSuit.Recharge();
                        if(nSuit.getRepulsor() > 20){
                            this.fly = true;
                            System.out.println("Mark " + nSuit.getMarkNum() + " is airborn. (Take less damage)");
                        }
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
                        if(getAlive() && getEnemyHealth() > 0){
                            System.out.println("Fire Repulsors? (Yes/No/Stop)");
                            choice = kReader.readLine();
                        }
                    }
                }
            } 
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
    public void Attacked(){
        if(!this.fly && getEnemyHealth() >= 0){
            setHealth(getHealth() - 2*(getEnemyAttack()));
            System.out.println("Enemy attacks. Iron Man is grounded! (" + 2*getEnemyAttack() + " damage)");
            System.out.println("Iron Man's Health: " + getHealth());
            if(getHealth() <= 0){
                setAlive(false);
                System.out.println("Iron man is down!");
            }
        }
        else if(fly && getEnemyHealth() >= 0){
            setHealth(getHealth() - (getEnemyAttack()));
            System.out.println("Enemy attacks (" + getEnemyAttack() + " damage)");
            System.out.println("Iron Man's Health: " + getHealth());
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
    public void printShellHead(){
        System.out.println(getHeroName() + ": " + getName());
        System.out.println("Suit: a " + nSuit.getColour() + " mark " + nSuit.getMarkNum());
    }
}
