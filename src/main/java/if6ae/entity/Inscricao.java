/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if6ae.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author William Brepohl
 */
@Entity
@Table(name = "inscricao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscricao.findAll", query = "SELECT i FROM Inscricao i"),
    @NamedQuery(name = "Inscricao.findByNumero", query = "SELECT i FROM Inscricao i WHERE i.numero = :numero"),
    @NamedQuery(name = "Inscricao.findByCpf", query = "SELECT i FROM Inscricao i WHERE i.cpf = :cpf"),
    @NamedQuery(name = "Inscricao.findByComplementoCategoria", query = "SELECT i FROM Inscricao i WHERE i.complementoCategoria = :complementoCategoria"),
    @NamedQuery(name = "Inscricao.findByAtuacaoEmpresa", query = "SELECT i FROM Inscricao i WHERE i.atuacaoEmpresa = :atuacaoEmpresa"),
    @NamedQuery(name = "Inscricao.findByNome", query = "SELECT i FROM Inscricao i WHERE i.nome = :nome"),
    @NamedQuery(name = "Inscricao.findByFone", query = "SELECT i FROM Inscricao i WHERE i.fone = :fone"),
    @NamedQuery(name = "Inscricao.findByEmail", query = "SELECT i FROM Inscricao i WHERE i.email = :email"),
    @NamedQuery(name = "Inscricao.findByEndereco", query = "SELECT i FROM Inscricao i WHERE i.endereco = :endereco"),
    @NamedQuery(name = "Inscricao.findByComplemento", query = "SELECT i FROM Inscricao i WHERE i.complemento = :complemento"),
    @NamedQuery(name = "Inscricao.findByBairro", query = "SELECT i FROM Inscricao i WHERE i.bairro = :bairro"),
    @NamedQuery(name = "Inscricao.findByCidade", query = "SELECT i FROM Inscricao i WHERE i.cidade = :cidade"),
    @NamedQuery(name = "Inscricao.findByEstado", query = "SELECT i FROM Inscricao i WHERE i.estado = :estado"),
    @NamedQuery(name = "Inscricao.findByCep", query = "SELECT i FROM Inscricao i WHERE i.cep = :cep"),
    @NamedQuery(name = "Inscricao.findByParticipacao", query = "SELECT i FROM Inscricao i WHERE i.participacao = :participacao"),
    @NamedQuery(name = "Inscricao.findByDataHora", query = "SELECT i FROM Inscricao i WHERE i.dataHora = :dataHora"),
    @NamedQuery(name = "Inscricao.findBySituacao", query = "SELECT i FROM Inscricao i WHERE i.situacao = :situacao")})
public class Inscricao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numero")
    private Integer numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpf")
    private long cpf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "complemento_categoria")
    private String complementoCategoria;
    @Size(max = 50)
    @Column(name = "atuacao_empresa")
    private String atuacaoEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fone")
    private String fone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 20)
    @Column(name = "complemento")
    private String complemento;
    @Size(max = 50)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cep")
    private int cep;
    @Basic(optional = false)
    @NotNull
    @Column(name = "participacao")
    private boolean participacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situacao")
    private int situacao;
    @JoinColumn(name = "categoria", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscricao")
    private List<InscricaoMinicurso> inscricaoMinicursoList;

    public Inscricao() {
    }

    public Inscricao(Integer numero) {
        this.numero = numero;
    }

    public Inscricao(Integer numero, long cpf, String complementoCategoria, String nome, String fone, String email, String endereco, String cidade, String estado, int cep, boolean participacao, Date dataHora, int situacao) {
        this.numero = numero;
        this.cpf = cpf;
        this.complementoCategoria = complementoCategoria;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.participacao = participacao;
        this.dataHora = dataHora;
        this.situacao = situacao;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getComplementoCategoria() {
        return complementoCategoria;
    }

    public void setComplementoCategoria(String complementoCategoria) {
        this.complementoCategoria = complementoCategoria;
    }

    public String getAtuacaoEmpresa() {
        return atuacaoEmpresa;
    }

    public void setAtuacaoEmpresa(String atuacaoEmpresa) {
        this.atuacaoEmpresa = atuacaoEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public boolean getParticipacao() {
        return participacao;
    }

    public void setParticipacao(boolean participacao) {
        this.participacao = participacao;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscricao)) {
            return false;
        }
        Inscricao other = (Inscricao) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "if6ae.entity.Inscricao[ numero=" + numero + " ]";
    }
    
}
