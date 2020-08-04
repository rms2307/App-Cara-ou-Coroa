package com.rms2307.caraoucoroa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rms2307.caraoucoroa.R;
import com.rms2307.caraoucoroa.util.Logica;

public class MainActivity extends AppCompatActivity {

    private Button buttonJogar;
    Logica l = new Logica();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonJogar = findViewById(R.id.buttonJogar);

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);

                //Passar número para próxima tela
                int numero = l.geraNumeroRandomico();
                intent.putExtra("numero", numero);

                startActivity(intent);
            }
        });
    }
}