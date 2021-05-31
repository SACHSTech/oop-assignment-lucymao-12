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

        System.out.println("Fire Repulsors? (Yes/No)");
        String choice = kReader.readLine();
        this.fly = true;
        while(nSuit.getRepulsor() > 0 && choice.equalsIgnoreCase("yes")){
            nSuit.suitBlast();
            setEnemyHealth(getEnemyHealth() - 10);
            System.out.println("Enemy Health: " + getEnemyHealth());
            if(nSuit.getRepulsor() > 0){
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
                        System.out.println("Enemy attacked while repulsors recharged! (5 damage)");
                        Attacked();
                    }
                }
            }
            if(choice.equalsIgnoreCase("no") && Rchoice.equalsIgnoreCase("yes") && nSuit.getRepulsor() > 0){
                System.out.println("Fire Repulsors? (Yes/No)");
                choice = kReader.readLine();
            }
            if(getAlive() && getEnemyHealth() > 0 && nSuit.getRepulsor() > 0){
                System.out.println("Enemy attacks (10 damamge)");
                Attacked();
            }
            
        }
        //nSuit.setPower(nSuit.getRepulsor());
        if(nSuit.getRepulsor() <= 0){
            this.fly = false;
            System.out.println(this.getName() + " cannot fly!");
            Attacked();

        }
    }
    public void Attacked(){
        if(!this.fly){
            setAlive(false);
            System.out.println(this.getName() + " is down!");
        }
        else if(fly){
            setHealth(getHealth() - (getEnemyAttack()));
            System.out.println("Health: " + getHealth());
        }
            
    }
    public void printShellHead(){

    }
}
