package BaulDeLosRecuerdosUI.tl.ModelTables;

public class ModelTableAlbum {
    String nombre, fechaLanzamiento, artista;

    public ModelTableAlbum(String nombre, String fechaLanzamiento, String artista) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.artista = artista;
    }

    public ModelTableAlbum(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
}

