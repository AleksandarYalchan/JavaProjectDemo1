package sample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "units")
public class StorageUnit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "unit_id")
    private int unit_id;
    //boolean status;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "unit_agent_mapping", joinColumns = @JoinColumn(name = "unit_id"),
            inverseJoinColumns = @JoinColumn(name = "agent_id"))
    @Column(name = "storage_unit_agent")
    private Collection<StorageUnitAgent> Contracted_By = new ArrayList<>();

    @Column(name = "name_storage_unit")
    private String Name;

    @Column(name = "address")
    private String Address;

    @Column(name = "size")
    private int Size;

    @Column(name = "category")
    private String Category;

    @Column(name = "climate")
    private String Climatic_Conditions;

    @Column(name = "containings")
    private String Containings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    StorageUnitOwner Owned_By;

    @Column(name = "rent_prize")
    private double Rent_Price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tenant_id")
    StorageUnitTenant Current_Tenant;
//
//    @Column(name = "status")
//    private boolean isRented;


    @Column(name = "date_from")
    private Date Rented_From;

    @Column(name = "date_until")
    private Date Rented_Until;


    public StorageUnit() {
    }

    public int getUnit_id() {
        return unit_id;
    }


    public StorageUnitOwner getOwned_By() {
        return Owned_By;
    }

    public void setOwned_By(StorageUnitOwner owned_By) {
        Owned_By = owned_By;
    }

    public Collection<StorageUnitAgent> getContracted_By() {
        return Contracted_By;
    }

    public void setContracted_By(Collection<StorageUnitAgent> contracted_By) {
        Contracted_By = contracted_By;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getClimatic_Conditions() {
        return Climatic_Conditions;
    }

    public void setClimatic_Conditions(String climatic_Conditions) {
        Climatic_Conditions = climatic_Conditions;
    }

    public String getContainings() {
        return Containings;
    }

    public void setContainings(String containings) {
        Containings = containings;
    }

    public StorageUnitTenant getCurrent_Tenant() {
        return Current_Tenant;
    }

    public void setCurrent_Tenant(StorageUnitTenant current_Tenant) {
        Current_Tenant = current_Tenant;
    }

    public double getRent_Price() {
        return Rent_Price;
    }

    public void setRent_Price(double rent_Price) {
        Rent_Price = rent_Price;
    }

    public Date getRented_From() {
        return Rented_From;
    }

    public void setRented_From(Date rented_From) {
        Rented_From = rented_From;
    }

    public Date getRented_Until() {
        return Rented_Until;
    }

    public void setRented_Until(Date rented_Until) {
        Rented_Until = rented_Until;
    }

//    public boolean isRented() {
//        return isRented;
//    }
//
//    public void setRented(boolean rented) {
//        isRented = rented;
//    }

    @Override
    public String toString() {
        return "StorageUnit{" +
//                "unit_id=" + unit_id +
//                ", Owned_By=" + Owned_By +
//                ", Contracted_By=" + Contracted_By +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Size=" + Size +
                ", Category='" + Category + '\'' +
                ", Climatic_Conditions='" + Climatic_Conditions + '\'' +
                ", Containings='" + Containings + '\'' +
//                ", Current_Tenant=" + Current_Tenant +
                ", Rent_Price=" + Rent_Price +
//                ", Rented_From=" + Rented_From +
//                ", Rented_Until=" + Rented_Until +
                '}';
    }
}
