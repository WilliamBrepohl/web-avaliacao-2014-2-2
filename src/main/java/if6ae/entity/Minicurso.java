/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if6ae.entity;

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
 * @author William Brepohl
 */
@Entity
@Table(name = "minicurso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Minicurso.findAll", query = "SELECT m FROM Minicurso m"),
    @NamedQuery(name = "Minicurso.findByCodigo", query = "SELECT m FROM Minicurso m WHERE m.codigo = :codigo"),
    @NamedQuery(name = "Minicurso.findByDescricao", query = "SELECT m FROM Minicurso m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "Minicurso.findByMinistrante", query = "SELECT m FROM Minicurso m WHERE m.ministrante = :ministrante"),
    @NamedQuery(name = "Minicurso.findByVagas", query = "SELECT m FROM Minicurso m WHERE m.vagas = :vagas")})
public class Minicurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ministrante")
    private String ministrante;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vagas")
    private int vagas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "minicurso1")
    private List<InscricaoMinicurso> inscricaoMinicursoList;

    public Minicurso() {
    }

    public Minicurso(Integer codigo) {
        this.codigo = codigo;
    }

    public Minicurso(Integer codigo, String descricao, String ministrante, int vagas) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.ministrante = ministrante;
        this.vagas = vagas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMinistrante() {
        return ministrante;
    }

    public void setMinistrante(String ministrante) {
        this.ministrante = ministrante;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    @XmlTransient
    public List<InscricaoMinicurso> getInscricaoMinicursoList() {
        return inscricaoMinicursoList;
    }

    public void setInscricaoMinicursoList(List<InscricaoMinicurso> inscricaoMinicursoList) {
        this.inscricaoMinicursoList = inscricaoMinicursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Minicurso)) {
            return false;
        }
        Minicurso other = (Minicurso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "if6ae.entity.Minicurso[ codigo=" + codigo + " ]";
    }
    
}
