package sample;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class StorageUnitAgent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "agent_id")
    private int agent_id;
    @Column(name="user_name")
    private String User_Name;
    @Column(name="first_name")
    private String First_Name;
    @Column(name="last_name")
    private String Last_Name;
    @Column(name="charging_fee")
    private double Charging_Fee;
    @Column(name="rating")
    private double Rating;
    @Column(name="rate_number")
    private double Rate_Number;

    public StorageUnitAgent() {
    }

    public int getAgent_id() {
        return agent_id;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String userName) {
        this.User_Name = userName;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public double getCharging_Fee() {
        return Charging_Fee;
    }

    public void setCharging_Fee(double charging_Fee) {
        Charging_Fee = charging_Fee;
    }

    public double getRating() {
        return Rating;
    }

    public void setRating(double rating) {
        Rating = rating;
    }

    public double getRate_Number() {
        return Rate_Number;
    }

    public void setRate_Number(double rate_Number) {
        Rate_Number = rate_Number;
    }

    @Override
    public String toString() {
        return "StorageUnitAgent{" +
                "agent_id=" + agent_id +
                ", userName='" + User_Name + '\'' +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Charging_Fee=" + Charging_Fee +
                ", Rating=" + Rating +
                ", Rate_Number=" + Rate_Number +
                '}';
    }
}
