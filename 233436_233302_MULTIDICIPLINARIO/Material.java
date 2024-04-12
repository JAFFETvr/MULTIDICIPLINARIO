public class Material {
    private String  name ;
    private int cantidad;

    public Material(String name, int cantidad) {
        this.name = name;
        this.cantidad = cantidad;
    }
    
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
