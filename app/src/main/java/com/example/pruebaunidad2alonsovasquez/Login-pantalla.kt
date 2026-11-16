package com.example.pruebaunidad2alonsovasquez

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit, onNavigateToRegister: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if(username.isNotBlank() && password.isNotBlank()) {
                val hashSeguro = password.sha256()

                android.util.Log.d("Hash", "Contraseña sin hash: $password")
                android.util.Log.d("Hash", "Contraseña con hash y la que se va  a almacenar: $hashSeguro")

                onLoginSuccess()
            } else {
                errorMsg = "Llena todos los campos"
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = { onNavigateToRegister() }) {
            Text("Registrarse")
        }

        if (errorMsg.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(errorMsg, color = MaterialTheme.colorScheme.error)
        }
    }
}