package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class OwnerController {

        @FXML
        private RadioButton createStorageUnit;
        @FXML
        private RadioButton hireAgent;
        @FXML
        private RadioButton listStorageUnit;

    private ToggleGroup myOwnerOptionGroup;
        public void makeAChoice(){
            myOwnerOptionGroup=new ToggleGroup();
            createStorageUnit.setToggleGroup(myOwnerOptionGroup);
            hireAgent.setToggleGroup(myOwnerOptionGroup);
            listStorageUnit.setToggleGroup(myOwnerOptionGroup);
        }

    public void selectButton()throws IOException {
    Parent logInParent;
    Stage newWin=new Stage();
    Scene newScene;
        if(createStorageUnit.isSelected())
    logInParent = FXMLLoader.load(getClass().getResource("../xml/createStorageUnit.fxml"));
        else if (hireAgent.isSelected())
    logInParent = FXMLLoader.load(getClass().getResource("../xml/hireAgent.fxml"));
        else
    logInParent = FXMLLoader.load(getClass().getResource("../xml/listStorageUnit.fxml"));

    newScene=new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();

}

}
