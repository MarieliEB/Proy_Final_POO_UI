package BaulDeLosRecuerdosUI.tl;

import cr.ac.ucenfotec.bl.entities.artista.Artista;
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

public class RegistrarAlbumController  implements Initializable {
        private Gestor gestor;

    public RegistrarAlbumController(){
            gestor = new Gestor();
        }

        //***************************************************************//
        //**************************************************************//

        @FXML
        public ComboBox cbxArtista;
        @FXML
        private TextField txtNombre, txtArtistas;
        @FXML
        private DatePicker dtpFechaLanzamiento;

        ObservableList<String> artistasContent =
                FXCollections.observableArrayList(
                        //inicializarArtista();
                );

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

        @FXML
        public void albumRegistrado() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("El album ha sido registrado exitosamente");
            alert.setContentText("¡Álbum registrado!");

            alert.showAndWait();
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            cbxArtista.setItems(artistasContent);
        }

    public void subirImagen(ActionEvent actionEvent) {
    }

    public void registrarAlbum(ActionEvent actionEvent) throws Exception{
            gestor.registrarAlbum(txtNombre.getText(), dtpFechaLanzamiento.getValue(), "", 0);

            albumRegistrado();

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
}
