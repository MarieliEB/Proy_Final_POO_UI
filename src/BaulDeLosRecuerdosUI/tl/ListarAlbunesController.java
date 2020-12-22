package BaulDeLosRecuerdosUI.tl;

import BaulDeLosRecuerdosUI.tl.ModelTables.ModelTableAlbum;
import BaulDeLosRecuerdosUI.tl.ModelTables.ModelTableCompositores;
import cr.ac.ucenfotec.bl.entities.album.Album;
import cr.ac.ucenfotec.bl.entities.artista.Artista;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ListarAlbunesController implements Initializable {

        private Gestor gestor;

        @FXML
        private TableView<ModelTableAlbum> tblAlbums;
        @FXML
        private TableColumn<ModelTableAlbum, String> colNombre;
        @FXML
        private TableColumn<ModelTableAlbum, String> colFechaLanzamiento;
        @FXML
        private TableColumn<ModelTableAlbum, String> colArtistas;


    public ListarAlbunesController(){
            gestor = new Gestor();
        }


        public ObservableList<ModelTableAlbum> albumContenidos() throws Exception{

            ArrayList<Album> albunes = gestor.getAlbum();
            ObservableList<ModelTableAlbum> obList = FXCollections.observableArrayList();

            for(int i = 0; albunes.size() > i; i++){

                colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                colFechaLanzamiento.setCellValueFactory(new PropertyValueFactory<>("fechaLanzamiento"));
                colArtistas.setCellValueFactory(new PropertyValueFactory<>("artista"));


                String nombre = albunes.get(i).getNombre();
                LocalDate fechaLlanzamiento = albunes.get(i).getFechaLanzamiento();
                ArrayList<Artista> artista = albunes.get(i).getArtistas();

               obList.add(new ModelTableAlbum(nombre));
            }
            return obList;
        }



        public void registrarAlbum(ActionEvent actionEvent) { {

            try{
                Parent root = FXMLLoader.load(getClass().getResource("../fxml/RegistrarAlbum.fxml"));

                Scene scene = new Scene(root);
                Stage stage = (Stage)((Node) (actionEvent.getSource())).getScene().getWindow();

                stage.setScene(scene);
                stage.setTitle("Registrar álbum");
                stage.setResizable(false);
                stage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
           // tblAlbums.setItems(albumContenidos());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
