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

public class HireAgentController {

    public ListAllAgentsController listAllAgentsController=new ListAllAgentsController();
    private ListAllStorageUnitByOwnerController listStorageUnit=new ListAllStorageUnitByOwnerController();
    private StorageUnitOwner storageUnitOwner = new StorageUnitOwner();
    @FXML
    private TableView<StorageUnit> tableViewUnits;
    @FXML
    private TableView<StorageUnitAgent> tableViewAgents;
    @FXML
    private TableColumn<StorageUnitAgent, String> userNameAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> firstNameAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> lastNameAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> chargingFeeAgentColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> ratingAgentColumn;

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
//    @FXML
//    private TableColumn<StorageUnit, StorageUnitTenant> tenantStorageUnitColumn;
//    @FXML
//    private TableColumn<StorageUnit, Date> dateFromStorageUnitColumn;
//    @FXML
//    private TableColumn<StorageUnit, Date> dateUntilSTorageUnitColumn;


    public ObservableList<StorageUnitAgent> fetchAgents() {

        ObservableList<StorageUnitAgent> agentsOList = FXCollections.observableArrayList();

        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from StorageUnitAgent");
        List<StorageUnitAgent> storageUnitAgentList2 = query.list();
        for (int i = 0; i < storageUnitAgentList2.size(); i++) {
             System.out.println((i + 1) + ". " + storageUnitAgentList2.get(i).toString());
            agentsOList.add(storageUnitAgentList2.get(i));

        }
        t.commit();
        session.close();
        return agentsOList;
    }

    public ObservableList<StorageUnit> fetchStorageUnits(){
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
    public void loadTables() {

        firstNameAgentColumn.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        lastNameAgentColumn.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        chargingFeeAgentColumn.setCellValueFactory(new PropertyValueFactory<>("Charging_Fee"));
        ratingAgentColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));

        nameStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        addressStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Address"));
        sizeStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Size"));
        categoryStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Category"));
        rentPriceStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Rent_Price"));
        climateStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Climatic_Conditions"));
        containingsStorageUnitColumn.setCellValueFactory(new PropertyValueFactory<>("Containings"));

        tableViewUnits.setItems(fetchStorageUnits());
        tableViewAgents.setItems(fetchAgents());
    }

    public void initWindow(StorageUnitOwner owner){
        this.storageUnitOwner=owner;
        loadTables();
    }


    public StorageUnitAgent selectAgent(){
        int index =tableViewAgents.getSelectionModel().getSelectedIndex();
        StorageUnitAgent agent=tableViewAgents.getItems().get(index);
        System.out.println(agent);
        return agent;
    }
    public StorageUnit selectStorageUnit(){
        int index =tableViewUnits.getSelectionModel().getSelectedIndex();
        StorageUnit unit=tableViewUnits.getItems().get(index);
        System.out.println(unit);
        return unit;
    }

}
