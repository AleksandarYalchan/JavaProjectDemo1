package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.StorageUnitAgent;


import java.io.IOException;
import java.util.List;

public class LogInAsAgentController {
    @FXML
    TextField userNameTextField = new TextField();

    public void logInAgent() throws IOException {
        boolean flagIsExist = false;
        String userNameExist = "none";
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from StorageUnitAgent ");
        List<StorageUnitAgent> storageUnitAgentList = query.list();
        for (int i = 0; i < storageUnitAgentList.size(); i++) {
            if (storageUnitAgentList.get(i).getUser_Name().equals(userNameTextField.getText())) {
                flagIsExist = true;
                userNameExist = storageUnitAgentList.get(i).getUser_Name();
            }
        }
        t.commit();
        session.close();
        System.out.println("Your user Name is"+userNameExist);
        Parent logInParent;
        Stage newWin = new Stage();
        Scene newScene;
        if (flagIsExist==false)
            logInParent = FXMLLoader.load(getClass().getResource("../xml/incorrectUserName.fxml"));
        else
            logInParent = FXMLLoader.load(getClass().getResource("../xml/agent.fxml"));

        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();


    }
}
