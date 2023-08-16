package com.artrade.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterExtended extends AppCompatActivity {
    // Atributos
    EditText direccion, localidad, postal, provincia, pais, cuentaBancaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_extended);

        this.direccion = (EditText) findViewById(R.id.direccionForm);
        this.localidad = (EditText) findViewById(R.id.localidadForm);
        this.postal = (EditText) findViewById(R.id.cpForm);
        this.provincia = (EditText) findViewById(R.id.provinciaForm);
        this.pais = (EditText) findViewById(R.id.paisForm);
        this.cuentaBancaria = (EditText) findViewById(R.id.cuentaBancariaForm);
    }

    /**
     * Lanza la primera parte del proceso de REGISTRO
     */
    public void lanzarRegistroBasico(View view) {
        Intent intent = new Intent(this, RegisterBasic.class);
        startActivity(intent);
    }

    /**
     * Lanza el menu principal, en caso de que los campos obligatorios
     * hayan sido rellenados
     */
    public void terminaRegistro(View view){
        if (compruebaCamposObligatorios()) {
            nextSignInStep(view);
        }
    }

    public void nextSignInStep(View view) {
        Intent intent = new Intent(this, MainMenu.class);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.message_register_finish, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        boolean focusable = false; // doesnt let taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, 0, 0);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                popupWindow.dismiss();
                startActivity(intent);
            }
        }, 1000);
    }

    /**
     * Comprueba que los campos obligatorios han sido rellenados
     * Si alguno de ellos no ha sido rellenado, lo notifica indicando el error
     * @return TRUE si no hay errores
     *         FALSE si hay algun campo obligatorio vacio
     */
    private boolean compruebaCamposObligatorios() {
        // extraer el texto introducido en los campos
        String strDireccion = this.direccion.getText().toString();
        String strLocalidad = this.localidad.getText().toString();
        String strPostal = this.postal.getText().toString();
        String strProvincia = this.provincia.getText().toString();
        String strPais = this.pais.getText().toString();
        String strCuentaBancaria = this.cuentaBancaria.getText().toString();

        boolean noExistenErrores = true;    // guarda el valor de retorno del metodo
                                            // inicializado a TRUE: no existen errores

        // comprueba que todos los campos obligatorios tienen texto
        if (strDireccion.isEmpty()) {
            // ERROR: el usuario no ha introducido la direccion
            direccion.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strLocalidad.isEmpty()) {
            // ERROR: el usuario no ha introducido la localidad
            localidad.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strPostal.isEmpty()) {
            // ERROR: el usuario no ha introducido el codigo postal
            postal.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strProvincia.isEmpty()) {
            // ERROR: el usuario no ha introducido la provincia
            provincia.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strPais.isEmpty()) {
            // ERROR: el usuario no ha introducido el pais
            pais.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strCuentaBancaria.isEmpty()) {
            // ERROR: el usuario no ha introducido la cuenta bancaria
            cuentaBancaria.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        return noExistenErrores;
    }
}