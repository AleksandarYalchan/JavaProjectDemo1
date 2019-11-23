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
import sample.StorageUnitOwner;

import java.io.IOException;
import java.util.List;

public class LogInAsOwnerController {

    @FXML
    TextField userNameTextFieldOwner = new TextField();

    int id_owner;
    public void logInOwner() throws IOException {
        boolean flagIsExist = false;
        String userNameExist = "none";
        StorageUnitOwner owner = new StorageUnitOwner();
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from StorageUnitOwner ");
        List<StorageUnitOwner> storageUnitOwnerList = query.list();
        for (int i = 0; i < storageUnitOwnerList.size(); i++) {
            if (storageUnitOwnerList.get(i).getUserName().equals(userNameTextFieldOwner.getText())) {
                flagIsExist = true;
                userNameExist = storageUnitOwnerList.get(i).getUserName();
                owner = storageUnitOwnerList.get(i);
            id_owner=storageUnitOwnerList.get(i).getId_owner();
                //break;
            }
        }
        t.commit();
        session.close();
//        System.out.println("Your user Name is" + userNameExist);
//        FXMLLoader loader = new FXMLLoader();
//        Parent logInParent;
//        Stage newWin = new Stage();
//        Scene newScene;
//        if (flagIsExist == false) {
//            logInParent = loader.load(getClass().getResource("../xml/incorrectUserName.fxml"));
//            OwnerController ownerController = loader.getController();
//            ownerController.fetchOwnerFromLogInForum(owner);
//            newScene = new Scene(logInParent);
//            newWin.setScene(newScene);
//            newWin.show();
//        } else {
//            logInParent = loader.load(getClass().getResource("../xml/owner.fxml"));
//            newScene = new Scene(logInParent);
//            newWin.setScene(newScene);
//            newWin.show();
//        }
//
//    }
//
        // StorageUnitOwner owner = new StorageUnitOwner();
        //owner.setUserName(userNameTextFieldOwner.getText());
        if(flagIsExist==true) {
            Stage newWin = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../xml/owner.fxml"));
            Parent logInParent = loader.load();
            OwnerController ownerController = loader.<OwnerController>getController();
            ownerController.fetchOwnerFromLogInForum(owner,id_owner);


            Scene newScene = new Scene(logInParent);
            //logInParent = loader.load(getClass().getResource("../xml/owner.fxml"));
//        newScene = new Scene(logInParent);
            newWin.setScene(newScene);


            newWin.show();
        }
        else{
            Stage newWin = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../xml/incorrectUserName.fxml"));
            Parent logInParent = loader.load();


            Scene newScene = new Scene(logInParent);
            //logInParent = loader.load(getClass().getResource("../xml/owner.fxml"));
//        newScene = new Scene(logInParent);
            newWin.setScene(newScene);


            newWin.show();}
    }
}
