/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "usrrole")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usrrole.findAll", query = "SELECT u FROM Usrrole u"),
    @NamedQuery(name = "Usrrole.findByRoleId", query = "SELECT u FROM Usrrole u WHERE u.roleId = :roleId"),
    @NamedQuery(name = "Usrrole.findByRoleName", query = "SELECT u FROM Usrrole u WHERE u.roleName = :roleName")})
public class Usrrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RoleId", nullable = false)
    private Integer roleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "RoleName", nullable = false, length = 32)
    private String roleName;
    @OneToMany(mappedBy = "usrRole")
    private Collection<User> userCollection;

    public Usrrole() {
    }

    public Usrrole(Integer roleId) {
        this.roleId = roleId;
    }

    public Usrrole(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usrrole)) {
            return false;
        }
        Usrrole other = (Usrrole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Usrrole[ roleId=" + roleId + " ]";
    }
    
}
