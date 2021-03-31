/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Matheus-PC
 */
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private long valor;
    private long qtdestoque;
    
    @ManyToOne
    private Categoria categoria;

    public Produto(Long id, String descricao, Long valor, Long qtdestoque, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdestoque = qtdestoque;
        this.categoria = categoria;
    }

    public Produto(String descricao, Long valor, Long qtdestoque, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.qtdestoque = qtdestoque;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", qtdestoque=" + qtdestoque + ", categoria=" + categoria + '}';
    }

       

    
    public String getDescricao() {
        return descricao;
    }

    public Produto() {
    }
    

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

   
    
}
