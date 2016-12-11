/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.List;
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
    @Size(max = 25)
    @Column(name = "DeliveryDate", length = 25)
    private String deliveryDate;
    @Size(max = 55)
    @Column(name = "DeliveryStatus", length = 55)
    private String deliveryStatus;
    @Size(max = 255)
    @Column(name = "Content", length = 255)
    private String content;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handin")
    private List<Evaluation> evaluationList;
    @JoinColumn(name = "DeliveredBy", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private User deliveredBy;
    @JoinColumn(name = "ModuleNr", referencedColumnName = "ModuleNr", nullable = false)
    @ManyToOne(optional = false)
    private Module moduleNr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "handin")
    private List<Response> responseList;

    public Handin() {
    }

    public Handin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
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
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
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
    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
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
