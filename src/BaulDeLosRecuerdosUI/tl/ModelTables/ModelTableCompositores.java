package BaulDeLosRecuerdosUI.tl.ModelTables;

public class ModelTableCompositores {

    String nombre, apellido, pais, edad;

    public ModelTableCompositores(String nombre, String apellido, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
