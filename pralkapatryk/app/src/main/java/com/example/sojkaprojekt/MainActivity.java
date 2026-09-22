package com.example.copekprojekt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etNrPrania;
    private Button btnZatwierdz;
    private TextView tvWynikPralka;

    private Button btnOdkurzacz;

    private TextView tvStanOdkurzacza;

    private boolean odkurzaczWlaczony = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etNrPrania = findViewById(R.id.etNrPrania);
        btnZatwierdz = findViewById(R.id.btnZatwierdz);
        tvWynikPralka = findViewById(R.id.tvWynikPralka);

        btnOdkurzacz = findViewById(R.id.btnOdkurzacz);
        tvStanOdkurzacza = findViewById(R.id.tvStanOdkurzacza);


        btnZatwierdz.setOnClickListener(v -> {

            String tekst = etNrPrania.getText().toString().trim();

            if (tekst.isEmpty()) {
                Toast.makeText(
                        MainActivity.this,
                        "Podaj numer prania od 1 do 12",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            try {
                int numerPrania = Integer.parseInt(tekst);

                if (numerPrania >= 1 && numerPrania <= 12) {
                    tvWynikPralka.setText(
                            "Numer prania: " + numerPrania
                    );
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Numer prania musi być od 1 do 12",
                            Toast.LENGTH_SHORT
                    ).show();
                }

            } catch (NumberFormatException e) {
                Toast.makeText(
                        MainActivity.this,
                        "Podaj poprawną liczbę",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });


        btnOdkurzacz.setOnClickListener(v -> {

            if (!odkurzaczWlaczony) {
                odkurzaczWlaczony = true;

                btnOdkurzacz.setText("Wyłącz");
                tvStanOdkurzacza.setText("Odkurzacz włączony");

            } else {
                odkurzaczWlaczony = false;

                btnOdkurzacz.setText("Włącz");
                tvStanOdkurzacza.setText("Odkurzacz wyłączony");
            }
        });
    }
}
