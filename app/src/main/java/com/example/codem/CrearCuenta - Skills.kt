package com.example.codem


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo




@Composable
//@Preview(showBackground = true)
//navController: NavHostController
//navController, navController: NavHostController
fun MyPantalla5(navController: NavHostController) {
    CreateAccountSkills(navController)
}

@Composable
fun CreateAccountSkills(navController: NavHostController) {
    val scrollState = rememberScrollState()
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_utad_sin_texto),
            contentDescription = "Logo U-tad",
            modifier = Modifier.fillMaxWidth(0.85f)
                .padding(horizontal = 15.dp)
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Skills", style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0066CC))

            Spacer(modifier = Modifier.height(40.dp))

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Habilidad") },
                singleLine = true
            )
        }


        Spacer(modifier = Modifier.height(25.dp))

        Button(
            onClick = { /* TODO: Add action for login */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 120.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
        ) {
            Text(
                text = "AÑADIR",
                color = Color.White,
                fontSize = 12.sp
            )
        }



        Spacer(modifier = Modifier.height(190.dp))

        Button(
            onClick = { navController.navigate("pantalla1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 120.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
        ) {
            Text(
                text = "FINALIZAR",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}