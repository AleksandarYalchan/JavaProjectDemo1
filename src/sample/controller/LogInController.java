package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.Admin;
import sample.StorageUnitAgent;
import sample.StorageUnitOwner;

import java.io.IOException;
import java.util.List;


public class LogInController {

    @FXML
    private TextField userNameField=new TextField();

    private boolean isAgentLogin =false;
    private boolean isAdminLogin=false;
    private boolean isOwnerLogin =false;

    public void logInAsAgent(Query query) throws IOException {

        List<StorageUnitAgent> storageUnitAgentList = query.list();
        for (int i = 0; i < storageUnitAgentList.size(); i++) {
            if (storageUnitAgentList.get(i).getUser_Name().equals(userNameField.getText())) {
                isAgentLogin = true;
            }
        }
    }

    public void logInAsAdmin(Query query) throws IOException {

        List<Admin> storageUnitAdminList = query.list();
        for (int i = 0; i < storageUnitAdminList.size(); i++) {
            if (storageUnitAdminList.get(i).getUserName().equals(userNameField.getText())) {
                isAdminLogin = true;
            }
        }
    }

    public void logInAsOwner(Query query) throws IOException {

        List<StorageUnitOwner> storageUnitOwnerList = query.list();
        for (int i = 0; i < storageUnitOwnerList.size(); i++) {
            if (storageUnitOwnerList.get(i).getUserName().equals(userNameField.getText())) {
                isOwnerLogin = true;
            }
        }
    }

    public void logInButtonClicked(ActionEvent event) throws IOException {
        Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();

        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Query queryAdmin = session.createQuery("from Admin ");
        Query queryOwner = session.createQuery("from StorageUnitOwner ");
        Query queryAgent = session.createQuery("from StorageUnitAgent ");

        logInAsAgent(queryAgent);
        logInAsAdmin(queryAdmin);
        logInAsOwner(queryOwner);

        transaction.commit();
        session.close();

        Parent logInParent;
        Stage newWin = new Stage();
        Scene newScene;
        if (isAgentLogin){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../xml/agent.fxml"));
           logInParent=loader.load();

            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
            currentStage.close();
        }
        else if(isOwnerLogin){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../xml/owner.fxml"));
            logInParent = loader.load();
            OwnerController ownerController = loader.<OwnerController>getController();
            //ownerController.fetchOwnerFromLogInForum(owner,id_owner);
            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
            currentStage.close();

        }
        else if(isAdminLogin){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../xml/admin.fxml"));
            logInParent = loader.load();
        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();
        currentStage.close();
        }
        else{
            logInParent = FXMLLoader.load(getClass().getResource("../xml/incorrectUserName.fxml"));
            newScene = new Scene(logInParent);
            newWin.setScene(newScene);
            newWin.show();
        }
    }

    public void cancelButtonClicked(ActionEvent event){
        Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
