public class shield {
    private String material;
    private Boolean onCap;
    private int damagePercent;

    public shield(String mat){
        this.material = mat;
        this.onCap = true;
        this.damagePercent = 0;
    }
    public String getMaterial(){
        return material;
    }
    public Boolean shieldOnCap(){
        return onCap;
    }
    public int getDamage(){
        return damagePercent;
    }
    public void throwShielf(){
        onCap = false;
        System.out.println("Cap throws the shield!");
    }
}
