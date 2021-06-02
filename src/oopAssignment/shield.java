package oopAssignment;
import java.util.Random;
import java.io.*;

// shield class, captain america has a shield
public class shield {
    // variables for this class
    private String material;
    private int health;
    private Random random = new Random();

    //getter and setter methods
    public shield(String mat){
        this.material = mat;
        this.health = 30;
    }
    public String getMaterial(){
        return material;
    }
    public int getHealth(){
        return health;
    }
    public void setHealth(int hlth){
        health = hlth;
    }
    public Boolean thrown() throws IOException{
        /**
         * 66% hit for vibranium, 33% hit for anything else
         * any miss will deal 10 damage to shield 
         * returns true for a hit and false for a miss
         */ 
        int randInt = random.nextInt(3);
        
        /**
         * 33% for both vibranium not hitting target and non vibranium hitting target
         */
        if(randInt > 1){
            if(!getMaterial().equalsIgnoreCase("vibranium")){
                System.out.println("The shield hit the target! (10 damage)");
                //System.out.println(randInt);
                System.out.println("Shield Health: " + getHealth());
                return true;
            }else if(getMaterial().equalsIgnoreCase("vibranium")){
                health -= 10;
                System.out.println("The shield missed (-10 shield health)");
                System.out.println("Shield Health: " + getHealth());
                return false;
            }
            
        /**
         * 66% chance for virbanium hitting target and non vibranium missing
         */
        }if(randInt < 2){
            if(getMaterial().equalsIgnoreCase("vibranium")){
                System.out.println("The shield hit the target! (10 damage)");
                System.out.println("Shield Health: " + getHealth());
                return true;
            }else if(!getMaterial().equalsIgnoreCase("vibranium")){
                health -= 10;
                System.out.println("The shield missed (-10 shield health)");
                System.out.println("Shield Health: " + getHealth());
                return false;
            }
        }
        return true;
    }
}
