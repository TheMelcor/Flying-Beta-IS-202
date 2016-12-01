/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melcor
 */
@Entity
@Table(name = "calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c"),
    @NamedQuery(name = "Calendar.findById", query = "SELECT c FROM Calendar c WHERE c.id = :id"),
    @NamedQuery(name = "Calendar.findByCalendarTitle", query = "SELECT c FROM Calendar c WHERE c.calendarTitle = :calendarTitle"),
    @NamedQuery(name = "Calendar.findByDescription", query = "SELECT c FROM Calendar c WHERE c.description = :description"),
    @NamedQuery(name = "Calendar.findByCreatedDate", query = "SELECT c FROM Calendar c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Calendar.findByEndDate", query = "SELECT c FROM Calendar c WHERE c.endDate = :endDate"),
    @NamedQuery(name = "Calendar.findByContent", query = "SELECT c FROM Calendar c WHERE c.content = :content")})
public class Calendar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Id", nullable = false, length = 255)
    private String id;
    @Size(max = 50)
    @Column(name = "CalendarTitle", length = 50)
    private String calendarTitle;
    @Size(max = 255)
    @Column(name = "Description", length = 255)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EndDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Size(max = 255)
    @Column(name = "Content", length = 255)
    private String content;
    @JoinColumn(name = "OwnerId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private User ownerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendarId")
    private List<Moduleplan> moduleplanList;

    public Calendar() {
    }

    public Calendar(String id) {
        this.id = id;
    }

    public Calendar(String id, Date createdDate, Date endDate) {
        this.id = id;
        this.createdDate = createdDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCalendarTitle() {
        return calendarTitle;
    }

    public void setCalendarTitle(String calendarTitle) {
        this.calendarTitle = calendarTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(User ownerId) {
        this.ownerId = ownerId;
    }

    @XmlTransient
    public List<Moduleplan> getModuleplanList() {
        return moduleplanList;
    }

    public void setModuleplanList(List<Moduleplan> moduleplanList) {
        this.moduleplanList = moduleplanList;
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
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Calendar[ id=" + id + " ]";
    }
    
}
