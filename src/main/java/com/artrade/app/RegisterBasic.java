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

public class RegisterBasic extends AppCompatActivity {

    // Campos obligatorios de rellenar
    private EditText nombre, apellidos, email, contrasenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_basic_info);

        this.nombre = (EditText) findViewById(R.id.nombreForm);
        this.apellidos = (EditText) findViewById(R.id.apellidosForm);
        this.email = (EditText) findViewById(R.id.emailForm);
        this.contrasenha = (EditText) findViewById(R.id.contrasenhaForm);
    }

    /**
     * Lanza la interfaz de login
     */
    public void lanzarLogin(View view) {
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

    /**
     * Lanza el menu principal
     */
    public void lanzarMenu(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    /**
     * Lanza la segunda parte del REGISTRO, en caso de que los campos obligatorios
     * hayan sido rellenados
     */
    public void avanzaRegistro(View view){
        if (compruebaCamposObligatorios()) {
            nextSignInStep(view);
        }
    }
    public void avanzaRegistroNoPopup(View view){
        if (compruebaCamposObligatorios()) {
            Intent intent = new Intent(this, RegisterExtended.class);
            startActivity(intent);
        }
    }

    public void nextSignInStep(View view) {
        Intent intent = new Intent(this, RegisterExtended.class);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.message_register, null);

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
        String strNombre = this.nombre.getText().toString();
        String strApellido = this.apellidos.getText().toString();
        String strEmail = this.email.getText().toString();
        String strContrasenha = this.contrasenha.getText().toString();

        boolean noExistenErrores = true;    // guarda el valor de retorno del metodo
                                            // inicializado a TRUE: no existen errores

        // comprueba que todos los campos obligatorios tienen texto
        if (strNombre.isEmpty()) {
            // ERROR: el usuario no ha introducido el nombre
            nombre.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strApellido.isEmpty()) {
            // ERROR: el usuario no ha introducido el apellido
            apellidos.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strEmail.isEmpty()) {
            // ERROR: el usuario no ha introducido el email
            email.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        if (strContrasenha.isEmpty()) {
            // ERROR: el usuario no ha introducido la contrasenha
            contrasenha.setError("Este campo es obligatorio");
            noExistenErrores = false;
        }
        return noExistenErrores;
    }
}