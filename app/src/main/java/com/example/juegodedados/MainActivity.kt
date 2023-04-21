package com.example.juegodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cantidadDados = findViewById<EditText>(R.id.cantidadDados)
        val cantidadCaras = findViewById<EditText>(R.id.cantidadCaras)
        val tirar = findViewById<Button>(R.id.tirar)
        val resultado = findViewById<TextView>(R.id.resultado)

        tirar.setOnClickListener {
            // Validar campos de cantidad de dados y cantidad de caras
            val cantidadDadosInt = cantidadDados.text.toString().toIntOrNull()
            val cantidadCarasInt = cantidadCaras.text.toString().toIntOrNull()

            if (cantidadDadosInt == null || cantidadCarasInt == null || cantidadDadosInt <= 0 || cantidadCarasInt <= 0) {
                resultado.text = "Ingrese valores válidos en los campos"
            } else {
                // Tirar los dados
                var suma = 0
                var resultados = ""

                for (i in 1..cantidadDadosInt) {
                    val dado = (1..cantidadCarasInt).random()
                    resultados += "$dado "
                    suma += dado
                }

                // Mostrar resultado
                resultado.text = "Resultado dados: $resultados\nEl sumatorio de los dados es: $suma"
            }
        }
    }
}