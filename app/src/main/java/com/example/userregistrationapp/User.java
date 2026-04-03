package com.example.userregistrationapp;


import androidx.room3.Dao;
import androidx.room3.Entity;
import androidx.room3.Insert;
import androidx.room3.PrimaryKey;
import androidx.room3.Query;

import java.util.List;

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

    //O data access object e o componente que serve para persistencia de dados. Serve para definir as operaçoes que podem sewr feitas no banco dedados com relação a entidade user
    //Importa as notações do room necessario para definir o sao (data Acess Object)
    import androidx.room3.Dao;
    import androidx.room3.Insert;
    import androidx.room3.Query;

    //Importa a classe list do java para retornar uma lista de usuarios
    import java.util.List;

    @Dao
    public interface UserDao {
        //Metodo para inserir um usuario na tabela do BD
        //A anotação @Insert informa a room que este metodo deve ser usado para inserir dado
        @Insert
        void insert(User user);

        //Metodo para buscar todo os usuarios cadastrados no BD
        //A anotação @Query permite definir uma consulta sql personalizada
        @Query("SELECT * FROM user")
        List<User> getAllUsers();
    }


}
