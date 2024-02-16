package com.example.codem


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.*


//navController: NavHostController
//navController, navController: NavHostController
@Composable
@Preview(showBackground = true)
fun MyPantalla5() {
    CreateProjectInfo()
}

@Composable
fun CreateProjectInfo() {
    val scrollState = rememberScrollState()
    var descripcion by remember { mutableStateOf("") }
    var ubicacion by remember { mutableStateOf("") }
    val presencialidad by remember { mutableStateOf("") }

    //Variables del tabbar
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Tab 1", "Tab 2", "Tab 3")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_utad_sin_texto),
            contentDescription = "Logo U-tad",
            modifier = Modifier.fillMaxWidth(0.85f)
                .padding(horizontal = 15.dp)
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text("Información del proyecto", style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0066CC))

        Spacer(modifier = Modifier.height(80.dp))

        // Nombre TextField
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripcion") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 55.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Nombre TextField
        OutlinedTextField(
            value = ubicacion,
            onValueChange = { ubicacion = it },
            label = { Text("Ubicacion") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 55.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Nombre TextField
        OutlinedTextField(
            value = presencialidad,
            onValueChange = { ubicacion = it },
            label = { Text("Presencial/Telemático") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 55.dp)
        )

        Spacer(modifier = Modifier.height(120.dp))

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 120.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
        ) {
            Text(
                text = "SIGUIENTE",
                color = Color.White,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

    }
}