package com.example.codem

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo

@Composable
//@Preview(showBackground = true)
fun MyPantalla7(navController: NavHostController) {
    CreateProjectPositions(navController)
}

@Composable
fun CreateProjectPositions(navController: NavHostController) {
    val scrollState = rememberScrollState()
    var puestoSolicitado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo_utad_sin_texto),
            contentDescription = "Logo U-tad",
            modifier = Modifier.fillMaxWidth(0.85f)
                .padding(horizontal = 15.dp)
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text("Puesto/s solicitado/s", style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0066CC)
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Nombre TextField
        OutlinedTextField(
            value = puestoSolicitado,
            onValueChange = { puestoSolicitado = it },
            label = { Text("Descripcion") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 55.dp)
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {  },
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

        Spacer(modifier = Modifier.height(210.dp))

        Button(
            onClick = { navController.navigate("pantalla12") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 120.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0066CC))
        ) {
            Text(
                text = "CONTINUAR",
                color = Color.White,
                fontSize = 12.sp
            )
        }



        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .background(Color(0xFF1976D2))
                .height(80.dp)
                .fillMaxWidth(),
            //.padding(horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Home",
                    modifier = Modifier
                        .clickable { navController.navigate("pantalla8") }
                        .size(40.dp),
                    tint = Color.White
                )
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Add",
                    modifier = Modifier
                        .clickable { navController.navigate("pantalla9") }
                        .size(35.dp),
                    tint = Color.White
                )
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = "Add",
                    modifier = Modifier
                        .clickable { navController.navigate("pantalla6") }
                        .size(35.dp),
                    tint = Color.White
                )
                Icon(
                    imageVector = Icons.Outlined.Person,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable { navController.navigate("pantalla11") }
                        .size(35.dp),
                    tint = Color.White
                )
                Icon(
                    Icons.Outlined.Settings,
                    contentDescription = "Settings",
                    modifier = Modifier
                        .clickable { navController.navigate("pantalla10") }
                        .size(35.dp),
                    tint = Color.White
                )
            }
    }
}
}
