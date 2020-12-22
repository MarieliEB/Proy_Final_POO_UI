package BaulDeLosRecuerdosUI.tl;

import cr.ac.ucenfotec.bl.logic.Gestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarGeneroController implements Initializable {

    private Gestor gestor;

    public RegistrarGeneroController(){
        gestor = new Gestor();
    }

    //***************************************************************//
    //**************************************************************//

    @FXML
    private TextField txtNombre;
    @FXML
    private TextArea txtDescripcion;

    public void RegistrarGenero(ActionEvent actionEvent) throws Exception{
        gestor.registrarGenero(txtNombre.getText(), txtDescripcion.getText());
        vaciarContenidos();
    }

    @FXML
    public void generoNoRegistrado() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error de Registro");
        alert.setHeaderText("Ha habido un problema en el registro.");
        alert.setContentText("No se ha registrado el nuevo género");

        alert.showAndWait();
    }

    @FXML
    public void generoRegistrado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("El género ha sido registrado exitosamente");
        alert.setContentText("¡Género registrado!");

        alert.showAndWait();
    }

    public void vaciarContenidos(){

        txtNombre.setText("");
        txtDescripcion.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
