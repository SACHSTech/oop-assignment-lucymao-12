package oopAssignment;
import java.io.*;

// iron man has a suit objecy
public class suit {
    // variables for this class
    private String colour;
    private int repulsorPower;
    private int markNum;

    // constructor method
    public suit(String col, int power, int mark){
        this.colour = col;
        this.repulsorPower = power;
        this.markNum = mark;

    // getter and setter methods
    }
    public String getColour(){
        return colour;
    }
    public int getMarkNum(){
        return markNum;
    }
    public int getRepulsor(){
        return repulsorPower;
    }
    public void setPower(int pwr){
        repulsorPower = pwr;
    }

    // suit up method to describe the suit, runs at beginning of the fight method in ironman class
    public void suitUp(){
        System.out.println("Mark " + getMarkNum() + " is ready with " + getRepulsor() + "% power.");
        System.out.println("It's a gorgeous " + getColour() + ".");
    }

    /**
     *  method of attack for ironMan class
     *  power of attack based on the % charged of repulsor
     *  every fire takes 10% away
     */
    public void suitBlast() throws IOException{
        if(repulsorPower > 0){
            System.out.println("The repulsor fires off a blast! (" + repulsorPower/4 + " damage)");
            repulsorPower -= 10;
            System.out.println("Repulsor power: " + repulsorPower);
        }
            /**
             * check if repulsors are out of power, return print statement
             */
        if(repulsorPower <= 0){
            System.out.println("The repulsors are out of power!");
        }   
    }

    /**
     * recharge method to gain more % power
     * depending on mark number amount recharged will be different
     * higher mark = better recharge
     */
    public void Recharge(){
        if(markNum > 10){
            repulsorPower += 20;
            System.out.println("Repulsor power: " + repulsorPower);
        }
        if(markNum <= 10){
            repulsorPower += 10;
            System.out.println("Repulsor power: " + repulsorPower);
        }
    }
    public String printSuit(){
        return "a " + getColour() + " Mark " + getMarkNum() + " with " + getRepulsor() + "% power."; 
    }
}
