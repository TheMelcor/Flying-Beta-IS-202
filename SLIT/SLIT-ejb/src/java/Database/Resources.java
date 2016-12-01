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
@Table(name = "resources")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resources.findAll", query = "SELECT r FROM Resources r"),
    @NamedQuery(name = "Resources.findByResourceId", query = "SELECT r FROM Resources r WHERE r.resourceId = :resourceId"),
    @NamedQuery(name = "Resources.findByContent", query = "SELECT r FROM Resources r WHERE r.content = :content"),
    @NamedQuery(name = "Resources.findByResourceType", query = "SELECT r FROM Resources r WHERE r.resourceType = :resourceType")})
public class Resources implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ResourceId", nullable = false, length = 255)
    private String resourceId;
    @Size(max = 255)
    @Column(name = "Content", length = 255)
    private String content;
    @Size(max = 255)
    @Column(name = "ResourceType", length = 255)
    private String resourceType;
    @JoinColumn(name = "ModuleNr", referencedColumnName = "ModuleNr", nullable = false)
    @ManyToOne(optional = false)
    private Module moduleNr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceId")
    private List<Files> filesList;

    public Resources() {
    }

    public Resources(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Module getModuleNr() {
        return moduleNr;
    }

    public void setModuleNr(Module moduleNr) {
        this.moduleNr = moduleNr;
    }

    @XmlTransient
    public List<Files> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<Files> filesList) {
        this.filesList = filesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceId != null ? resourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resources)) {
            return false;
        }
        Resources other = (Resources) object;
        if ((this.resourceId == null && other.resourceId != null) || (this.resourceId != null && !this.resourceId.equals(other.resourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Resources[ resourceId=" + resourceId + " ]";
    }
    
}
