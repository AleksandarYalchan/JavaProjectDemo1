package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
   private RadioButton createOwner;
    @FXML
    private RadioButton createAgent;
    @FXML
    private RadioButton listAllOwners;
    @FXML
    private RadioButton listAllAgent;
    @FXML
    private RadioButton listOwnersUnits;

    private ToggleGroup myOptionGroup;

    public void makeAChoise(){
    myOptionGroup=new ToggleGroup();
    this.createOwner.setToggleGroup(myOptionGroup);
    this.createAgent.setToggleGroup(myOptionGroup);
    this.listAllOwners.setToggleGroup(myOptionGroup);
    this.listAllAgent.setToggleGroup(myOptionGroup);
    this.listOwnersUnits.setToggleGroup(myOptionGroup);
    }

    public void selectButton()throws IOException {
        Parent logInParent;
        Stage newWin=new Stage();
        Scene newScene;
        if(createOwner.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/createOwner.fxml"));
        else if (createAgent.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/createAgent.fxml"));
        else if (listAllOwners.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/listAllOwners.fxml"));
        else if (listAllAgent.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/listAllAgents.fxml"));
        else
            logInParent = FXMLLoader.load(getClass().getResource("../xml/listOwnersUnits.fxml"));
            newScene=new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();

    }
}
