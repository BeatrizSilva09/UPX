package com.example.navegacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.navegacao.BDHelper.EventosBd;
import com.example.navegacao.model.Eventos;

public class terceira_tela extends AppCompatActivity {
    EditText tituloEvento, dataEvento;
    Button btCadastrar;
    Eventos editarEvento, evento;
    EventosBd bdHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira_tela);

        evento = new Eventos();

        bdHelper = new EventosBd(terceira_tela.this);

        Intent intent = getIntent();
        editarEvento = (Eventos) intent.getSerializableExtra("evento escolhido");



        tituloEvento = (EditText) findViewById(R.id.tituloEvento);
        dataEvento= (EditText) findViewById(R.id.dataEvento);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);

        if(editarEvento!=null){
            btCadastrar.setText("Modificar");
        }else{
            btCadastrar.setText("cadastrar");
        }

        btCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                evento.setTituloEvento(tituloEvento.getText().toString());
                evento.setDataEvento(dataEvento.getText().toString());

                if(btCadastrar.getText().toString().equals("Cadastrar")) {
                    bdHelper.salvarEvento(evento);
                    bdHelper.close();
                }else{
                    bdHelper.close();

                }

            }
        });




    }




}