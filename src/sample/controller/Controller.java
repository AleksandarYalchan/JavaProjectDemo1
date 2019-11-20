package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {



    public void adminButtonClicked(ActionEvent event) throws IOException {

        //to do validation for the username
        Parent logInParent = FXMLLoader.load(getClass().getResource("../xml/admin.fxml"));
        Scene logInScene = new Scene(logInParent);
        Stage logInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logInStage.setScene(logInScene);
        logInStage.show();
    }


    public void ownerButtonClicked(ActionEvent event) throws IOException {

        Parent logInParent = FXMLLoader.load(getClass().getResource("../xml/owner.fxml"));
        Scene logInScene = new Scene(logInParent);
        Stage logInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logInStage.setScene(logInScene);
        logInStage.show();
    }

    public void agentButtonClicked(ActionEvent event) throws IOException {

        Parent logInParent = FXMLLoader.load(getClass().getResource("../xml/agent.fxml"));
        Scene logInScene = new Scene(logInParent);
        Stage logInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        logInStage.setScene(logInScene);
        logInStage.show();
    }
}


