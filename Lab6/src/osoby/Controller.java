package osoby;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    public TextField fullNameField;
    public TextField telephoneField;
    public TextField peselField;
    public Button dodajButton;
    public Button usunButton;
    public TableView<Osoba> tableControl;
    public TableColumn<Osoba, String> fullname;
    public TableColumn<Osoba, String> telephone;
    public TableColumn<Osoba, String> pesel;
    private ObservableList<Osoba> observableList = FXCollections.observableArrayList(
    );

    @Override
    public void initialize(URL location, ResourceBundle resource){
        fullname.setCellValueFactory(new PropertyValueFactory<>("Fullname"));
        telephone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        pesel.setCellValueFactory(new PropertyValueFactory<>("Pesel"));
        tableControl.setItems(observableList);
    }


    public void dodajAction(ActionEvent actionEvent) {
        observableList.add(new Osoba(fullNameField.getText(), telephoneField.getText(), peselField.getText()));
        fullNameField.clear();
        telephoneField.clear();
        peselField.clear();

    }

    public void usunAction(ActionEvent actionEvent) {
        for(int i=0; i<observableList.size(); i++){
            if(observableList.get(i).getFullname().equals(fullNameField.getText())&&observableList.get(i).getTelephone().equals(telephoneField.getText())&&observableList.get(i).getPesel().equals(peselField.getText())){
                observableList.remove(i);
                i--;
            }
        }

    }


}
