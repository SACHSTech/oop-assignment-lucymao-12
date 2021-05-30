package oopAssignment;
import oopAssignment.*;
import java.io.*;

import javax.crypto.SecretKeyFactorySpi;

public class ironMan extends Avenger{
    private Boolean fly;
    private suit nSuit;

    public ironMan(suit newSuit, String name){
        super(name, "Iron Man");
        this.nSuit = newSuit;
        fly = false;
    }
    public Boolean getFly(){
        return fly;
    }
    public void fight() throws IOException{
        nSuit.suitUp();
        nSuit.suitBlast();
        if(nSuit.getRepulsor() <= 0){
            setAlive(false);
            System.out.println(this.getName() + " is down!");
        }
    }
}
