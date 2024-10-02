package com.example.Desafio3.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="tb_cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tb_cliente_id")
    private Long id;
    @Column(name="tb_cliente_name")
    private String name;
    @Column(name="tb_cliente_cpf")
    private String cpf;
    @Column(name="tb_cliente_income")
    private Double income;
    @Column(name="tb_cliente_birth_date")
    private Date birthDate;
    @Column(name="tb_cliente_children")
    private Integer children;

    public Client() {
    }

    public Client(Client entity) {
        this.id = entity.getId();
        this.children = entity.getChildren();
        this.birthDate = entity.getBirthDate();
        this.income = entity.getIncome();
        this.cpf = entity.getCpf();
        this.name = entity.getName();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
