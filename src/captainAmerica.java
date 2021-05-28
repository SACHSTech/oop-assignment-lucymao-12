
public class captainAmerica extends Avenger{
    private int yearsOutOfIce;
    private shield newShield;
    private Boolean assemble;

    public captainAmerica(int ice, shield capShield, String secret, String hero){
        super(secret, hero);
        this.yearsOutOfIce = ice;
        this.newShield = capShield;
        this.assemble = false;
    }
    
}

