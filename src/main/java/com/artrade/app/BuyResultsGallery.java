package com.artrade.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;

public class BuyResultsGallery extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_results_gallery);
    }

    public void lanzaMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void cambiarVista(View view) {
        Intent intent = new Intent(this, BuyResultsGrid.class);
        startActivity(intent);
    }

    public void lanzarBuscador(View view) {
        Intent intent = new Intent(this, Buscador.class);
        startActivity(intent);
    }
}