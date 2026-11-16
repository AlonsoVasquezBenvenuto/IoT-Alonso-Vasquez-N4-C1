package com.example.pruebaunidad2alonsovasquez

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    var sensorData by remember {
        mutableStateOf(
            SensorData(temp = 24.5f, hum = 60, suelo = 800, bomba = false, ventilador = false)
        )
    }

    var mostrarTemp by remember { mutableStateOf(true) }
    var mostrarHum by remember { mutableStateOf(true) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Panel de Control", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { mostrarTemp = true; mostrarHum = false },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text("Ver Temperatura", textAlign = TextAlign.Center, fontSize = 12.sp, lineHeight = 14.sp)
            }

            Button(
                onClick = { mostrarTemp = false; mostrarHum = true },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text("Ver Humedad", textAlign = TextAlign.Center, fontSize = 12.sp, lineHeight = 14.sp)
            }

            Button(
                onClick = { mostrarTemp = true; mostrarHum = true },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text("Temperatura y Humedad", textAlign = TextAlign.Center, fontSize = 12.sp, lineHeight = 14.sp, maxLines = 2)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { sensorData = sensorData.copy(bomba = !sensorData.bomba) },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text("Bomba de Agua", textAlign = TextAlign.Center, fontSize = 12.sp, lineHeight = 14.sp, maxLines = 2)
            }

            Button(
                onClick = { sensorData = sensorData.copy(ventilador = !sensorData.ventilador) },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text("Ventilador", textAlign = TextAlign.Center, fontSize = 12.sp, lineHeight = 14.sp)
            }

            Button(
                onClick = { sensorData = sensorData.copy(bomba = true, ventilador = true) },
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = 4.dp, vertical = 8.dp)
            ) {
                Text("Agua y Ventilador", textAlign = TextAlign.Center, fontSize = 12.sp, lineHeight = 14.sp, maxLines = 2)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                if (mostrarTemp) Text("Temperatura: ${sensorData.temp} °C")
                if (mostrarHum) Text("Humedad: ${sensorData.hum} %")
                Text("Bomba: ${if (sensorData.bomba) "ENCENDIDA" else "APAGADA"}")
                Text("Ventilador: ${if (sensorData.ventilador) "ENCENDIDO" else "APAGADO"}")
            }
        }
    }
}