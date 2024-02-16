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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo

@Composable
//@Preview(showBackground = true)
fun MyPantalla10(navController: NavHostController) {
    AjustesScreen(navController)
}


@Composable
fun AjustesScreen(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_utad_sin_texto),
            contentDescription = "Logo U-tad",
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(horizontal = 15.dp)
                .height(80.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))

        androidx.compose.material3.Text(
            "Ajustes", style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2699FB)
        )

        Spacer(modifier = Modifier.height(50.dp))

        SettingsScreen()

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Cerrar sesión",
            color = Color(0xFF2699FB),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 60.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Eliminar cuenta",
            color = Color(0xFF2699FB),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 60.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))


        Box(
            modifier = Modifier
                .background(Color(0xFF1976D2))
                .height(80.dp)
                .fillMaxWidth(),
            //.padding(horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    bitmap = AppIcons.iconoAjustes,
                    contentDescription = "Subir proyecto",
                    modifier = Modifier
                        .clickable { /* Handle click */ }
                        .size(30.dp)
                )
                Image(
                    bitmap = AppIcons.iconoAjustes,
                    contentDescription = "Subir proyecto",
                    modifier = Modifier
                        .clickable { /* Handle click */ }
                        .size(30.dp)
                )
                Image(
                    bitmap = AppIcons.iconoAjustes,
                    contentDescription = "Subir proyecto",
                    modifier = Modifier
                        .clickable { /* Handle click */ }
                        .size(30.dp)
                )
                Image(
                    bitmap = AppIcons.iconoAñadir,
                    contentDescription = "Subir proyecto",
                    modifier = Modifier
                        .clickable { /* Handle click */ }
                        .size(30.dp)
                )
                Image(
                    bitmap = AppIcons.iconoAjustes,
                    contentDescription = "Ajustes",
                    modifier = Modifier
                        .clickable { /* Handle click */ }
                        .size(30.dp)
                )
            }

        }


    }
}

@Composable
fun SettingsScreen() {
    // Estado para el interruptor de notificaciones
    var notificationsEnabled by remember { mutableStateOf(true) }

    // Estado para el desplegable de idiomas
    var expanded by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("Español") }
    val languages = listOf("Español", "English", "Français")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        // Interruptor para las notificaciones
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, shape = MaterialTheme.shapes.small)
                .padding(horizontal = 25.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Notificaciones", modifier = Modifier.weight(1f), Color(0xFF2699FB), fontSize = 16.sp)
            Switch(
                checked = notificationsEnabled,
                onCheckedChange = { notificationsEnabled = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color(0xFF2699FB),
                    uncheckedThumbColor = Color.Gray,
                    checkedTrackColor = Color(0xFF2699FB).copy(alpha = 0.5f),
                    uncheckedTrackColor = Color.Gray.copy(alpha = 0.5f)
                )
            )
        }

        Spacer(Modifier.height(8.dp))

        // Desplegable para seleccionar el idioma
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.White, shape = MaterialTheme.shapes.small)
                .clickable(onClick = { expanded = true })
                .padding(horizontal = 25.dp, vertical = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(selectedLanguage, modifier = Modifier.weight(1f), Color(0xFF2699FB), fontSize = 16.sp)
            Icon(Icons.Default.ArrowDropDown, contentDescription = "Desplegar", tint = Color(0xFF2699FB))

            // Menú desplegable
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                languages.forEach { language ->
                    DropdownMenuItem(onClick = {
                        selectedLanguage = language
                        expanded = false
                    }) {
                        Text(language)
                    }
                }
            }
        }
    }
}