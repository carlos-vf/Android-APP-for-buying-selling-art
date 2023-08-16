package com.artrade.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity {

    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        findViewById(R.id.imageHelp).setClipToOutline(true);

        // Slider
        imageSlider = findViewById(R.id.image_slider);
        ArrayList<SlideModel> images = new ArrayList<>();
        images.add(new SlideModel(R.drawable.guernica, "Guernica\nPablo Picasso", null));
        images.add(new SlideModel(R.drawable.la_noche_estrellada, "La noche estrellada\nVincent van Gogh",null));
        images.add(new SlideModel(R.drawable.la_ultima_cena, "La última cena\nLeonardo da Vinci", null));
        imageSlider.setImageList(images, ScaleTypes.CENTER_CROP);
    }

    public void lanzarLoginPage(View view) {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    public void lanzarAccountDetails(View view) {
        Intent intent = new Intent(this, AccountDetails.class);
        startActivity(intent);
    }

    public void lanzarAccountEdit(View view) {
        Intent intent = new Intent(this, AccountEdit.class);
        startActivity(intent);
    }

    public void lanzarBuscador(View view) {
        Intent intent = new Intent(this, Buscador.class);
        startActivity(intent);
    }

    public void lanzarVenta(View view) {
        Intent intent = new Intent(this, VentaForm.class);
        startActivity(intent);
    }
}