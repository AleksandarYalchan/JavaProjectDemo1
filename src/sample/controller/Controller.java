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
        Parent logInParent;
        Stage newWin=new Stage();
        Scene newScene;
        //                                                     ../xml/logInAsAdmin.fxml
        logInParent = FXMLLoader.load(getClass().getResource("../xml/admin.fxml"));
        newScene=new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }


    public void ownerButtonClicked(ActionEvent event) throws IOException {
        Parent logInParent;
        Stage newWin=new Stage();
        Scene newScene;
        logInParent = FXMLLoader.load(getClass().getResource("../xml/logInAsOwner.fxml"));
        newScene=new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }

    public void agentButtonClicked(ActionEvent event) throws IOException {

        Parent logInParent;
        Stage newWin=new Stage();
        Scene newScene;
        logInParent = FXMLLoader.load(getClass().getResource("../xml/logInAsAgent.fxml"));
        newScene=new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
    }
}


