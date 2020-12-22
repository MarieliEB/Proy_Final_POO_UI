package BaulDeLosRecuerdosUI.tl;

import BaulDeLosRecuerdosUI.tl.ModelTables.ModelTableCompositores;
import cr.ac.ucenfotec.bl.entities.compositor.Compositor;
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

public class ListarCompositoresController implements Initializable {

    private Gestor gestor;

    @FXML
    private TableView<ModelTableCompositores> tblCompositor;
    @FXML
    private TableColumn<ModelTableCompositores, String> colNombre;
    @FXML
    private TableColumn<ModelTableCompositores, String> colApellido;
    @FXML
    private TableColumn<ModelTableCompositores, String> colPais;
    @FXML
    private TableColumn<ModelTableCompositores, String> colEdad;


    public ListarCompositoresController(){
        gestor = new Gestor();
    }


    public ObservableList<ModelTableCompositores> compositoresContenidos() throws Exception{

        ArrayList<Compositor> genero = gestor.getCompositor();
        ObservableList<ModelTableCompositores> obList = FXCollections.observableArrayList();

        for(int i = 0; genero.size() > i; i++){

            colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
            colPais.setCellValueFactory(new PropertyValueFactory<>("pais"));
            colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));


            String nombre = genero.get(i).getNombre();
            String apellido = genero.get(i).getApellido();
            String pais = genero.get(i).getPaisNacimiento();

            obList.add(new ModelTableCompositores(nombre, apellido, pais));
        }
        return obList;
    }



    public void agregarCompositor(ActionEvent actionEvent) {

        try{
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/ListarCompositores.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node) (actionEvent.getSource())).getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle("Listar Compositores");
            stage.setResizable(false);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            tblCompositor.setItems(compositoresContenidos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
