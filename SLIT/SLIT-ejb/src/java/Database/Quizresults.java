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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Melcor
 */
@Entity
@Table(name = "quizresults")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quizresults.findAll", query = "SELECT q FROM Quizresults q"),
    @NamedQuery(name = "Quizresults.findByResultId", query = "SELECT q FROM Quizresults q WHERE q.resultId = :resultId"),
    @NamedQuery(name = "Quizresults.findByRightAnswers", query = "SELECT q FROM Quizresults q WHERE q.rightAnswers = :rightAnswers"),
    @NamedQuery(name = "Quizresults.findByWrongAnswers", query = "SELECT q FROM Quizresults q WHERE q.wrongAnswers = :wrongAnswers")})
public class Quizresults implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ResultId", nullable = false, length = 255)
    private String resultId;
    @Column(name = "RightAnswers")
    private Integer rightAnswers;
    @Column(name = "WrongAnswers")
    private Integer wrongAnswers;
    @JoinColumn(name = "QuizId", referencedColumnName = "QuizId", nullable = false)
    @ManyToOne(optional = false)
    private Quiz quizId;
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private User userId;

    public Quizresults() {
    }

    public Quizresults(String resultId) {
        this.resultId = resultId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public Integer getRightAnswers() {
        return rightAnswers;
    }

    public void setRightAnswers(Integer rightAnswers) {
        this.rightAnswers = rightAnswers;
    }

    public Integer getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(Integer wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public Quiz getQuizId() {
        return quizId;
    }

    public void setQuizId(Quiz quizId) {
        this.quizId = quizId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultId != null ? resultId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quizresults)) {
            return false;
        }
        Quizresults other = (Quizresults) object;
        if ((this.resultId == null && other.resultId != null) || (this.resultId != null && !this.resultId.equals(other.resultId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Quizresults[ resultId=" + resultId + " ]";
    }
    
}
