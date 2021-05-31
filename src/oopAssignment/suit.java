package oopAssignment;
import java.io.*;
public class suit {
    private String colour;
    private int repulsorPower;
    private int markNum;

    public suit(String col, int power, int mark){
        this.colour = col;
        this.repulsorPower = power;
        this.markNum = mark;
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
    public void suitUp(){
        System.out.println("Mark " + getMarkNum() + " is ready with " + getRepulsor() + "% power.");
        System.out.println("It's a gorgeous " + getColour() + ".");
    }
    public void suitBlast() throws IOException{
        if(repulsorPower > 0){
            System.out.println("The repulsor fires off a blast! (" + repulsorPower/5 + " damage)");
            repulsorPower -= 10;
            System.out.println("Repulsor power: " + repulsorPower);
        }
            //set enemy damage according to repulsor power
        if(repulsorPower <= 0){
            System.out.println("The repulsors are out of power!");
        }   
    }

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
}
