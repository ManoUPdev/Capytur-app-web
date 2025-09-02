package com.example.capytur;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<PontoTuristico> pontos;
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaPontos);
        pontos = new ArrayList<>();
        pontos.add(new PontoTuristico("Praia Central","Praia linda com quiosques e esportes."));
        pontos.add(new PontoTuristico("Museu Historico", "Museu com acervo da cidade"));
        pontos.add(new PontoTuristico("Parque Natural", "Trilhas e contanto com a natureza."));

        ArrayList<String> nomes = new ArrayList<>();
        for(PontoTuristico p : pontos) nomes.add(p.getNome());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomes);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("nome,", pontos.get(i).getNome());
                intent.putExtra("descricao", pontos.get(i).getDescricao()));
                startActivity(intent);
            }
        });
    }
}
