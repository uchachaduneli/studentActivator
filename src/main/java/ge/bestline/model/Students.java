package ge.bestline.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class Students {
    private Integer id;
    private String firstname;
    private String lastname;
    private String persNum;
    private int eduStatus;
    private int specialityId;
    private Double davalianeba;
    private int currency;
    private Double bill;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "pers_num")
    public String getPersNum() {
        return persNum;
    }

    public void setPersNum(String persNum) {
        this.persNum = persNum;
    }

    @Basic
    @Column(name = "edu_status")
    public int getEduStatus() {
        return eduStatus;
    }

    public void setEduStatus(int eduStatus) {
        this.eduStatus = eduStatus;
    }

    @Basic
    @Column(name = "speciality_id")
    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    @Basic
    @Column(name = "davalianeba")
    public Double getDavalianeba() {
        return davalianeba;
    }

    public void setDavalianeba(Double davalianeba) {
        this.davalianeba = davalianeba;
    }

    @Basic
    @Column(name = "currency")
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "bill")
    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

}
