package sample.controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Admin;
import sample.StorageUnitOwner;

public class CreateOwnerController {
    @FXML
    TextField firstName = new TextField();
    @FXML
    TextField lastName = new TextField();
    @FXML
    TextField userName = new TextField();

    public void createOwner(){
        //TODO use original claas method
        String fName,lName,uName;
        fName=firstName.getText();
        lName=lastName.getText();
        uName=userName.getText();
        StorageUnitOwner owner=new StorageUnitOwner();
        owner.setUserName(uName);
        owner.setFirstName(fName);
        owner.setLastName(lName);
        System.out.println(owner);
        Admin.CreateStorageUnitUserOrUnit(owner);
        userName.clear();
        firstName.clear();
        lastName.clear();
    }
}
