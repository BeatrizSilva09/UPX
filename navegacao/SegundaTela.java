package com.example.navegacao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaTela extends AppCompatActivity {

    CalendarView calendario;
    TextView data_view;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela);
        Button btLogin = (Button) findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if (login.equals("bia") && senha.equals("123")) {
                    alert("Login realizado com sucesso");
                    telaquatro(view);
                } else {
                    alert("Login ou senha incorreta");
                }

            }
        });
    }


    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

    public void telaquatro(View view) {
        Intent in = new Intent(SegundaTela.this, quarta_tela.class);
        startActivity(in);
    }
}


