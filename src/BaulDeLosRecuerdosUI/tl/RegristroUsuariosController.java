package BaulDeLosRecuerdosUI.tl;

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
import java.util.ResourceBundle;

public class RegristroUsuariosController implements Initializable {

    private Gestor gestor;

    public RegristroUsuariosController(){
        gestor = new Gestor();
    }

    //***************************************************************//
    //**************************************************************//

    @FXML
    public ComboBox paises;
    @FXML
    private TextField txtNombre, txtApellidoUno, txtApellidoDos, txtId, txtCorreo, txtNombreUsuario, txtContrasenna;
    @FXML
    private TextArea direccion;
    @FXML
    private DatePicker txtFechaNacimiento;

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

    @FXML
    public void UsuarioRegistrado(String usuarioR, String contrasennaR) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("El usuario se ha registrado exitosamente");
        alert.setHeaderText("Usuario: " + usuarioR  + "\nContraseña: " + contrasennaR);
        alert.setContentText("¡Usuario registrado!");

        alert.showAndWait();
    }//FIN de USUARIO REGISTRADO

    public void SalvarDatos(ActionEvent actionEvent) throws Exception {

        gestor.registrarCliente("", txtCorreo.getText(), txtNombreUsuario.getText(), txtContrasenna.getText(), txtNombre.getText(), txtApellidoUno.getText(),
                txtApellidoDos.getText(), txtFechaNacimiento.getValue(), paises.getId(), txtId.getText(), "");

        UsuarioRegistrado(txtNombreUsuario.getText(), txtContrasenna.getText());

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paises.setItems(paisesContent);
    }
}
