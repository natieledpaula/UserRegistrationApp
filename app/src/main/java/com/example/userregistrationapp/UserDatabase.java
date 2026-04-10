package com.example.userregistrationapp;

//importa as anotaçoes e classes da biblioteca room e do android
import android.content.Context;

import androidx.room3.Database; //anotação para marcar a classe como um banco de dados room
import androidx.room3.RoomDatabase; //classe base que representa o bd

@Database(entities = {User.class}, version = 1)
public class UserDatabase {
    //Instancia unica (singleton) do bd
    private static UserDatabase instace;
    //Metodo abstrado que sera implementado pela room
    public abstract UserDao userDao();
    //metodo que retorna a instancia do bd
    // o uso do 'synchronized garante que apenas uma thread possa acessar este metodo por vez, evitando que duas instancias do bd sejam acidentalmente
    public static synchronized UserDatabase getInstace(Context context){
        //Verificar se ja existe umainstacia de bd
        if(instace == null) {
            //cria a instacia do bd usando room
            instace = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "user-database").fallbackToDestrutivegration().allowMainThreadQueries().build();
        }
        return instace;
    }
}
