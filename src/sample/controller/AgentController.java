package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.StorageUnitAgent;

import java.io.IOException;

public class AgentController {

    private StorageUnitAgent agent=new StorageUnitAgent();
    @FXML
    private Label agentNameLabel=new Label();
    @FXML
    private RadioButton rentStorageUnit;
    @FXML
    private RadioButton listAllContracts;
    @FXML
    private RadioButton listAllUnrentedStorageUnits;
    @FXML
    private RadioButton seeYourRating;
    @FXML
    private ToggleGroup myOptionGroup3;

    public void makeChoice() {
        rentStorageUnit.setToggleGroup(myOptionGroup3);
        listAllContracts.setToggleGroup(myOptionGroup3);
        listAllUnrentedStorageUnits.setToggleGroup(myOptionGroup3);
        seeYourRating.setToggleGroup(myOptionGroup3);

    }

    public void selectButton() throws IOException {
        Parent logInParent;
        Stage newWin = new Stage();
        Scene newScene;
        if (rentStorageUnit.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/rentStorageUnit.fxml"));
        else if (listAllContracts.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/listAllContracts.fxml"));
        else if (listAllUnrentedStorageUnits.isSelected())
            logInParent = FXMLLoader.load(getClass().getResource("../xml/listAllUnrentedStorageUnits.fxml"));
        else
            logInParent = FXMLLoader.load(getClass().getResource("../xml/seeYourRating.fxml"));
        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();

    }

    public void fetchAgentFromLogInForm(StorageUnitAgent agent) {
        this.agent=agent;
        agentNameLabel.setText(agent.getUser_Name());
    }
}
