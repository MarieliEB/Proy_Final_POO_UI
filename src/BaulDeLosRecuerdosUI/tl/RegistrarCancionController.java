package BaulDeLosRecuerdosUI.tl;

import cr.ac.ucenfotec.bl.entities.artista.Artista;
import cr.ac.ucenfotec.bl.entities.compositor.Compositor;
import cr.ac.ucenfotec.bl.entities.genero.Genero;
import cr.ac.ucenfotec.bl.logic.Gestor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrarCancionController  implements Initializable {
    private Gestor gestor;

    public RegistrarCancionController(){
        gestor = new Gestor();
    }

    //***************************************************************//
    //**************************************************************//

    @FXML
    public ComboBox cbxGenero, cbxArtista, cbxCompositor;
    @FXML
    private DatePicker dtpFechaLanzamiento;


    public String inicializarArtista() throws Exception{
        ArrayList<Artista> artistas = gestor.getArtista();
        String nombreArtistas = "";
        int ultimaPoscicion = artistas.size() - 1;
        int cont = 0;
        for (Artista artista : artistas) {
            if (artistas.size() != ultimaPoscicion) {
                nombreArtistas = artista.getNombre();
                cont++;
            } else {
                nombreArtistas = artista.getNombre() + ",";
                cont++;
            }
        }
        return nombreArtistas;
    }

    ObservableList<String> artistasContent =
            FXCollections.observableArrayList(
                    //inicializarArtista();
            );


    public String inicializarCompositores() throws Exception{
        ArrayList<Compositor> compositores = gestor.getCompositor();
        String nombreCompositor = "";
        int ultimaPoscicion = compositores.size() - 1;
        int cont = 0;
        for (Artista artista : compositores) {
            if (compositores.size() != ultimaPoscicion) {
                nombreCompositor = artista.getNombre();
                cont++;
            } else {
                nombreCompositor = artista.getNombre() + ",";
                cont++;
            }
        }
        return nombreCompositor;
    }

    ObservableList<String> compositorContent =
            FXCollections.observableArrayList(
                    //inicializarArtista();
            );

    public String inicializarGeneros() throws Exception{
        ArrayList<Genero> generos = gestor.getGenero();
        String nombreGeneros = "";
        int ultimaPoscicion = generos.size() - 1;
        int cont = 0;
        for (Genero genero : generos) {
            if (generos.size() != ultimaPoscicion) {
                nombreGeneros = genero.getNombre();
                cont++;
            } else {
                nombreGeneros = genero.getNombre() + ",";
                cont++;
            }
        }
        return nombreGeneros;
    }



    ObservableList<String> generosContent =
            FXCollections.observableArrayList(
                    //inicializarGeneros();
            );


    public void RegistrarCancion(ActionEvent actionEvent) throws Exception{
        gestor.registrarCancion(cbxGenero.getId(), cbxArtista.getId(), cbxCompositor.getId(), dtpFechaLanzamiento.getValue(), 0);

        cancionRegistrada();

        try{
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/Home.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node) (actionEvent.getSource())).getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle("Collectors Bazar");
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void cancionRegistrada() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("La canción ha sido registrado exitosamente");
        alert.setContentText("¡Canción registrado!");

        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbxArtista.setItems(artistasContent);
        cbxGenero.setItems(generosContent);
        cbxCompositor.setItems(compositorContent);
    }
}
