package ge.bestline.studentActivator.entities;

import javax.persistence.*;

@Entity
@Table(name = "activation_job_config")
public class ActivationJobConfig {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "enabled")
    private Integer enabled;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnabled() {
        return this.enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
