package sample;


import javax.persistence.*;

@Entity
@Table(name = "owners")
public class StorageUnitOwner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_owner")
    private int id_owner;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="user_name")
    private String userName;
    public StorageUnitOwner() {
    }

    public int getId_owner() {
        return id_owner;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "StorageUnitOwner{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    public void CreateStorageUnit(StorageUnit unit) {
            unit.setOwned_By(this);
        Admin.CreateStorageUnitUserOrUnit(unit);
    }
}

