package oopAssignment;
import java.io.*;
import java.security.Identity;


public class superMain{
    public static void main(String[] args) throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String run;
        //captainAmerica capAm = new captainAmerica(10, new shield("vibraniume"), "Cap", new enemy(20, "bad", 20));
        

        System.out.println("Run Captain America simulation?");
        run = kReader.readLine();
        if(run.equalsIgnoreCase("yes")){
            System.out.println("Make your own Captain America!" + "\n");
            System.out.print("What is the shield made of? (Hint: Vabranium is strongest) ");
            String shld = kReader.readLine();
            System.out.println("");
            System.out.print("Who is behind the mask? ");
            String identity = kReader.readLine();
            System.out.println("");
            System.out.print("How any years have they been out of the ice (Put 0 if they have not) ");
            int ice = Integer.parseInt(kReader.readLine());
            System.out.println("");
            System.out.println("PLease list enemy: health, name, and attack damage");
            System.out.print("Health: ");
            int eHealth = Integer.parseInt(kReader.readLine());
            System.out.print("Name: ");
            String bad = kReader.readLine();
            System.out.print("Attack: ");
            int eAttack = Integer.parseInt(kReader.readLine());

            captainAmerica capAm = new captainAmerica(ice, new shield(shld), identity, new enemy(eHealth, bad, eAttack));
            System.out.println("List Captain America description? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                capAm.printCap();
            }

            System.out.println("Run fight simulation? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                System.out.println("Captain America spots an enemy!");
                capAm.fight();
            }
            
        }
        

        System.out.println("Run Iron Man simulation?");
        run = kReader.readLine();
        if(run.equalsIgnoreCase("yes")){
            System.out.println("Make your own Iron Man!" + "\n");
            System.out.println("Suit");
            System.out.print("Colour: ");
            String colour = kReader.readLine();
            System.out.print("Mark Number: ");
            int mark = Integer.parseInt(kReader.readLine());
            System.out.print("Power %: ");
            int power = Integer.parseInt(kReader.readLine());
            System.out.println("");
            System.out.print("Who is behind the mask? ");
            String identity = kReader.readLine();
            System.out.println("");
            System.out.println("PLease list enemy: health, name, and attack damage");
            System.out.print("Health: ");
            int eHealth = Integer.parseInt(kReader.readLine());
            System.out.print("Name: ");
            String bad = kReader.readLine();
            System.out.print("Attack: ");
            int eAttack = Integer.parseInt(kReader.readLine());
            
            
            ironMan irnman = new ironMan(new suit(colour, power, mark), identity, new enemy(eHealth, bad, eAttack));
            //ironMan irnman = new ironMan(new suit("g", 10, 7), "i", new enemy(40, "bad", 30));
            System.out.println("List Iron Man description? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                irnman.printShellHead();
            }
            System.out.println("Run fight simulation? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                System.out.println("Iron man spots an enemy");
                irnman.fight();
            }
        }
    }
}