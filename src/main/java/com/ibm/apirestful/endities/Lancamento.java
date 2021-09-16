package com.ibm.apirestful.endities;

import com.ibm.apirestful.enums.TipoEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
    private static  final long serialVersionUID = -7520146237713345648L;

    private Long id;
    private Date data;
    private  String descricao;
    private  String localizacao;
    private  Date dataCriacao;
    private  Date dataAtualizacao;
    private TipoEnum tipo;
    private Funcionario funcionario;

    public Lancamento(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //Valor da data e da hora no bd
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data",nullable = false)
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    @Column(name = "descricao",nullable = true)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Column(name = "localizacao",nullable = true)
    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    @Column(name = "data_criacao",nullable = false)
    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    @Column(name = "data_atualizacao",nullable = false)
    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo",nullable = false)
    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    private Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    //Atualizando
    @PreUpdate
    public void preUpdate (){
        dataAtualizacao = new Date();
    }
    //Inserindo um elemento
    @PrePersist
    public void prePersist(){
        final Date atual = new Date();
        dataCriacao = atual;
        dataAtualizacao = atual;
    }

}
