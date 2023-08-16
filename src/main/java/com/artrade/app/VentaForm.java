package com.artrade.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class VentaForm extends AppCompatActivity {

    // campos obligatorios a rellenar
    private EditText titulo, autor, precio, imagenes;
    private Spinner corrienteArtistica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_form);

        this.titulo = (EditText) findViewById(R.id.tituloForm);
        this.autor = (EditText) findViewById(R.id.autorForm);
        this.precio = (EditText) findViewById(R.id.precioForm);
        this.imagenes = (EditText) findViewById(R.id.imagenesForm);
        this.corrienteArtistica = (Spinner) findViewById(R.id.corrienteArtistitcaForm);
    }

    public void lanzaMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    /**
     * Guarda la obra introducida en la base de datos
     */
    public void guardaObra(View view){
        if (compruebaCamposObligatorios()) {
            lanzaMenu(view);
        }
    }

    /**
     * Comprueba que los campos obligatorios han sido rellenados
     * Si alguno de ellos no ha sido rellenado, lo notifica indicando el error
     * @return TRUE si no hay errores
     *         FALSE si hay algun campo obligatorio vacio
     */
    private boolean compruebaCamposObligatorios() {
        // extraer el texto introducido en los campos
        String strTitulo = this.titulo.getText().toString();
        String strAutor = this.autor.getText().toString();
        String strPrecio = this.precio.getText().toString();
        String strImagenes = this.imagenes.getText().toString();
        long idCorrienteArtistica = this.corrienteArtistica.getSelectedItemId();

        boolean noExistenErrores = true;    // guarda el valor de retorno del metodo
        // inicializado a TRUE: no existen errores

        // comprueba que todos los campos obligatorios tienen texto
        if (strTitulo.isEmpty()) {
            // ERROR: el usuario no ha introducido el titulo
            titulo.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strAutor.isEmpty()) {
            // ERROR: el usuario no ha introducido el autor
            autor.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strPrecio.isEmpty()) {
            // ERROR: el usuario no ha introducido el precio
            precio.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strImagenes.isEmpty()) {
            // ERROR: el usuario no ha introducido las imagenes
            imagenes.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (idCorrienteArtistica <= 0) {
            // ERROR: el usuario no ha indicado la corriente artistica
            noExistenErrores = false;
        }
        return noExistenErrores;
    }
}