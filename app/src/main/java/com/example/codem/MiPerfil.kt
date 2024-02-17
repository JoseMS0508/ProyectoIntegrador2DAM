package com.example.codem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.codem.ui.theme.fondo
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.flowlayout.FlowRow


//navController: NavHostController
//navController
@Composable
//@Preview(showBackground = true)
fun MyPantalla11(navController: NavHostController) {
    MyProfile(navController)
}

@Composable
fun MyProfile(navController: NavHostController) {

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
        Spacer(modifier = Modifier.height(20.dp))

        UserProfileImage("")
        datosUsuario()
        Spacer(modifier = Modifier.height(20.dp))
        skillsUsuario()
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


@Composable
fun UserProfileImage(uri: String?) {
    Box(
        modifier = Modifier
            .size(width = 330.dp, height = 150.dp)
            .background(Color(0xFFBCE0FD))
    ) {
        Icon(
            imageVector = Icons.Outlined.Edit,
            contentDescription = "Icono de perfil",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp),
            tint = Color.DarkGray
        )
    }

    Spacer(modifier = Modifier.height(35.dp))
    Text(
        text = "Juan Ruiz",
        fontSize = 24.sp,
        color = Color.Black,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(5.dp))

    Text(
        text = "DAM",
        fontSize = 14.sp,
        color = Color.Black,
        fontWeight = FontWeight.Normal
    )

    Spacer(modifier = Modifier.height(35.dp))

}

@Composable
fun datosUsuario() {
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 120.dp)
            .background(Color.White)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp),
            verticalArrangement = Arrangement.SpaceEvenly, // Esto distribuirá los elementos uniformemente
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Fecha nacimiento:14/08/1999",
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Correo electrónico: J.ruiz@live.u-tad.com",
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = "Estudios: Desarrollo aplicaciones web",
                fontSize = 12.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal
            )
        }
}}

@Composable
fun skillsUsuario() {
    val cardsData = listOf("Block-chain", "IoT", "Ciberseguridad")
    Box(
        modifier = Modifier
            .size(width = 300.dp, height = 115.dp)
            .background(Color.White)
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 25.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "SKILLS",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            FlowRow(
                mainAxisSpacing = 8.dp,
                crossAxisSpacing = 8.dp
            ) {
                cardsData.forEach { tag ->
                    ChipComponent2(tag = tag)
                }
            }
        }}}