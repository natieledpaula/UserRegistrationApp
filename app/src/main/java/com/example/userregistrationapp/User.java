package com.example.userregistrationapp;


import androidx.room3.Entity;
import androidx.room3.PrimaryKey;

@Entity
public class User {

    //Define o campo 'id' como chave primaria da tabela e configura para ser gerado automaticamente no usages
    @PrimaryKey(autoGenerate = true)
    private int id;

    //Campos que representam as colunas da tabela para armazenar os dados do usuario
    private String name;
    private String cpf;
    private String email;
    private String phone;

    //Construtor da classe que será usado para criar novo objeto
    public User(String name, String cpf, String email, String phone){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phone = phone;
    }

    //Metodo getter e setter para acessar e modificar os dados do objeto user
    //Retorna o id do usuario
    public int getId(){return id;}

    //Define o id do usuario (usando pelo room para preencher automaticamente)
    public void setId(int id) {this.id = id;}
    //Retorna o nome do usuario
    public String getName(){return name;}
    //Retorna o cpf do usuario
    public String getCpf(){return cpf;}
    //Retorna o email do usuario
    public String getEmail(){return email;}
    //Retorna o phone do usuario
    public String getPhone(){return phone;}
}
