/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package if6ae.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author William Brepohl
 */
@Embeddable
public class InscricaoMinicursoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_inscricao")
    private int numeroInscricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minicurso")
    private int minicurso;

    public InscricaoMinicursoPK() {
    }

    public InscricaoMinicursoPK(int numeroInscricao, int minicurso) {
        this.numeroInscricao = numeroInscricao;
        this.minicurso = minicurso;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public int getMinicurso() {
        return minicurso;
    }

    public void setMinicurso(int minicurso) {
        this.minicurso = minicurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroInscricao;
        hash += (int) minicurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InscricaoMinicursoPK)) {
            return false;
        }
        InscricaoMinicursoPK other = (InscricaoMinicursoPK) object;
        if (this.numeroInscricao != other.numeroInscricao) {
            return false;
        }
        if (this.minicurso != other.minicurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "if6ae.entity.InscricaoMinicursoPK[ numeroInscricao=" + numeroInscricao + ", minicurso=" + minicurso + " ]";
    }
    
}
