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
@Table(name = "response")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Response.findAll", query = "SELECT r FROM Response r"),
    @NamedQuery(name = "Response.findByRespId", query = "SELECT r FROM Response r WHERE r.respId = :respId"),
    @NamedQuery(name = "Response.findByRespComment", query = "SELECT r FROM Response r WHERE r.respComment = :respComment"),
    @NamedQuery(name = "Response.findByRespDate", query = "SELECT r FROM Response r WHERE r.respDate = :respDate")})
public class Response implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RespId", nullable = false)
    private Integer respId;
    @Size(max = 255)
    @Column(name = "RespComment", length = 255)
    private String respComment;
    @Size(max = 25)
    @Column(name = "RespDate", length = 25)
    private String respDate;
    @JoinColumn(name = "WrittenBy", referencedColumnName = "UserId", nullable = false)
    @ManyToOne(optional = false)
    private User writtenBy;
    @JoinColumn(name = "Handin", referencedColumnName = "Id", nullable = false)
    @ManyToOne(optional = false)
    private Handin handin;

    public Response() {
    }

    public Response(Integer respId) {
        this.respId = respId;
    }

    public Integer getRespId() {
        return respId;
    }

    public void setRespId(Integer respId) {
        this.respId = respId;
    }

    public String getRespComment() {
        return respComment;
    }

    public void setRespComment(String respComment) {
        this.respComment = respComment;
    }

    public String getRespDate() {
        return respDate;
    }

    public void setRespDate(String respDate) {
        this.respDate = respDate;
    }

    public User getWrittenBy() {
        return writtenBy;
    }

    public void setWrittenBy(User writtenBy) {
        this.writtenBy = writtenBy;
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
        hash += (respId != null ? respId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Response)) {
            return false;
        }
        Response other = (Response) object;
        if ((this.respId == null && other.respId != null) || (this.respId != null && !this.respId.equals(other.respId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Database.Response[ respId=" + respId + " ]";
    }
    
}
