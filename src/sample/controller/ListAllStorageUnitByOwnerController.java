package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.StorageUnit;
import sample.StorageUnitOwner;
import sample.StorageUnitTenant;
import java.util.Date;
import java.util.List;

public class ListAllStorageUnitByOwnerController {
    @FXML
    private TableView<StorageUnit> tableView;
    @FXML
    private TableColumn<StorageUnit, String> nameStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> addressStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Integer> sizeStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> categoryStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Double> rentPriceStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> climateStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, String> containingsStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, StorageUnitTenant> tenantStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Date> dateFromStorageUnitColumn;
    @FXML
    private TableColumn<StorageUnit, Date> dateUntilSTorageUnitColumn;

    public ObservableList<StorageUnit> getListStorageUnitsByOwner(  StorageUnitOwner owner) {

        //System.out.println("in list storage class fetchStorageUnitOwner() method:"+storageUnitOwner.getFirstName() + "   " + storageUnitOwner.getLastName() + "   " + storageUnitOwner.getUserName() + "    " + storageUnitOwner.getId_owner());
        ObservableList<StorageUnit> storageUnitOList = FXCollections.observableArrayList();

        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from StorageUnit ");
        List<StorageUnit> storageUnitList = query.list();
        for (int i = 0; i < storageUnitList.size(); i++) {
            // System.out.println((i + 1) + ". " + storageUnitAgentList.get(i).toString());
            if (storageUnitList.get(i).getOwned_By().getId_owner() == owner.getId_owner())
                storageUnitOList.add(storageUnitList.get(i));

        }
        t.commit();
        session.close();
        return storageUnitOList;
    }


    public void initTable( StorageUnitOwner owner){
        nameStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addressStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        sizeStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Size"));
        categoryStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        rentPriceStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Rent_Price"));
        climateStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Climatic_Conditions"));
        containingsStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Containings"));
        tenantStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Current_Tenant"));
                dateFromStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Rented_From"));
        dateUntilSTorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Rented_Until"));
        tableView.setItems(getListStorageUnitsByOwner(owner));
    }

    public void setStorageUnitOwnerName(StorageUnitOwner owner) {
        System.out.println("in list storage class srorageUnitOwnerName(StorageUnitOwner owner)  method: "+owner.getFirstName() + "   " + owner.getLastName() + "   " + owner.getUserName() + "    " + owner.getId_owner());
       initTable(owner);
    }

    public void closeButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }
}
