package ge.bestline.studentActivator.entities;

import javax.persistence.*;

@Entity
@Table(name = "activation_failed_students")
public class ActivationFailedStudents {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "pers_num")
    private String persNum;

    @Column(name = "speciality_id")
    private String specialityId;

    @Column(name = "davalianeba")
    private Double davalianeba;

    @Column(name = "bill")
    private Double bill;

    @Column(name = "currency")
    private Integer currency;

    @Column(name = "request_sent")
    private Integer requestSent;

    @Column(name = "response")
    private String response;

    @Column(name = "status")
    private String status;

    @Column(name = "insert_date", updatable = false, insertable = false)
    private java.sql.Timestamp insertDate;

    @Column(name = "by_job")
    private Integer byJob;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPersNum() {
        return this.persNum;
    }

    public void setPersNum(String persNum) {
        this.persNum = persNum;
    }

    public String getSpecialityId() {
        return this.specialityId;
    }

    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }

    public Double getDavalianeba() {
        return this.davalianeba;
    }

    public void setDavalianeba(Double davalianeba) {
        this.davalianeba = davalianeba;
    }

    public Double getBill() {
        return this.bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Integer getCurrency() {
        return this.currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getRequestSent() {
        return this.requestSent;
    }

    public void setRequestSent(Integer requestSent) {
        this.requestSent = requestSent;
    }

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public java.sql.Timestamp getInsertDate() {
        return this.insertDate;
    }

    public void setInsertDate(java.sql.Timestamp insertDate) {
        this.insertDate = insertDate;
    }

    public Integer getByJob() {
        return this.byJob;
    }

    public void setByJob(Integer byJob) {
        this.byJob = byJob;
    }
}
