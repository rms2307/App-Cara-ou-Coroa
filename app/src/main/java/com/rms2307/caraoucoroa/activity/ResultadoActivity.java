package com.rms2307.caraoucoroa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.rms2307.caraoucoroa.R;
import com.rms2307.caraoucoroa.util.Logica;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imageCaraCoroa;
    private Button buttonVoltar;
    private Button buttonJogar;
    private int numero;
    Logica l = new Logica();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageCaraCoroa = findViewById(R.id.imageCaraCoroa);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonJogar = findViewById(R.id.buttonJogar2);

        // Recuperar dados
        Bundle dados = getIntent().getExtras();
        numero = dados.getInt("numero");

        caraOuCoroa();

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numero = l.geraNumeroRandomico();
                caraOuCoroa();
                Snackbar.make(
                        view,
                        "JOGADA REALIZADA",
                        Snackbar.LENGTH_LONG
                ).show();
            }
        });

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void caraOuCoroa() {
        if (numero == 0) { // cara
            imageCaraCoroa.setImageResource(R.drawable.moeda_cara);
        } else { // coroa
            imageCaraCoroa.setImageResource(R.drawable.moeda_coroa);
        }
    }
}