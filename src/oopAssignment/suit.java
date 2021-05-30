package oopAssignment;
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
}
