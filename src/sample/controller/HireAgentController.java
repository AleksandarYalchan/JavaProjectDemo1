package sample.controller;

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
import sample.StorageUnitAgent;
import sample.StorageUnitOwner;

//TODO every time when you want to hire agent, instead showing all agents just show all agents without
// contract, and every time when user choose a agent when add button is clicked, the agent have to disappear
// from table
public class HireAgentController {

    private int idStorageUnit;


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

        tableViewUnits.setItems(listStorageUnit.getListStorageUnitsByOwner(storageUnitOwner));
        tableViewAgents.setItems(listAllAgentsController.fetchAgents());
    }

    public void initWindow(StorageUnitOwner owner){
        this.storageUnitOwner=owner;
        loadTables();
    }


    public StorageUnitAgent selectAgent(){
        int index =tableViewAgents.getSelectionModel().getSelectedIndex();
        StorageUnitAgent agent=tableViewAgents.getItems().get(index);
        System.out.println(agent);
        //System.out.println(e.getTarget().getClass().toString());
        return agent;
    }
    public StorageUnit selectStorageUnit(){
        int index =tableViewUnits.getSelectionModel().getSelectedIndex();
        StorageUnit  unit=tableViewUnits.getItems().get(index);

        System.out.println(unit);
        return unit;
    }

    public void addAgentToStorageUnit(){
        //idStorageUnit=selectStorageUnit().getUnit_id();
        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        //Query query = session.createQuery("from StorageUnit s where s.id= :idStorageUnit ");
        //StorageUnit unit=(StorageUnit) query.getSingleResult();
         StorageUnit unit=selectStorageUnit();
         StorageUnitAgent agent=selectAgent();
        unit.setContractor(agent);
        session.update(unit);
        t.commit();
        session.close();
    }

    public  void closeButtonClicked(ActionEvent event){
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }



}
