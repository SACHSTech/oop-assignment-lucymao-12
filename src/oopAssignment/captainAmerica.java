package oopAssignment;
import oopAssignment.*;

public class captainAmerica extends Avenger{
    private int yearsOutOfIce;
    private shield newShield;
    private Boolean assemble;

    public captainAmerica(int ice, shield capShield, String secret, String hero){
        super(secret, hero);
        this.yearsOutOfIce = ice;
        this.newShield = capShield;
        this.assemble = false;
    }
    public int getIce(){
        return yearsOutOfIce;
    }
    public String avengersAssemble(){
        assemble = true;
        return "Avengers Assemble!";
    }
    public void fightReady(){
        if(assemble && yearsOutOfIce > 0){
            System.out.println("Captain America is ready to fight with the avengers!");
        }
        else if(yearsOutOfIce > 0){
            System.out.println("Captain America is ready to fight!");
        }
        else
        System.out.println("He's still asleep!");
    }
    public void fightDamage(){
        newShield.thrown();
    }
    
}

