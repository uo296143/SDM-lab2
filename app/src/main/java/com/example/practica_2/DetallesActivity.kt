package com.example.practica_2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetallesActivity : AppCompatActivity() {

    private lateinit var textViewNombre : TextView
    private lateinit var textViewEmail : TextView
    private lateinit var textViewPromociones : TextView
    private lateinit var botonVolver : Button

    companion object{
        const val CLAVE_NOMBRE : String = textViewNombre
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalles)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        iniciarElementos()
        escribirValoresActivityAnterior()
        listenerBotonVolver()
    }

    private fun iniciarElementos(){

        botonVolver= findViewById(R.id.button)
        textViewNombre = findViewById(R.id.textViewNombre)
        textViewEmail = findViewById(R.id.textViewEmail)
        textViewPromociones = findViewById(R.id.textViewPromociones)

    }

    private fun escribirValoresActivityAnterior(){
        val nombre = intent.getStringExtra("nombre")
        val email = intent.getStringExtra("email")
        val promociones = intent.getBooleanExtra("promociones", false)

        textViewNombre.text = nombre
        textViewEmail.setText(email)
        textViewPromociones.text = (if (promociones==true) "Aceptó promociones" else "No aceptó promociones")


    }

    private fun listenerBotonVolver(){
        botonVolver.setOnClickListener(){
            finish()
        }
    }
}