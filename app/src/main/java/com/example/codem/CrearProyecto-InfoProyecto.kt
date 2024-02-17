package com.example.codem


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo


//navController: NavHostController
//navController, navController: NavHostController
@Composable
//@Preview(showBackground = true)
fun MyPantalla6(navController: NavHostController) {
    CreateProjectInfo(navController)
}

@Composable
fun CreateProjectInfo(navController: NavHostController) {
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

        Text(
            "Información del proyecto", style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0066CC)
        )

        Spacer(modifier = Modifier.height(50.dp))

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

        Spacer(modifier = Modifier.height(80.dp))

        Button(
            onClick = { navController.navigate("pantalla7") },
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
    }}