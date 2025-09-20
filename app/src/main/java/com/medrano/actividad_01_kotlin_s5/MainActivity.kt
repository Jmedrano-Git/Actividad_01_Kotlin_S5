package com.medrano.actividad_01_kotlin_s5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Label
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.medrano.actividad_01_kotlin_s5.ui.theme.Actividad_01_Kotlin_S5Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        }
    }
}

@Composable
fun RegistroRapido() {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var subscrito by remember { mutableStateOf(false) }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text("Registro Rápido",
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "NOMBRE")
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it},
            placeholder = { Text("Ingresa tu nombre")},
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "CORREO")
        Spacer(modifier = Modifier.height(5.dp))
        TextField(
            value = correo,
            onValueChange = {correo = it},
            placeholder = { Text("ejemplo123@gmail.com")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(" 🗒️ Subscribirme al boletín",
                modifier = Modifier.weight(1f))
            Switch(checked = subscrito,
                onCheckedChange = { subscrito = it})
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                resultado = "Nombre: $nombre\nCorreo: $correo\nSubscrito: ${if (subscrito) "Sí" else "No"}"
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Registrar")
        }

        Spacer(Modifier.height(16.dp))

        Text(
            text = "RESULTADO: \n$resultado",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEDE7F6))
                .border(2.dp, Color(0xFF6200EA))
                .padding(8.dp)
        )


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    registroRapido()
}