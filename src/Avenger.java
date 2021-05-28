public class Avenger {
    private String alias;
    private String secretIdentity;
    private Boolean alive;

    public Avenger(String name, String superHero){
        secretIdentity = name;
        alias = superHero;
        alive = true;
    }
    public String getAlias(){
        return alias;
    }
    public String getSecretIdentity(){
        return secretIdentity;
    }
    public Boolean isAlive(){
        return alive;
    }
}
