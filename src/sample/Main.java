package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage win;

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("xml/logIn.fxml"));
        primaryStage.setTitle("Storage Unit Project");
        Scene scene=new Scene(root, 422, 268);
        scene.getStylesheets().add("/sample/style/myTheme.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
