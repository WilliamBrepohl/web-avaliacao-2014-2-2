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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCodigo", query = "SELECT c FROM Categoria c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Categoria.findByDescricao", query = "SELECT c FROM Categoria c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "Categoria.findByValor1Inscricao", query = "SELECT c FROM Categoria c WHERE c.valor1Inscricao = :valor1Inscricao"),
    @NamedQuery(name = "Categoria.findByValor2Inscricao", query = "SELECT c FROM Categoria c WHERE c.valor2Inscricao = :valor2Inscricao"),
    @NamedQuery(name = "Categoria.findByValor1Minicurso", query = "SELECT c FROM Categoria c WHERE c.valor1Minicurso = :valor1Minicurso"),
    @NamedQuery(name = "Categoria.findByValor2Minicurso", query = "SELECT c FROM Categoria c WHERE c.valor2Minicurso = :valor2Minicurso"),
    @NamedQuery(name = "Categoria.findByValor1Visita", query = "SELECT c FROM Categoria c WHERE c.valor1Visita = :valor1Visita"),
    @NamedQuery(name = "Categoria.findByValor2Visita", query = "SELECT c FROM Categoria c WHERE c.valor2Visita = :valor2Visita")})
public class Categoria implements Serializable {
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
    @Column(name = "valor1_inscricao")
    private double valor1Inscricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor2_inscricao")
    private double valor2Inscricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor1_minicurso")
    private double valor1Minicurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor2_minicurso")
    private double valor2Minicurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor1_visita")
    private double valor1Visita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor2_visita")
    private double valor2Visita;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Inscricao> inscricaoList;

    public Categoria() {
    }

    public Categoria(Integer codigo) {
        this.codigo = codigo;
    }

    public Categoria(Integer codigo, String descricao, double valor1Inscricao, double valor2Inscricao, double valor1Minicurso, double valor2Minicurso, double valor1Visita, double valor2Visita) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor1Inscricao = valor1Inscricao;
        this.valor2Inscricao = valor2Inscricao;
        this.valor1Minicurso = valor1Minicurso;
        this.valor2Minicurso = valor2Minicurso;
        this.valor1Visita = valor1Visita;
        this.valor2Visita = valor2Visita;
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

    public double getValor1Inscricao() {
        return valor1Inscricao;
    }

    public void setValor1Inscricao(double valor1Inscricao) {
        this.valor1Inscricao = valor1Inscricao;
    }

    public double getValor2Inscricao() {
        return valor2Inscricao;
    }

    public void setValor2Inscricao(double valor2Inscricao) {
        this.valor2Inscricao = valor2Inscricao;
    }

    public double getValor1Minicurso() {
        return valor1Minicurso;
    }

    public void setValor1Minicurso(double valor1Minicurso) {
        this.valor1Minicurso = valor1Minicurso;
    }

    public double getValor2Minicurso() {
        return valor2Minicurso;
    }

    public void setValor2Minicurso(double valor2Minicurso) {
        this.valor2Minicurso = valor2Minicurso;
    }

    public double getValor1Visita() {
        return valor1Visita;
    }

    public void setValor1Visita(double valor1Visita) {
        this.valor1Visita = valor1Visita;
    }

    public double getValor2Visita() {
        return valor2Visita;
    }

    public void setValor2Visita(double valor2Visita) {
        this.valor2Visita = valor2Visita;
    }

    @XmlTransient
    public List<Inscricao> getInscricaoList() {
        return inscricaoList;
    }

    public void setInscricaoList(List<Inscricao> inscricaoList) {
        this.inscricaoList = inscricaoList;
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "if6ae.entity.Categoria[ codigo=" + codigo + " ]";
    }
    
}
