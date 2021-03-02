package ge.bestline.studentActivator.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Students {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "stud_id")
    private int studId;

    @Column(name = "type")
    private int type;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "pers_num")
    private String persNum;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "bd_date")
    private java.sql.Date bdDate;

    @Column(name = "sex")
    private int sex;

    @Column(name = "mail")
    private String mail;

    @Column(name = "fac_id")
    private int facId;

    @Column(name = "edu_status")
    private int eduStatus;

    @Column(name = "degree")
    private int degree;

    @Column(name = "speciality_id")
    private int specialityId;

    @Column(name = "unidoc_num")
    private String unidocNum;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "nationality")
    private int nationality;

    @Column(name = "sem_id")
    private int semId;

    @Column(name = "davalianeba")
    private Double davalianeba;

    @Column(name = "currency")
    private int currency;

    @Column(name = "bill")
    private Double bill;

    @Column(name = "rest_prog_bill")
    private int restProgBill;

    @Column(name = "sem_number")
    private int semNumber;

    @Column(name = "group_id")
    private int groupId;

    @Column(name = "sem_changed")
    private int semChanged;

    @Column(name = "comment")
    private String comment;

    @Column(name = "create_date")
    private java.sql.Timestamp createDate;

}
