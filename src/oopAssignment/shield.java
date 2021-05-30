package oopAssignment;
import java.util.Random;

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
    public void thrown(){
        System.out.println("The shield is thrown!");
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
                //System.out.println(randInt);
                System.out.println("Damage: " + getDamage());
            }else if(!getMaterial().equalsIgnoreCase("vibranium")){
                damagePercent += 10;
                System.out.println("The shield missed, Ouch!");
                System.out.println("Damage: " + getDamage());
            }
        }
    }
}
