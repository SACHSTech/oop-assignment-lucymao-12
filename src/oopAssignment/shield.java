package oopAssignment;
import java.util.Random;
import java.io.*;

public class shield {
    private String material;
    private int damagePercent;
    private Random random = new Random();

    public shield(String mat){
        this.material = mat;
        this.damagePercent = 0;
    }
    public String getMaterial(){
        return material;
    }
    public int getDamage(){
        return damagePercent;
    }
    public void setDamage(int dmg){
        damagePercent = dmg;
    }
    public void thrown() throws IOException{
        /**
         * 66% hit for vibranium, 33% hit for anything else
         * any miss will deal 10 damage to shield 
         */ 
        int randInt = random.nextInt(3);
        if(randInt > 1){
            if(!getMaterial().equalsIgnoreCase("vibranium")){
                System.out.println("The shield hit the target!");
                //System.out.println(randInt);
                System.out.println("Damage: " + getDamage());
            }else if(getMaterial().equalsIgnoreCase("vibranium")){
                damagePercent += 10;
                System.out.println("The shield missed, Ouch!");
                System.out.println("Damage: " + getDamage());
            }
            
        }if(randInt < 2){
            if(getMaterial().equalsIgnoreCase("vibranium")){
                System.out.println("The shield hit the target!");
                System.out.println("Damage: " + getDamage());
            }else if(!getMaterial().equalsIgnoreCase("vibranium")){
                damagePercent += 10;
                System.out.println("The shield missed, Ouch!");
                System.out.println("Damage: " + getDamage());
            }
        }
    }
}
