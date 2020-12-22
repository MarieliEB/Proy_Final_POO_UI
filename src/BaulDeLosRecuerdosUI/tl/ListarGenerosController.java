package BaulDeLosRecuerdosUI.tl;

import BaulDeLosRecuerdosUI.tl.ModelTables.ModelTableGenero;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListarGenerosController implements Initializable {

    private Gestor gestor;

    @FXML
    private TableView<ModelTableGenero> tblGeneros;
    @FXML
    private TableColumn<ModelTableGenero, String> colNombre;
    @FXML
    private TableColumn<ModelTableGenero, String> colDescripcion;


    public ListarGenerosController(){
        gestor = new Gestor();
    }

    public ObservableList<ModelTableGenero> generoContenidos() throws Exception{

        ArrayList<Genero> genero = gestor.getGenero();
        ObservableList<ModelTableGenero> obList = FXCollections.observableArrayList();

        for(int i = 0; genero.size() > i; i++){

            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));


            String nombre = genero.get(i).getNombre();
            String desc = genero.get(i).getDescripcion();

            obList.add(new ModelTableGenero(nombre, desc));
        }
        return obList;
    }

    public void AgregarGenero(ActionEvent actionEvent) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/ListarGeneros.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node) (actionEvent.getSource())).getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle("Listar Generos");
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tblGeneros.setItems(generoContenidos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
