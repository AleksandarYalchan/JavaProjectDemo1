package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Admin;
import sample.StorageUnit;
import sample.StorageUnitOwner;

public class CreateStorageUnitController {

    private StorageUnitOwner storageUnitOwner=new StorageUnitOwner();
    @FXML
    TextField nameStorage = new TextField();
    @FXML
    TextField addressStorage = new TextField();
    @FXML
    TextField sizeStorage = new TextField();
    @FXML
    TextField climateStorage = new TextField();
    @FXML
    TextField categoryStorage = new TextField();
    @FXML
    TextField rentPriceStorage = new TextField();
    @FXML
    TextField containingsStorage = new TextField();

    public void createStorageUnit() throws NumberFormatException{
        String name,address,climate,category,containings;
        Integer size;
        Double price;
        name=nameStorage.getText();
        address=addressStorage.getText();
        category=categoryStorage.getText();
        climate=climateStorage.getText();
        containings=containingsStorage.getText();
        size=Integer.parseInt(sizeStorage.getText());
        price=Double.parseDouble(rentPriceStorage.getText());
        StorageUnit unit=new StorageUnit();
        unit.setName(name);
        unit.setAddress(address);
        unit.setCategory(category);
        unit.setClimatic_Conditions(climate);
        unit.setContainings(containings);
        unit.setSize(size);
        unit.setRent_Price(price);
        unit.setOwned_By(storageUnitOwner);

        Admin.CreateStorageUnitUserOrUnit(unit);


        nameStorage.clear();
        addressStorage.clear();
        sizeStorage.clear();
        climateStorage.clear();
        categoryStorage.clear();
        rentPriceStorage.clear();
        containingsStorage.clear();
    }

    public void srorageUnitOwnerName(StorageUnitOwner owner){
        this.storageUnitOwner=owner;
        System.out.println(storageUnitOwner.getFirstName()+"   "+storageUnitOwner.getLastName()+"   "+storageUnitOwner.getUserName()+"    "+storageUnitOwner.getId_owner());
    }
}
