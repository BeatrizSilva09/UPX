package com.example.navegacao.BDHelper;

import static android.provider.Settings.System.getString;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.navegacao.model.Eventos;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EventosBd extends SQLiteOpenHelper {

    private static final String DATABASE = "bdeventos";
    private static final int VERSION = 1;

    public EventosBd(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String evento = "CREATE TABLE eventos(id INTENGER PRIMARY KEY AUTOINCREMENT NOT NULL, tituloevento TEXT NOT NULL, dataevento TEXT NOT NULL);";
        db.execSQL(evento);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String evento = "DROP TABLE IF EXISTS eventos";
        db.execSQL(evento);
    }

    // salva
    public void salvarEvento(Eventos evento) {
        ContentValues values = new ContentValues();

        values.put("tituloevento", evento.getTituloEvento());
        values.put("dataEvento", evento.getDataEvento());

        getWritableDatabase().insert("eventos", null, values);
    }

    public ArrayList<Eventos> getLista() {

        String[] columns = {"id", "tituloevento", "dataevento"};
        Cursor cursor = getWritableDatabase().query("eventos", columns, null, null, null, null, null, null);
        ArrayList<Eventos> eventos = new ArrayList<Eventos>();

        while (cursor.moveToNext()) {
            Eventos evento = new Eventos();
            evento.setId(cursor.getLong(0));
            evento.setTituloEvento(cursor.getString(1));
            evento.setDataEvento(cursor.getString(2));

            eventos.add(evento);

        }
        return eventos;

    }
}

