/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Melcor
 */
@Entity
@Table(name = "moduleplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Moduleplan.findAll", query = "SELECT m FROM Moduleplan m"),
    @NamedQuery(name = "Moduleplan.findById", query = "SELECT m FROM Moduleplan m WHERE m.id = :id"),
    @NamedQuery(name = "Moduleplan.findByHandinDate", query = "SELECT m FROM Moduleplan m WHERE m.handinDate = :handinDate")})
public class Moduleplan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Id", nullable = false, length = 255)
    private String id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HandinDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date handinDate;
    @JoinColumn(name = "ModuleNr", referencedColumnName = "ModuleNr", nullable = false)
    @ManyToOne(optional = false)
    private Module moduleNr;
    @JoinColumn(name = "CalendarId", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Calendar calendarId;

    public Moduleplan() {
    }

    public Moduleplan(String id) {
        this.id = id;
    }

    public Moduleplan(String id, Date handinDate) {
        this.id = id;
        this.handinDate = handinDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getHandinDate() {
        return handinDate;
    }

    public void setHandinDate(Date handinDate) {
        this.handinDate = handinDate;
    }

    public Module getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(Module moduleNr) {
        this.moduleNr = moduleNr;
    }

    public Calendar getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(Calendar calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moduleplan)) {
            return false;
        }
        Moduleplan other = (Moduleplan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Moduleplan[ id=" + id + " ]";
    }
    
}
