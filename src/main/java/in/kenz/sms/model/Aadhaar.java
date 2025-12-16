package in.kenz.sms.model;

import jakarta.persistence.*;

@Entity
public class Aadhaar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long aadhaarNumber;

    @OneToOne(mappedBy = "aadhaar")
    private Student aadhaarOfStudent;

    public Aadhaar() {
    }

    public Aadhaar(Integer id, Long aadhaarNumber, Student aadhaarOfStudent) {
        this.id = id;
        this.aadhaarNumber = aadhaarNumber;
        this.aadhaarOfStudent = aadhaarOfStudent;
    }

    @Override
    public String toString() {
        return "Aadhaar{" +
                "id=" + id +
                ", name='" + aadhaarNumber + '\'' +
                ", cardOfStudent=" + aadhaarOfStudent +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(Long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public Student getAadhaarOfStudent() {
        return aadhaarOfStudent;
    }

    public void setAadhaarOfStudent(Student aadhaarOfStudent) {
        this.aadhaarOfStudent = aadhaarOfStudent;
    }
}
