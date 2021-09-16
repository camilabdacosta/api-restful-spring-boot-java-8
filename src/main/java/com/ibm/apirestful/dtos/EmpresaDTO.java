package com.ibm.apirestful.dtos;

public class EmpresaDTO {
    private Long id;
    private String razao_social;
    private String cnpj;

    public EmpresaDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotEmpty(message = "Razão social não pode ser vazia")
    @Length(min = 5, maz = 200, message = "Razão social deve conter entre 5 a 200 caracteres")


    public String getrazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    @NotEmpty(message = "CNPJ nao pode ser vazio")
    @CNPJ(message = "CNPJ invalido")
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "EmpresaDTO{" +
                "id=" + id +
                ", razao_social='" + razao_social + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
