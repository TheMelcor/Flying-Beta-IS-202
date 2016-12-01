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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melcor
 */
@Entity
@Table(name = "quiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Quiz.findAll", query = "SELECT q FROM Quiz q"),
    @NamedQuery(name = "Quiz.findByQuizId", query = "SELECT q FROM Quiz q WHERE q.quizId = :quizId"),
    @NamedQuery(name = "Quiz.findByQuizName", query = "SELECT q FROM Quiz q WHERE q.quizName = :quizName")})
public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "QuizId", nullable = false, length = 255)
    private String quizId;
    @Size(max = 255)
    @Column(name = "QuizName", length = 255)
    private String quizName;
    @JoinColumn(name = "ModuleNr", referencedColumnName = "ModuleNr")
    @ManyToOne
    private Module moduleNr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizId")
    private List<Question> questionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quizId")
    private List<Quizresults> quizresultsList;

    public Quiz() {
    }

    public Quiz(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Module getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(Module moduleNr) {
        this.moduleNr = moduleNr;
    }

    @XmlTransient
    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    @XmlTransient
    public List<Quizresults> getQuizresultsList() {
        return quizresultsList;
    }

    public void setQuizresultsList(List<Quizresults> quizresultsList) {
        this.quizresultsList = quizresultsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quizId != null ? quizId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quiz)) {
            return false;
        }
        Quiz other = (Quiz) object;
        if ((this.quizId == null && other.quizId != null) || (this.quizId != null && !this.quizId.equals(other.quizId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Quiz[ quizId=" + quizId + " ]";
    }
    
}
