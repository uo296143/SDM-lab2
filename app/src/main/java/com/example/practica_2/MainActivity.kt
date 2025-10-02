package com.example.practica_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var buttonMostrarTexto : Button
    private lateinit var textView : TextView
    private lateinit var textNombre : EditText
    private lateinit var textEmail : EditText
    private lateinit var checkBox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        iniciarElementos();
    }

    private fun iniciarElementos(){
        buttonMostrarTexto = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textNombre = findViewById(R.id.nombre)
        textEmail = findViewById(R.id.email)
        checkBox = findViewById(R.id.checkBox)
        buttonMostrarTexto.setOnClickListener() {
                mostrarTexto()
                lanzarNuevaActivity();
        }
    }

    private fun mostrarTexto(){
        textView.setText("Nombre : ${textNombre.text}\nEmail : ${textEmail.text}\nEstado del chekBox : ${checkBox.isChecked}")
    }

    private fun lanzarNuevaActivity(){
        val intent = Intent(applicationContext, DetallesActivity::class.java)
        intent.putExtra("nombre", textNombre.text.toString())
        intent.putExtra("email", textEmail.text.toString())
        intent.putExtra("promociones", checkBox.isChecked)
        startActivity(intent)
    }
}