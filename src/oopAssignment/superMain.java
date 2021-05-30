package oopAssignment;
import java.io.*;

public class superMain{
    public static void main(String[] args) throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        captainAmerica capAm = new captainAmerica(5, new shield("Vibranium"), "Sam Wilson");
        ironMan irnman = new ironMan(new suit("Red", 100, 45), "Tony Stark");

        System.out.println("Captain America spots an enemy!");
        String fight = kReader.readLine();
        capAm.fight(fight);

        System.out.println("Iron man spots an enemy");
        irnman.fight();
    }

}