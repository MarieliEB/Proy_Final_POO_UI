package BaulDeLosRecuerdosUI.tl;

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

public class RegistrarArtistaController implements Initializable {

    private Gestor gestor;

    public RegistrarArtistaController(){
        gestor = new Gestor();
    }

    //***************************************************************//
    //**************************************************************//

    @FXML
    public ComboBox cbxPaises, cbxGenero;
    @FXML
    private TextField txtNombre, txtApellido, txtNombreArtistico, txtDescripcion;
    @FXML
    private TextArea direccion;
    @FXML
    private DatePicker dtpFechaNacimiento, dtpFechaDefuncion;

    ObservableList<String> paisesContent =
            FXCollections.observableArrayList(
                    "Costa Rica",
                    "Nicaragua",
                    "Honduras",
                    "El Salvador",
                    "Guatemala",
                    "Pánama",
                    "Estados Unidos",
                    "México",
                    "Cuba",
                    "Puerto Rico"
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


    public void SalvarDatos(ActionEvent actionEvent) throws Exception{

        gestor.registrarArtista(txtNombre.getText(), txtApellido.getText(), txtNombreArtistico.getText(), dtpFechaNacimiento.getValue(),
                dtpFechaDefuncion.getValue(), cbxPaises.getId(), cbxGenero.getId(), 0, txtDescripcion.getText());

        artistaRegistrado();

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
    public void artistaRegistrado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("El artista ha sido registrado exitosamente");
        alert.setContentText("¡Artista registrado!");

        alert.showAndWait();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbxPaises.setItems(paisesContent);
        cbxGenero.setItems(generosContent);
    }
}
