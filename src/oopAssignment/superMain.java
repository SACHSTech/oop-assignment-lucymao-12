package oopAssignment;
import java.io.*;


public class superMain{
    public static void main(String[] args) throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Make your own Captain America!");
        System.out.println("What is the shield made of? (Hint: Vabranium is strongest)");
        String shld = kReader.readLine();
        System.out.println("");
        System.out.println("Who is behind the mask?");
        String identity = kReader.readLine();
        System.out.println("");
        System.out.println("How any years have they been out of the ice (Put 0 if they have not)");
        int ice = Integer.parseInt(kReader.readLine());
        System.out.println("");
        System.out.println("PLease list enemy: health, name, and attack damage");
        int eHealth = Integer.parseInt(kReader.readLine());
        String bad = kReader.readLine();
        int eAttack = Integer.parseInt(kReader.readLine());


        captainAmerica capAm = new captainAmerica(ice, new shield(shld), identity, new enemy(eHealth, bad, eAttack));
        
        ironMan irnman = new ironMan(new suit("Red", 100, 45), "Tony Stark", new enemy(50, "War Monger", 20));

        System.out.println("Captain America spots an enemy!");
        capAm.fight();

        System.out.println("Iron man spots an enemy");
        irnman.fight();
    }

}