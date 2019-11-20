package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class OwnerController {

        @FXML
        private RadioButton createStorageUnit;
        @FXML
        private RadioButton hireAgent;
        @FXML
        private RadioButton listStorageUnit;

    private ToggleGroup myOwnerOptionGroup;
        public void makeAChoice(){
            myOwnerOptionGroup=new ToggleGroup();
            createStorageUnit.setToggleGroup(myOwnerOptionGroup);
            hireAgent.setToggleGroup(myOwnerOptionGroup);
            listStorageUnit.setToggleGroup(myOwnerOptionGroup);
        }
}
