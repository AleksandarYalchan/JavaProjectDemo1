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
import sample.StorageUnitAgent;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListAllAgentsController implements Initializable {
    @FXML
    private TableView<StorageUnitAgent> tableView;
    @FXML
    private TableColumn<StorageUnitAgent, String> userNameColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> firstNameColumn;
    @FXML
    private TableColumn<StorageUnitAgent, String> lastNameColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> changingFeeColumn;
    @FXML
    private TableColumn<StorageUnitAgent, Double> ratingColumn;

    public ObservableList<StorageUnitAgent> fetchAgents() {

        ObservableList<StorageUnitAgent> agentsOList = FXCollections.observableArrayList();

        SessionFactory factory;
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("from StorageUnitAgent");
        List<StorageUnitAgent> storageUnitAgentList = query.list();
        for (int i = 0; i < storageUnitAgentList.size(); i++) {
            // System.out.println((i + 1) + ". " + storageUnitAgentList.get(i).toString());
            agentsOList.add(storageUnitAgentList.get(i));

        }
        t.commit();
        session.close();
        return agentsOList;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userNameColumn.setCellValueFactory(new PropertyValueFactory<>("User_Name"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("First_Name"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("Last_Name"));
        changingFeeColumn.setCellValueFactory(new PropertyValueFactory<>("Charging_Fee"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        tableView.setItems(fetchAgents());
    }
}
