package oopAssignment;
import java.io.*;

public class superMain{
    public static void main(String[] args){
        captainAmerica capAm = new captainAmerica(5, new shield("Vibranium"), "Steve Rogers", "Captain America");

        capAm.fightDamage();
    }

}