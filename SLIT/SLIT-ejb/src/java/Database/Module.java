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
import javax.persistence.Id;
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
@Table(name = "module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Module.findAll", query = "SELECT m FROM Module m"),
    @NamedQuery(name = "Module.findByModuleNr", query = "SELECT m FROM Module m WHERE m.moduleNr = :moduleNr"),
    @NamedQuery(name = "Module.findByModuleName", query = "SELECT m FROM Module m WHERE m.moduleName = :moduleName"),
    @NamedQuery(name = "Module.findByModuleDesc", query = "SELECT m FROM Module m WHERE m.moduleDesc = :moduleDesc"),
    @NamedQuery(name = "Module.findByModuleGoal", query = "SELECT m FROM Module m WHERE m.moduleGoal = :moduleGoal"),
    @NamedQuery(name = "Module.findByHandinDate", query = "SELECT m FROM Module m WHERE m.handinDate = :handinDate")})
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ModuleNr", nullable = false)
    private Integer moduleNr;
    @Size(max = 255)
    @Column(name = "ModuleName", length = 255)
    private String moduleName;
    @Size(max = 255)
    @Column(name = "ModuleDesc", length = 255)
    private String moduleDesc;
    @Size(max = 255)
    @Column(name = "ModuleGoal", length = 255)
    private String moduleGoal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HandinDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date handinDate;
    @OneToMany(mappedBy = "moduleNr")
    private Collection<Quiz> quizCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNr")
    private Collection<Resources> resourcesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNr")
    private Collection<Handin> handinCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNr")
    private Collection<Moduleplan> moduleplanCollection;

    public Module() {
    }

    public Module(Integer moduleNr) {
        this.moduleNr = moduleNr;
    }

    public Module(Integer moduleNr, Date handinDate) {
        this.moduleNr = moduleNr;
        this.handinDate = handinDate;
    }

    public Integer getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(Integer moduleNr) {
        this.moduleNr = moduleNr;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getModuleGoal() {
        return moduleGoal;
    }

    public void setModuleGoal(String moduleGoal) {
        this.moduleGoal = moduleGoal;
    }

    public Date getHandinDate() {
        return handinDate;
    }

    public void setHandinDate(Date handinDate) {
        this.handinDate = handinDate;
    }

    @XmlTransient
    public Collection<Quiz> getQuizCollection() {
        return quizCollection;
    }

    public void setQuizCollection(Collection<Quiz> quizCollection) {
        this.quizCollection = quizCollection;
    }

    @XmlTransient
    public Collection<Resources> getResourcesCollection() {
        return resourcesCollection;
    }

    public void setResourcesCollection(Collection<Resources> resourcesCollection) {
        this.resourcesCollection = resourcesCollection;
    }

    @XmlTransient
    public Collection<Handin> getHandinCollection() {
        return handinCollection;
    }

    public void setHandinCollection(Collection<Handin> handinCollection) {
        this.handinCollection = handinCollection;
    }

    @XmlTransient
    public Collection<Moduleplan> getModuleplanCollection() {
        return moduleplanCollection;
    }

    public void setModuleplanCollection(Collection<Moduleplan> moduleplanCollection) {
        this.moduleplanCollection = moduleplanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleNr != null ? moduleNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Module)) {
            return false;
        }
        Module other = (Module) object;
        if ((this.moduleNr == null && other.moduleNr != null) || (this.moduleNr != null && !this.moduleNr.equals(other.moduleNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Module[ moduleNr=" + moduleNr + " ]";
    }
    
}
