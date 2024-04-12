
public abstract class Productos {
    protected int  precio;
    protected String talla;
    protected String color;
    protected String name;
    protected String sexo;
    protected int cantidad;
    protected int id;

    

    public Productos (){}

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSexo() {
        return sexo;
    }public void setId(int id) {
        this.id = id;
    }public int getId() {
        return id;
    }public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }public int getCantidad() {
        return cantidad;
    }


   public void setPrecio(int precio) {
       this.precio = precio;
   }
   public int getPrecio() {
       return precio;
   }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
   
    public void setTalla(String talla) {
        this.talla = talla;
    }
    public String getTalla() {
        return talla;
    }

    public abstract  void validacionProducto();
}
