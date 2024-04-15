public class Material {
    private String  name ;
    private int cantidad;
    private String color ;
    private String tipo;


    public Material(String name, int cantidad, String color , String tipo) {
        this.name = name;
        this.cantidad = cantidad;
        this.color=color;
        this.tipo=tipo;
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
    public void setColor(String color) {
        this.color = color;
    }public String getColor() {
        return color;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }public String getTipo() {
        return tipo;
    }
    
}
