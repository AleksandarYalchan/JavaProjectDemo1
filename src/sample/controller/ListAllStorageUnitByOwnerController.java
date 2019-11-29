package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import sample.StorageUnit;
import sample.StorageUnitAgent;
import sample.StorageUnitOwner;
import sample.StorageUnitTenant;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllStorageUnitByOwnerController {

    private StorageUnitOwner storageUnitOwner = new StorageUnitOwner();
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

    public ObservableList<StorageUnit> fetchStorageUnitOwner() {

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
            if (storageUnitList.get(i).getOwned_By().getId_owner() == storageUnitOwner.getId_owner())
                storageUnitOList.add(storageUnitList.get(i));

        }
        t.commit();
        session.close();
        return storageUnitOList;
    }


    public void init(){
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
        tableView.setItems(fetchStorageUnitOwner());
    }

    public void srorageUnitOwnerName(StorageUnitOwner owner) {
        this.storageUnitOwner = owner;
        System.out.println("in list storage class srorageUnitOwnerName(StorageUnitOwner owner)  method: "+storageUnitOwner.getFirstName() + "   " + storageUnitOwner.getLastName() + "   " + storageUnitOwner.getUserName() + "    " + storageUnitOwner.getId_owner());
       init();
    }
}
