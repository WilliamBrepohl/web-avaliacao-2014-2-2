/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if6ae.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author William Brepohl
 */
@Entity
@Table(name = "inscricao_minicurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InscricaoMinicurso.findAll", query = "SELECT i FROM InscricaoMinicurso i"),
    @NamedQuery(name = "InscricaoMinicurso.findByNumeroInscricao", query = "SELECT i FROM InscricaoMinicurso i WHERE i.inscricaoMinicursoPK.numeroInscricao = :numeroInscricao"),
    @NamedQuery(name = "InscricaoMinicurso.findByMinicurso", query = "SELECT i FROM InscricaoMinicurso i WHERE i.inscricaoMinicursoPK.minicurso = :minicurso"),
    @NamedQuery(name = "InscricaoMinicurso.findByDataHora", query = "SELECT i FROM InscricaoMinicurso i WHERE i.dataHora = :dataHora"),
    @NamedQuery(name = "InscricaoMinicurso.findBySituacao", query = "SELECT i FROM InscricaoMinicurso i WHERE i.situacao = :situacao")})
public class InscricaoMinicurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InscricaoMinicursoPK inscricaoMinicursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacao")
    private int situacao;
    @JoinColumn(name = "numero_inscricao", referencedColumnName = "numero", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Inscricao inscricao;
    @JoinColumn(name = "minicurso", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Minicurso minicurso1;

    public InscricaoMinicurso() {
    }

    public InscricaoMinicurso(InscricaoMinicursoPK inscricaoMinicursoPK) {
        this.inscricaoMinicursoPK = inscricaoMinicursoPK;
    }

    public InscricaoMinicurso(InscricaoMinicursoPK inscricaoMinicursoPK, Date dataHora, int situacao) {
        this.inscricaoMinicursoPK = inscricaoMinicursoPK;
        this.dataHora = dataHora;
        this.situacao = situacao;
    }

    public InscricaoMinicurso(int numeroInscricao, int minicurso) {
        this.inscricaoMinicursoPK = new InscricaoMinicursoPK(numeroInscricao, minicurso);
    }

    public InscricaoMinicursoPK getInscricaoMinicursoPK() {
        return inscricaoMinicursoPK;
    }

    public void setInscricaoMinicursoPK(InscricaoMinicursoPK inscricaoMinicursoPK) {
        this.inscricaoMinicursoPK = inscricaoMinicursoPK;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Minicurso getMinicurso1() {
        return minicurso1;
    }

    public void setMinicurso1(Minicurso minicurso1) {
        this.minicurso1 = minicurso1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inscricaoMinicursoPK != null ? inscricaoMinicursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoMinicurso)) {
            return false;
        }
        InscricaoMinicurso other = (InscricaoMinicurso) object;
        if ((this.inscricaoMinicursoPK == null && other.inscricaoMinicursoPK != null) || (this.inscricaoMinicursoPK != null && !this.inscricaoMinicursoPK.equals(other.inscricaoMinicursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "if6ae.entity.InscricaoMinicurso[ inscricaoMinicursoPK=" + inscricaoMinicursoPK + " ]";
    }
    
}
