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
    @Size(max = 25)
    @Column(name = "HandinDate", length = 25)
    private String handinDate;
    @OneToMany(mappedBy = "moduleNr")
    private List<Quiz> quizList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNr")
    private List<Resources> resourcesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNr")
    private List<Handin> handinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduleNr")
    private List<Moduleplan> moduleplanList;

    public Module() {
    }

    public Module(Integer moduleNr) {
        this.moduleNr = moduleNr;
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

    public String getHandinDate() {
        return handinDate;
    }

    public void setHandinDate(String handinDate) {
        this.handinDate = handinDate;
    }

    @XmlTransient
    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    @XmlTransient
    public List<Resources> getResourcesList() {
        return resourcesList;
    }

    public void setResourcesList(List<Resources> resourcesList) {
        this.resourcesList = resourcesList;
    }

    @XmlTransient
    public List<Handin> getHandinList() {
        return handinList;
    }

    public void setHandinList(List<Handin> handinList) {
        this.handinList = handinList;
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
