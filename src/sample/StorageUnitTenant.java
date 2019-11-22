package sample;


import javax.persistence.*;

@Entity
@Table(name="tenants")
public class StorageUnitTenant {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name="tenant_id")
    private int id;
    @Column(name="first_name")
    private String First_Name;
    @Column(name="last_name")
    private String Last_Name;
    @Column(name="rented_units")
    private int Rented_Storage_Units;
}
