package com.example.navegacao;

import static com.example.navegacao.R.id.btCriar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.navegacao.BDHelper.EventosBd;
import com.example.navegacao.model.Eventos;

import java.util.ArrayList;

public class quarta_tela extends AppCompatActivity {

    ListView lista;
    EventosBd bdHelper;
    ArrayList<Eventos> listaEvento;
    Eventos evento;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarta_tela);

        lista = (ListView) findViewById(R.id.listaEvento);


        Button btCriar = findViewById(R.id.btCriar);
        btCriar.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(quarta_tela.this, terceira_tela.class);
                startActivity(intent);


            }
        });
    }


//        protected void onResume () {
//            super.onResume();
//            carregarEvento();
//        }

    public void carregarEvento() {
        bdHelper = new EventosBd(quarta_tela.this);
        listaEvento = bdHelper.getLista();
        bdHelper.close();

        if (listaEvento != null) {
            adapter = new ArrayAdapter<Eventos>(quarta_tela.this, android.R.layout.simple_list_item_1, listaEvento);
            lista.setAdapter(adapter);
        }
    }


////        //finish();
//        }


        public void telatres(View view){
            Intent in = new Intent(quarta_tela.this, terceira_tela.class);
            startActivity(in);
        }
    }



