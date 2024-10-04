package com.example.Desafio3.dto;

import com.example.Desafio3.entities.Client;
import jakarta.validation.constraints.*;
import org.apache.logging.log4j.message.Message;

import java.util.Date;

public class ClientDTO {
    private Long id;

    @NotBlank(message = "Campo Requerido")
    private String name;
    @NotNull(message = "O CPF não pode ser nulo.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos numéricos.")
    private String cpf;
    @Positive(message = "Deve ser valor maior que zero")
    private Double income;
    @PastOrPresent
    private Date birthDate;
    @Positive(message = "Deve ser positivo ou nulo")
    private Integer children;

    public ClientDTO(){
    }

    public ClientDTO(ClientDTO entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

   public ClientDTO(Client entity){
       this.id = entity.getId();
       this.name = entity.getName();
       this.cpf = entity.getCpf();
       this.income = entity.getIncome();
       this.birthDate = entity.getBirthDate();
       this.children = entity.getChildren();
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
