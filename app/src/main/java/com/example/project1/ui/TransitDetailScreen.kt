package com.example.project1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.example.project1.R

@Composable
fun TransitDetailScreen(viewModel: GoSmartViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    val cardColor = Color(0xFF0F471A)

    Column(modifier = Modifier.fillMaxSize()) {
        // Placeholder for the Map Image
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f).background(Color(0xFFD6DFEB)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.maps), // Your image name here
                contentDescription = "Destination Map",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // This makes the map fill the whole area
            )
        }

        // Green Bottom Sheet Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = cardColor),
            shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Place, contentDescription = "Place", tint = Color.White, modifier = Modifier.size(32.dp))
                    Text(text = uiState.destinationName, color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 8.dp))
                }

                Text(
                    text = "MRT Station Pasar Seni  >  LRT Station Pasar Seni  >  LRT Station Wawasan",
                    color = Color(0xFFBAF455), fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
                )

                Text("Update Status", color = Color.Gray, fontSize = 14.sp)

                // Congestion Toggle
                Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Station Congestion", color = Color.White, fontWeight = FontWeight.Bold)
                    Switch(
                        checked = !uiState.isTrafficClear,
                        onCheckedChange = { viewModel.updateTrafficStatus(!it) },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFFBAF455))
                    )
                }

                // Smooth Transit Toggle
                Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Smooth Transit", color = Color.White, fontWeight = FontWeight.Bold)
                    Switch(
                        checked = uiState.isTrafficClear,
                        onCheckedChange = { viewModel.updateTrafficStatus(it) },
                        colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFFBAF455))
                    )
                }
            }
        }
    }
}