package com.example.project1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenLayout(viewModel: GoSmartViewModel, onGoNowClicked: () -> Unit) {
    val uiState by viewModel.uiState.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    val topBarColor = Color(0xFF0F471A)
    val cardColor = Color(0xFF2A422B)
    val accentGreen = Color(0xFFBAF455)

    Column(modifier = Modifier.fillMaxSize()) {
        // HEADER
        Box(
            modifier = Modifier.fillMaxWidth().background(topBarColor).padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Column {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    Text("GoSMART", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                    Box(modifier = Modifier.width(24.dp))
                }

                Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Where do you want to go?", color = Color.Gray) },
                        modifier = Modifier.weight(1f).height(56.dp),
                        singleLine = true,
                        colors = TextFieldDefaults.colors(unfocusedContainerColor = Color(0xFF383838), focusedContainerColor = Color(0xFF383838), unfocusedTextColor = Color.White, focusedTextColor = Color.White)
                    )

                    Button(
                        onClick = { if (searchQuery.isNotBlank()) viewModel.updateDestination(searchQuery) },
                        modifier = Modifier.height(56.dp), shape = androidx.compose.ui.graphics.RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = accentGreen),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.Black, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }

        // BODY
        Column(modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp)) {
            // Searched place Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = cardColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Searched Place", color = Color.LightGray, fontSize = 12.sp)

                    Text(text = uiState.destinationName, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("27 KM from here", color = Color.White, fontSize = 14.sp)
                        Text(
                            text = if (uiState.isTrafficClear) "Status : Smooth Transit" else "Status : Congested",
                            color = Color.White, fontSize = 14.sp
                        )
                    }

                    Button(
                        onClick = onGoNowClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = accentGreen),
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Go now", color = Color.Black, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Favourites section
            Row(modifier = Modifier.fillMaxWidth().padding(top = 32.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Favourites", color = Color.LightGray, fontSize = 14.sp)
                Text(text = "Add", color = accentGreen, fontSize = 14.sp)
            }

            // Dummy Favourites List
            FavouriteItem("Wawasan LRT Station")
            FavouriteItem("Masjid Al-Madaniah")
        }
    }
}

@Composable
fun FavouriteItem(name: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.Place, contentDescription = "Location", tint = Color(0xFFBAF455))
        Text(text = name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp).weight(1f))
        Icon(Icons.Default.MoreVert, contentDescription = "More", tint = Color.White)
    }
}