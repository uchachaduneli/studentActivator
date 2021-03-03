package ge.bestline.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "activation_failed_students", schema = "ciufinance")
public class ActivationFailedStudents {
    private Integer id;
    private String firstname;
    private String lastname;
    private String persNum;
    private String specialityId;
    private Double davalianeba;
    private Double bill;
    private int currency;
    private int requestSent;
    private String response;
    private String status;
    private Timestamp insertDate;
    private int byJob;

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
    @Column(name = "speciality_id")
    public String getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String specialityId) {
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
    @Column(name = "bill")
    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
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
    @Column(name = "request_sent")
    public int getRequestSent() {
        return requestSent;
    }

    public void setRequestSent(int requestSent) {
        this.requestSent = requestSent;
    }

    @Basic
    @Column(name = "response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "insert_date", insertable = false, updatable = false)
    public Timestamp getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    @Basic
    @Column(name = "by_job")
    public int getByJob() {
        return byJob;
    }

    public void setByJob(int byJob) {
        this.byJob = byJob;
    }

}
