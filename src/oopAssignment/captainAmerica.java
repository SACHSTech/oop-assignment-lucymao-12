package oopAssignment;
import java.io.*;
import oopAssignment.*;

public class captainAmerica extends Avenger{
    private int yearsOutOfIce;
    private shield newShield;

    public captainAmerica(int ice, shield capShield, String secret){
        super(secret, "Captain America");
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
    public void fight(String choice) throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        Boolean ready = this.fightReady();
        while(ready == true && newShield.getDamage() < 100 && !choice.equalsIgnoreCase("Stop")){
            newShield.thrown();
            if(newShield.getDamage() >= 100){
                super.setAlive(false);
                System.out.println(this.getHeroName()+" is down!");
    
            }if(super.getAlive()){
                System.out.println("What should he do next?");
                choice = kReader.readLine();
            }   
        }
    }
}

