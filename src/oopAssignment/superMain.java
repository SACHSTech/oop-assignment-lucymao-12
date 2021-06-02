package oopAssignment;
import java.io.*;
import java.security.Identity;

// the file to test and run all the classes
public class superMain{
    public static void main(String[] args) throws IOException{
        BufferedReader kReader = new BufferedReader(new InputStreamReader(System.in));
        String run;
        //captainAmerica capAm = new captainAmerica(10, new shield("vibraniume"), "Cap", new enemy(20, "bad", 20));
        
        /**
         * asking users to input values for the constrcutor of captain america class
         */
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

            // new instance of captain america class
            captainAmerica capAm = new captainAmerica(ice, new shield(shld), identity, new enemy(eHealth, bad, eAttack));
            
            /**
             * ask user if they would like to see the description of the captain america they created
             * run the printCap method if yes
             */
            System.out.println("List Captain America description? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                capAm.printCap();
            }

            /**
             * running the fight method if user inputs yes
             */
            System.out.println("Run fight simulation? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                System.out.println("Captain America spots an enemy!");
                capAm.fight();
            }
            
        }
        
        /**
         * ask user for values for the iron man constructor
         */
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
            
            // new iron man class instance
            ironMan irnman = new ironMan(identity, new enemy(eHealth, bad, eAttack));
            //ironMan irnman = new ironMan(new suit("g", 10, 7), "i", new enemy(40, "bad", 30));
            
            /**
             * user created suit added to suit list
             */
            suit nSuit = new suit(colour, power, mark);
            irnman.addSuit(nSuit);
            
            /**
             * populate list
             */
            suit mark50 = new suit("Gold", 100, 50);
            irnman.addSuit(mark50);
            suit mark1 = new suit("Grey", 60, 10);
            irnman.addSuit(mark1);
            /**
             * ask user if they would like to see their description printed back
             * run printShellHead method if yes
             */
            System.out.println("List Iron Man description? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                irnman.printSuitList();
                System.out.println("Which suit do you want to see?");
                int st = Integer.parseInt(kReader.readLine());
                irnman.printShellHead(st);
            }

            /**
             * ask user if they would like to run fight simulation
             * run fight method if yes
             */
            System.out.println("Run fight simulation? (Yes/No)");
            run = kReader.readLine();
            if(run.equalsIgnoreCase("yes")){
                System.out.println("Iron man spots an enemy");
                irnman.fight();
            }
        }
    }
}