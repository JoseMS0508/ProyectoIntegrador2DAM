package com.example.codem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo




@Composable
//@Preview(showBackground = true)
fun MyPantalla3(navController: NavHostController) {
    LostPasswordScreen(navController)
}

@Composable
fun LostPasswordScreen(navController: NavHostController) {

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

        Spacer(modifier = Modifier.height(170.dp))


        Text(
            text = "Si el email es correcto, recibirás un correo \n" +
                    "electrónico en breve con las instrucciones \n" +
                    "para restablecer la contraseña.",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 60.dp),
            textAlign = TextAlign.Center
        )


        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate("pantalla1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 135.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
        ) {
            Text(
                text = "IR A LOGIN",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

    }
}