package oopAssignment;
import oopAssignment.*;
import java.io.*;

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
        System.out.println("Fire Repulsors? (Yes/No)");
        String choice = kReader.readLine();
        nSuit.suitUp();
        this.fly = true;
        while(nSuit.getRepulsor() > 0 && choice.equalsIgnoreCase("yes")){
            nSuit.suitBlast();
            System.out.println("Fire Repulsors? (Yes/No)");
            choice = kReader.readLine();
            if(choice.equalsIgnoreCase("no")){
                System.out.println("Recharge suit? (Yes/No)");
                choice = kReader.readLine();
                if(choice.equalsIgnoreCase("yes")){
                    nSuit.Recharge();
                }
            }
        }
        //nSuit.setPower(nSuit.getRepulsor());
        if(nSuit.getRepulsor() <= 0){
            this.fly = false;
            System.out.println(this.getName() + " is down!");
        }
    }
    public void Attacked(){
        if(!this.fly){
            setHealth(getHealth() - 2*(getEnemyAttack()));
        }
        else
            setHealth(getHealth() - (getEnemyAttack()));
    }
}
