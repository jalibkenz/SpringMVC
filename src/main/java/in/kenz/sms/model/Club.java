package in.kenz.sms.model;

import jakarta.persistence.*;

@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String clubName;

    public Club() {
    }

    public Club(Integer id, String clubName) {
        this.id = id;
        this.clubName = clubName;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", collegeName='" + clubName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }
}
