package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Admin;
import sample.StorageUnitAgent;

public class CreateAgentController {
    @FXML
    TextField userNameAgent = new TextField();
    @FXML
    TextField firstNameAgent = new TextField();
    @FXML
    TextField lastNameAgent = new TextField();
    @FXML
    TextField changingFeeAgent = new TextField();

    public void createAgent() throws NumberFormatException{

        String userName,fName,lName;
        Double changingFee;
        userName=userNameAgent.getText();
        fName=firstNameAgent.getText();
        lName=lastNameAgent.getText();
        changingFee=Double.parseDouble(changingFeeAgent.getText());
        StorageUnitAgent agent=new StorageUnitAgent();
        agent.setUser_Name(userName);
        agent.setFirst_Name(fName);
        agent.setLast_Name(lName);
        agent.setCharging_Fee(changingFee);
        System.out.println(agent);
        Admin.CreateStorageUnitUserOrUnit(agent);
        userNameAgent.clear();
        firstNameAgent.clear();
        lastNameAgent.clear();
        changingFeeAgent.clear();


    }
}
