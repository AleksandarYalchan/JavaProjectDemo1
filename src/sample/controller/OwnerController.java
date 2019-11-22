package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.StorageUnitOwner;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OwnerController implements Initializable {
    @FXML
    private Label ownerUserNameLabel=new Label();
    private StorageUnitOwner owner=new StorageUnitOwner();
    @FXML
    private RadioButton createStorageUnit;
    @FXML
    private RadioButton hireAgent;
    @FXML
    private RadioButton listStorageUnit;

    private ToggleGroup myOwnerOptionGroup;

    public void makeAChoice() {
        myOwnerOptionGroup = new ToggleGroup();
        createStorageUnit.setToggleGroup(myOwnerOptionGroup);
        hireAgent.setToggleGroup(myOwnerOptionGroup);
        listStorageUnit.setToggleGroup(myOwnerOptionGroup);
    }

    public void selectButton() throws IOException {
        Parent logInParent;
        FXMLLoader loader = new FXMLLoader();
        Stage newWin = new Stage();
        Scene newScene;
        if (createStorageUnit.isSelected())
            //TODO NumberFormatException handler which could occurs from  CreateStorageUnitController
            logInParent = loader.load(getClass().getResource("../xml/createStorageUnit.fxml"));
        else if (hireAgent.isSelected())
            logInParent = loader.load(getClass().getResource("../xml/hireAgent.fxml"));
        else
            logInParent = loader.load(getClass().getResource("../xml/listStorageUnit.fxml"));

        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();

    }

    public void fetchOwnerFromLogInForum(StorageUnitOwner sendOwner){
        owner=sendOwner;
        ownerUserNameLabel.setText(owner.getUserName());
        System.out.println(ownerUserNameLabel.getText());

        //
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
