package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewStoreController implements Initializable {
    private Store store;

    public updateStoreController() {
        super();
    }
    // Use the method is add the media in Store
    public updateStoreController(Store store) {
        // TODO Auto-generated constructor stub
        super();
        this.store = store;
    }
    @FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextField director;

    @FXML
    private TextField length;

    @FXML
    private TextField title;

    @FXML
    private ComboBox<String> listMedia = new ComboBox<String>();

    @FXML
    void btAddPressed(ActionEvent event) {
        // Add media in Store update later
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Added");
        alert.setHeaderText("Add Media");
        alert.setTitle("Add");
        alert.getButtonTypes().setAll(ButtonType.OK);
        alert.showAndWait();
    }

    public void initList() {
        listMedia.getItems().add("CD");
        listMedia.getItems().add("DVD");
        listMedia.getItems().add("BOOK");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        initList();
    }

}