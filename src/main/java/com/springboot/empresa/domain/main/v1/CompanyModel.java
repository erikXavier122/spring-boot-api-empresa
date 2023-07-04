package com.springboot.empresa.domain.main.v1;


import jakarta.persistence.*;


import java.io.Serializable;

import java.util.UUID;

@Entity
@Table(name = "tb_empresa")
public class CompanyModel implements Serializable {

    private final Long serialVersionUId = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 80)
    private String nome_empresa;

    @Column(unique = true,length = 14)
    private String cnpj;

    @Column(unique = true, length = 8)
    private String cep;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getSerialVersionUId() {
        return serialVersionUId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
