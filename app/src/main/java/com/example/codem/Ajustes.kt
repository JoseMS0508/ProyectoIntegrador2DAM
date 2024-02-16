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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codem.ui.theme.fondo

@Composable
@Preview(showBackground = true)
fun MyPantalla10() {
    AjustesScreen()
}


@Composable
fun AjustesScreen() {

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
        Spacer(modifier = Modifier.height(10.dp))


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