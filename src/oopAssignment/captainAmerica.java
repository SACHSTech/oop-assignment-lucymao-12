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
        while(ready == true && newShield.getDamage() < 100 && choice.equalsIgnoreCase("yes")){
            newShield.thrown();
            System.out.println("Throw the shield? (Yes/No)");
            choice = kReader.readLine();
        }if(!ready){
            System.out.println(getHeroName() + " is not ready!");
        }
        if(newShield.getDamage() >= 100){
            System.out.println(this.getHeroName()+"'s broken!");
        }
    }
    public void Attacked(){

    }
}

