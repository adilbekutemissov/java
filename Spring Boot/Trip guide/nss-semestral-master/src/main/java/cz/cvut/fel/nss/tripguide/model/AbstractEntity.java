package cz.cvut.fel.nss.tripguide.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The type Abstract entity.
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreationTimestamp
    private LocalDateTime createdat;

    @UpdateTimestamp
    private LocalDateTime updatedat;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets createdat.
     *
     * @return the createdat
     */
    public LocalDateTime getCreatedat() {
        return createdat;
    }

    /**
     * Gets updatedat.
     *
     * @return the updatedat
     */
    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    /**
     * Sets createdat.
     *
     * @param createdat the createdat
     */
    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    /**
     * Sets updatedat.
     *
     * @param updatedat the updatedat
     */
    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

}
