package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.StorageUnitOwner;
import java.io.IOException;


//!!!!! pri iterrirane na bazadata ot danni Ne trabva da imash NULL pole inache hvarla NULL_POINTER_EXEPTION
public class OwnerController{
    @FXML
    private Label ownerUserNameLabel=new Label();

   // int idOwner;

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
        FXMLLoader loader ;
        Stage newWin = new Stage();
        Scene newScene;
        if (createStorageUnit.isSelected()){
            //TODO NumberFormatException handler which could occurs from  CreateStorageUnitController
            loader=new FXMLLoader(getClass().getResource("../xml/createStorageUnit.fxml"));
            logInParent = loader.load();
            CreateStorageUnitController createStorageUnitController=loader.getController();
            createStorageUnitController.srorageUnitOwnerName(owner);
        }
        else if (hireAgent.isSelected()){
            loader=new FXMLLoader(getClass().getResource("../xml/hireAgents.fxml"));
            logInParent = loader.load();
        HireAgentController hireAgentController=loader.getController();
        hireAgentController.initWindow(owner);

        }

        else {
         loader=new FXMLLoader(getClass().getResource("../xml/listAllStorageUnitByOwner.fxml"));
            logInParent = loader.load();
            ListAllStorageUnitByOwnerController listAllStorageUnitByOwnerController=loader.getController();
            listAllStorageUnitByOwnerController.setStorageUnitOwnerName(owner);

        }
        newScene = new Scene(logInParent);
        newWin.setScene(newScene);
        newWin.show();

    }

    public void fetchOwnerFromLogInForum(StorageUnitOwner sendOwner/*,int id_owner*/){
        //Owner
        //idOwner=id_owner;
        owner=sendOwner;
        ownerUserNameLabel.setText(owner.getUserName());

        //TODO delete system.out after finish the lesson
        System.out.println(
                ownerUserNameLabel.getText()
                        +"    \n  "+owner.getId_owner()
                        +"    \n   "+owner.getUserName()
                        +"    \n   "+owner.getFirstName()
                        +"    \n   "+owner.getLastName());


        //
    }
}
