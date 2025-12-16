package in.kenz.sms.model;

import jakarta.persistence.*;

@Entity
public class UniversityRegistrationNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uniRegNumber;

    public UniversityRegistrationNumber() {
    }

    public UniversityRegistrationNumber(Integer id, String uniRegNumber) {
        this.id = id;
        this.uniRegNumber = uniRegNumber;
    }

    @Override
    public String toString() {
        return "UniversityRegistrationNumber{" +
                "id=" + id +
                ", aadhaarCardNumber='" + uniRegNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniRegNumber() {
        return uniRegNumber;
    }

    public void setUniRegNumber(String uniRegNumber) {
        this.uniRegNumber = uniRegNumber;
    }
}
