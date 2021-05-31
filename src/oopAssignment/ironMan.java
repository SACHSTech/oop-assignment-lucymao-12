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
        System.out.println("Starting Health: " + getHealth());
        System.out.println("Fire Repulsors? (Yes/No/Stop)");
        String choice = kReader.readLine();
        this.fly = true;
        
        while(nSuit.getRepulsor() > 0 && !choice.equalsIgnoreCase("stop") && getAlive()){
            if(choice.equalsIgnoreCase("yes")){
                nSuit.suitBlast();
                setEnemyHealth(getEnemyHealth() - (nSuit.getRepulsor() + 10)/5);
                System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                Attacked();
            }
            if(nSuit.getRepulsor() > 0 && getAlive() && choice.equalsIgnoreCase("yes")){
                System.out.println("Fire Repulsors? (Yes/No)");
                choice = kReader.readLine();
            }
            
            if(choice.equalsIgnoreCase("no")){
                System.out.println("Recharge suit? (Yes/No)");
                Rchoice = kReader.readLine();
                if(Rchoice.equalsIgnoreCase("yes")){
                    nSuit.Recharge();
                    Random random = new Random();
                    int randInt = random.nextInt(2);
                    if(randInt == 0){
                        System.out.println("Enemy attacked while repulsors recharged!");
                        System.out.println(getEnemyName()+ "'s Health: " + getEnemyHealth());
                        Attacked();
                        if(getAlive()){
                            System.out.println("Fire Repulsors? (Yes/No/Stop)");
                            choice = kReader.readLine();
                        }
                    }
                    if(getAlive()){
                        System.out.println("Fire Repulsors? (Yes/No/Stop)");
                        choice = kReader.readLine();
                    }
                }
            }
            if(choice.equalsIgnoreCase("no") && Rchoice.equalsIgnoreCase("no") && nSuit.getRepulsor() > 0 && getAlive()){
                System.out.println("Iron Man doesn't maove, he gets hit.");
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
            if(nSuit.getRepulsor() <= 20 && getAlive()){
                this.fly = false;
                System.out.println(this.getName() + " cannot fly!");
            }
            
        }
        //nSuit.setPower(nSuit.getRepulsor());
        
    }
    public void Attacked(){
        if(!this.fly){
            setHealth(getHealth() - (getEnemyAttack()));
            System.out.println("Enemy attacks. Iron Man is grounded!");
            System.out.println("Health: " + getHealth());
            if(getHealth() <= 0){
                setAlive(false);
                System.out.println("Iron man is down!");
            }
        }
        else if(fly){
            setHealth(getHealth() - (getEnemyAttack()));
            System.out.println("Enemy attacks (" + getEnemyAttack() + " damage)");
            System.out.println("Health: " + getHealth());
            if(getHealth() <= 0){
                setAlive(false);
                System.out.println("Iron man is down!");
            }
        }
            
    }
    public void printShellHead(){
        System.out.println(getHeroName() + ": " + getName());
        System.out.println("Suit: a " + nSuit.getColour() + " mark " + nSuit.getMarkNum());
    }
}
