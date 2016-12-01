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
@Table(name = "evaluation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e"),
    @NamedQuery(name = "Evaluation.findByEvalId", query = "SELECT e FROM Evaluation e WHERE e.evalId = :evalId"),
    @NamedQuery(name = "Evaluation.findByEvalDate", query = "SELECT e FROM Evaluation e WHERE e.evalDate = :evalDate"),
    @NamedQuery(name = "Evaluation.findByEvaluation", query = "SELECT e FROM Evaluation e WHERE e.evaluation = :evaluation")})
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EvalId", nullable = false, length = 255)
    private String evalId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EvalDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date evalDate;
    @Size(max = 10)
    @Column(name = "Evaluation", length = 10)
    private String evaluation;
    @JoinColumn(name = "EvaluatedBy", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private User evaluatedBy;
    @JoinColumn(name = "Handin", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Handin handin;

    public Evaluation() {
    }

    public Evaluation(String evalId) {
        this.evalId = evalId;
    }

    public Evaluation(String evalId, Date evalDate) {
        this.evalId = evalId;
        this.evalDate = evalDate;
    }

    public String getEvalId() {
        return evalId;
    }

    public void setEvalId(String evalId) {
        this.evalId = evalId;
    }

    public Date getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(Date evalDate) {
        this.evalDate = evalDate;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public User getEvaluatedBy() {
        return evaluatedBy;
    }

    public void setEvaluatedBy(User evaluatedBy) {
        this.evaluatedBy = evaluatedBy;
    }

    public Handin getHandin() {
        return handin;
    }

    public void setHandin(Handin handin) {
        this.handin = handin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (evalId != null ? evalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.evalId == null && other.evalId != null) || (this.evalId != null && !this.evalId.equals(other.evalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Evaluation[ evalId=" + evalId + " ]";
    }
    
}
