package oopAssignment;
import java.io.*;
public class suit {
    private String colour;
    private int repulsorPower;
    private int damagePercent;
    private int markNum;

    public suit(String col, int power, int mark){
        this.colour = col;
        this.repulsorPower = power;
        this.damagePercent = 0;
        this.markNum = mark;
    }
    public String getColour(){
        return colour;
    }
    public int getDamage(){
        return damagePercent;
    }
    public int getMarkNum(){
        return markNum;
    }
    public int getRepulsor(){
        return repulsorPower;
    }
    public void suitUp(){
        System.out.println("Mark " + getMarkNum() + " is ready with " + getRepulsor() + " % power.");
        System.out.println("It's a gorgeous " + getColour() + ".");
    }
    public void suitBlast() throws IOException{
        String fireYes = "yes";
        while(getRepulsor() > 0 && fireYes.equalsIgnoreCase("yes")){
            BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Fire? (Yes/No)");
            fireYes = kReader.readLine();
            if(fireYes.equalsIgnoreCase("yes")){
                System.out.println("The repulsor fires off a blast!");
                repulsorPower -= 10;
                System.out.println("Repulsor power: " + repulsorPower);
                //set enemy damage according to repulsor power
            }if(fireYes.equalsIgnoreCase("no")){
                System.out.println("Recharge? (Yes/No)");
                fireYes = kReader.readLine();
                repulsorPower += 20;
            }
                
        }
    }
}
