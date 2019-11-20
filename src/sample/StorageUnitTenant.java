package sample;

import javax.persistence.*;

@Entity
@Table(name="tenants")
public class StorageUnitTenant {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int id;
    private String First_Name;
    private String Last_Name;
    private int Rented_Storage_Units;
}
