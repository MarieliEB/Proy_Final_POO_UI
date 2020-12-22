package BaulDeLosRecuerdosUI.tl.ModelTables;

public class ModelTableArtistas {

    String nombreArtistico, edad, genero, descripcion;


    public ModelTableArtistas(String nombreArtistico, String edad, String genero, String descripcion) {
        this.nombreArtistico = nombreArtistico;
        this.edad = edad;
        this.genero = genero;
        this.descripcion = descripcion;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
