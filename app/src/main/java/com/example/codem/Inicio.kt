package com.example.codem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.codem.ui.theme.fondo
import com.google.accompanist.flowlayout.FlowRow

@Composable
//@Preview(showBackground = true)
fun MyPantalla8(navController: NavHostController) {
    HombreScreen(navController)
}


@Composable
fun HombreScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    val backgroundColor = Color(0xFF1976D2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(fondo),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier =Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.logo_utad_sin_texto),
            contentDescription = "Logo U-tad",
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(horizontal = 15.dp)
                .height(80.dp)
        )
        Spacer(modifier =Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .background(Color(0xFF1976D2))
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(80.dp),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Buscar...") },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(backgroundColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            )
        }
        RecienteYSorting()
        CardList(modifier = Modifier.weight(1f))
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
fun CardList(modifier: Modifier = Modifier) {
    // Dummy data for cards
    val cardsData = listOf(
        Pair("Videojuego E-learning", listOf("Kotlin", "Web", "Ciberseguridad")),
        Pair("Controles de acceso", listOf("Block-chain", "IoT", "Ciberseguridad")),
        Pair("Red social cocineros", listOf("DevOps", "Web", "Ciberseguridad")),
       // Pair("Corto de animación", listOf("3D", "Maya", "Rendering")),
      //  Pair("App inteligencia artificial", listOf("Computer vision", "LLM", "Python")) ,
          //      Pair("App inteligencia artificial", listOf("Computer vision", "LLM", "Python")),
    //Pair("App inteligencia artificial", listOf("Computer vision", "LLM", "Python"))
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 550.dp)
    ) {
        LazyColumn {
            items(cardsData) { card ->
                CustomCard(title = card.first, tags = card.second)
            }
        }
    }
}

@Composable
fun CustomCard(title: String, tags: List<String>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .fillMaxWidth()
            .height(110.dp)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(20.dp))

        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp
        ) {
            tags.forEach { tag ->
                ChipComponent(tag = tag)
            }
        }
    }
}

@Composable
fun ChipComponent(
    tag: String,
    textColor:  Color = Color(0xFF2699FB),
    backgroundColor: Color = Color(0xFFF1F9FF),
    borderColor: Color = Color(0xFFBCE0FD)
) {
    Surface(
        modifier = Modifier
            .border(1.dp, borderColor, RoundedCornerShape(30))
            .padding(1.dp) // Rounded corners with a border
            .clip(RoundedCornerShape(30)),
        color = backgroundColor
    ) {
        Text(
            text = tag,
            color = textColor,
            modifier = Modifier.padding(5.dp),
            style = TextStyle(fontWeight = FontWeight.Normal)
        )
    }
}


@Composable
fun RecienteYSorting() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
            .padding(horizontal = 25.dp),
        verticalAlignment = CenterVertically
    ) {
        Text(
            text = "Recientes",
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.weight(1f),
            color = Color.DarkGray
        )
        Image(
            bitmap = AppIcons.iconoPreferencias,
            contentDescription = "Sort options",
            modifier = Modifier
                .clickable { /* Handle click */ }
                .size(30.dp)
        )
    }
}