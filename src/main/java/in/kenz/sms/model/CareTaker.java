package in.kenz.sms.model;

import jakarta.persistence.*;

@Entity
public class CareTaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String careTakerPersonName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student careTakerOfTheStudent;


    public CareTaker() {
    }

    public CareTaker(Integer id, String careTakerPersonName, Student careTakerOfTheStudent) {
        this.id = id;
        this.careTakerPersonName = careTakerPersonName;
        this.careTakerOfTheStudent = careTakerOfTheStudent;
    }

    @Override
    public String toString() {
        return "CareTaker{" +
                "id=" + id +
                ", courseName='" + careTakerPersonName + '\'' +
                ", careTakerOfTheStudent=" + careTakerOfTheStudent +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCareTakerPersonName() {
        return careTakerPersonName;
    }

    public void setCareTakerPersonName(String careTakerPersonName) {
        this.careTakerPersonName = careTakerPersonName;
    }

    public Student getCareTakerOfTheStudent() {
        return careTakerOfTheStudent;
    }

    public void setCareTakerOfTheStudent(Student careTakerOfTheStudent) {
        this.careTakerOfTheStudent = careTakerOfTheStudent;
    }
}
