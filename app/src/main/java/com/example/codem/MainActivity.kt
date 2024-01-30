package com.example.codem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codem.ui.theme.fondo



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationController = rememberNavController()

            NavHost(navController = navigationController, startDestination = "pantalla1") {
                composable("pantalla1") { MyApp(navigationController)}
                composable("pantalla2") { MyPantalla2(navigationController) }
                composable("pantalla3") { MyPantalla3(navigationController) }
                composable("pantalla4") { MyPantalla4(navigationController) }
                composable("pantalla5") { MyPantalla5(navigationController) }
            }

        }
    }
}


@Composable
//@Preview(showBackground = true)
fun MyApp(navController: NavHostController) {
    LoginScreen(navController)
}

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(95.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_utad),
            contentDescription = "Logo U-tad",
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(horizontal = 15.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        // Usuario TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Usuario") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 55.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Contraseña TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(autoCorrect = false),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 55.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "¿Has olvidado tu contraseña?",
            modifier = Modifier.clickable { navController.navigate("pantalla2")},
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(100.dp))

        Button(
            onClick = { /* TODO: Add action for login */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 120.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
        ) {
            Text(
                text = "INICIAR SESIÓN",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // "CREAR CUENTA" Button
        OutlinedButton(
            onClick = { navController.navigate("pantalla4") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 120.dp)
                .height(48.dp),
        ) {
            Text(
                text = "CREAR CUENTA",
                color = Color(0xFF0066CC),
                fontSize = 12.sp
            )
        }

    }
}