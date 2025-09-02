package com.example.capytur;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView nome, descricao;

    @Override
    protected void onCreate(Bundle AppCompatActivity){
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_details);

     nome = findViewById(R.id.txtNome);
     descricao = findViewById(R.id.txtDescricao);

     nome.setText(getIntent().getStringExtra("nome"));
     descricao.setText(getIntent().getStringExtra("descricao"));
    }

}
