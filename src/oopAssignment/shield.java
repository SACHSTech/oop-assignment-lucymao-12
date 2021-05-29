package oopAssignment;
import java.util.Random;

public class shield {
    private String material;
    private Boolean onCap;
    private int damagePercent;
    private Random random = new Random();

    public shield(String mat){
        this.material = mat;
        this.onCap = true;
        this.damagePercent = 0;
    }
    public String getMaterial(){
        return material;
    }
    public Boolean shieldOnCap(){
        return onCap;
    }
    public int getDamage(){
        return damagePercent;
    }
    public void thrown(){
        onCap = false;
        System.out.println("Captain America throws the shield!");
        Boolean ranBool = random.nextBoolean();
        if(ranBool){
            onCap = false;
            System.out.println("The shield hit the target!");
            System.out.println(ranBool);
            System.out.println("Damage: " + damagePercent);
        }if(!ranBool){
            damagePercent += 10;
            System.out.println("The shield missed, Captain America was hit!");
            System.out.println("Damage: " + damagePercent);
        }
    }
}
