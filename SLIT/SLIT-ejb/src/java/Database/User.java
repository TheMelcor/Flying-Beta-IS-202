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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Melcor
 */
@Entity
@Table(name = "user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPasswrd", query = "SELECT u FROM User u WHERE u.passwrd = :passwrd")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private Integer userId;
    @Size(max = 50)
    @Column(name = "FirstName", length = 50)
    private String firstName;
    @Size(max = 50)
    @Column(name = "LastName", length = 50)
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "Email", length = 50)
    private String email;
    @Size(max = 255)
    @Column(name = "Passwrd", length = 255)
    private String passwrd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private List<Calendar> calendarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Quizresults> quizresultsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evaluatedBy")
    private List<Evaluation> evaluationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveredBy")
    private List<Handin> handinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "writtenBy")
    private List<Response> responseList;
    @JoinColumn(name = "UsrRole", referencedColumnName = "RoleId")
    @ManyToOne
    private Usrrole usrRole;

    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrd() {
        return passwrd;
    }

    public void setPasswrd(String passwrd) {
        this.passwrd = passwrd;
    }

    @XmlTransient
    public List<Calendar> getCalendarList() {
        return calendarList;
    }

    public void setCalendarList(List<Calendar> calendarList) {
        this.calendarList = calendarList;
    }

    @XmlTransient
    public List<Quizresults> getQuizresultsList() {
        return quizresultsList;
    }

    public void setQuizresultsList(List<Quizresults> quizresultsList) {
        this.quizresultsList = quizresultsList;
    }

    @XmlTransient
    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    @XmlTransient
    public List<Handin> getHandinList() {
        return handinList;
    }

    public void setHandinList(List<Handin> handinList) {
        this.handinList = handinList;
    }

    @XmlTransient
    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    public Usrrole getUsrRole() {
        return usrRole;
    }

    public void setUsrRole(Usrrole usrRole) {
        this.usrRole = usrRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.User[ userId=" + userId + " ]";
    }
    
}
