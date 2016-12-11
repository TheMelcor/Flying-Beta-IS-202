/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EvalId", nullable = false)
    private Integer evalId;
    @Size(max = 25)
    @Column(name = "EvalDate", length = 25)
    private String evalDate;
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

    public Evaluation(Integer evalId) {
        this.evalId = evalId;
    }

    public Integer getEvalId() {
        return evalId;
    }

    public void setEvalId(Integer evalId) {
        this.evalId = evalId;
    }

    public String getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(String evalDate) {
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
