package com.example.userregistrationapp;

//Importações de componentes de ui, inteções e a biblioteca Room
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.room.Room;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ReportActivity extends AppCompatActivity {

    //Campo de texto onde os dados do banco serão exibidos no usages
    private TextView textViewReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Define o layout xml dessa tela de relatorio
        setContentView(R.layout.activity_report);
        //Mapeamneto do textView do xml para o java
        textViewReport = findViewById(R.id.textViewReport);
        //Encontrar o botão e define o clique para voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        //O botao de retorno utilizado expressao lambda
        btnVoltar.setOnClickListener(v -> voltarParaCadastro());

        /*
        Conexão xom o banco de dados
        1 - Criar uma instacia do banco "usar_database"
        2 - .allowMainThreadQueries(): serve para liberar operaçoes de consulta feitas em threads da ui, por padrao, room proibe isso. Ocorreto seria fazer consultas em threads separadas
        */

        UserDatabase db = Room.databaseBuilder(getApplication(), UserDatabase.class, "user_database".allowMainThreadQueries().build());

        //obtem o objeto dao (data acess object) que contem as queries sql
        User.UserDao userDao = db.userDao();
        //recupera todos os usuarios salvos no bd e armazena numa lista
        List<User> userList = userDao.getAllUsers();
        //stringBuilder: forma eficiente de construir uma string longa dentro de um laço (loop)
        StringBuilder report = new StringBuilder();
        //loop "for-each" para percorrer cada objeto user dentro da lista reparada
        for (User user : userList) {
            report.append("Nome: ").append(user.getName()).append("/n").append("CPF: ").append(user.getCpf()).append("/n/n");
        }
        //exibe o relatorio final montada na textview da tela
        textViewReport.setText(report.toString());
    }

    //Metodo responsavel pela navegação entre as telas do app
    public void voltarParaCadastro() {
        //Intenção para abrir a tela de cadastro
        Intent intent = new Intent(ReportActivity.this, MainActivity.class);
        startActivity(intent);
        //Fecha a tela de relatorio para nao acumular na pilha de tarefas
        finish();
    }
}
