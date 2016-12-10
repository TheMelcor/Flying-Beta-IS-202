/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "handin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Handin.findAll", query = "SELECT h FROM Handin h"),
    @NamedQuery(name = "Handin.findById", query = "SELECT h FROM Handin h WHERE h.id = :id"),
    @NamedQuery(name = "Handin.findByDeliveryDate", query = "SELECT h FROM Handin h WHERE h.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Handin.findByDeliveryStatus", query = "SELECT h FROM Handin h WHERE h.deliveryStatus = :deliveryStatus"),
    @NamedQuery(name = "Handin.findByContent", query = "SELECT h FROM Handin h WHERE h.content = :content")})
public class Handin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DeliveryDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Size(max = 55)
    @Column(name = "DeliveryStatus", length = 55)
    private String deliveryStatus;
    @Size(max = 255)
    @Column(name = "Content", length = 255)
    private String content;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handin")
    private Collection<Evaluation> evaluationCollection;
    @JoinColumn(name = "DeliveredBy", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private User deliveredBy;
    @JoinColumn(name = "ModuleNr", referencedColumnName = "ModuleNr", nullable = false)
    @ManyToOne(optional = false)
    private Module moduleNr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handin")
    private Collection<Response> responseCollection;

    public Handin() {
    }

    public Handin(Integer id) {
        this.id = id;
    }

    public Handin(Integer id, Date deliveryDate) {
        this.id = id;
        this.deliveryDate = deliveryDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlTransient
    public Collection<Evaluation> getEvaluationCollection() {
        return evaluationCollection;
    }

    public void setEvaluationCollection(Collection<Evaluation> evaluationCollection) {
        this.evaluationCollection = evaluationCollection;
    }

    public User getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(User deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    public Module getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(Module moduleNr) {
        this.moduleNr = moduleNr;
    }

    @XmlTransient
    public Collection<Response> getResponseCollection() {
        return responseCollection;
    }

    public void setResponseCollection(Collection<Response> responseCollection) {
        this.responseCollection = responseCollection;
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
        if (!(object instanceof Handin)) {
            return false;
        }
        Handin other = (Handin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Handin[ id=" + id + " ]";
    }
    
}
