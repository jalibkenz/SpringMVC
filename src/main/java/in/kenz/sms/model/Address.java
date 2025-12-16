package in.kenz.sms.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String buildingName;

    public Address() {
    }

    public Address(Integer id, String buildingName) {
        this.id = id;
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", buildingName='" + buildingName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}
