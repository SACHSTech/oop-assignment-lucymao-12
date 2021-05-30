package oopAssignment;
import java.io.*;

public class superMain{
    public static void main(String[] args) throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        captainAmerica capAm = new captainAmerica(5, new shield("Vibranium"), "Steve Rogers", "Captain America");

        System.out.println("Captain America spots an enemy!");
        String fight = kReader.readLine();
        capAm.fightWin(fight);
    }

}