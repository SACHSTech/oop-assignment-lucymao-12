package oopAssignment;

public class Avenger {
    private String heroName;
    private String secretIdentity;
    private Boolean alive;

    public Avenger(String name, String superHero){
        secretIdentity = name;
        heroName = superHero;
        alive = true;
    }
    public String getName(){
        return secretIdentity;
    }
    public String getHeroName(){
        return heroName;
    }
    public Boolean isAlive(){
        return alive;
    }
}
