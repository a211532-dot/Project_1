package com.example.project1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().background(Color(0xFF0F471A)).padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Menu, "Menu", tint = Color.White)
                Text("GoSMART", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                Box(modifier = Modifier.width(24.dp))
            }
        }

        Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Profile", color = Color.White, fontSize = 20.sp, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Start)

            Spacer(modifier = Modifier.height(32.dp))

            Box(modifier = Modifier.size(100.dp).background(Color.LightGray, CircleShape), contentAlignment = Alignment.Center) {
                Icon(Icons.Default.Person, "Avatar", tint = Color.DarkGray, modifier = Modifier.size(80.dp))
            }

            Text("AMAN BADRUL", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 16.dp, bottom = 32.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF0F471A)),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text("Level 23", color = Color.White, fontSize = 16.sp)

                    Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.weight(1f).height(12.dp).background(Color(0xFF2A422B), RoundedCornerShape(6.dp))) {
                            Box(modifier = Modifier.fillMaxWidth(0.55f).height(12.dp).background(Color(0xFFBAF455), RoundedCornerShape(6.dp)))
                        }
                        Text("55%", color = Color.White, fontSize = 12.sp, modifier = Modifier.padding(start = 8.dp))
                    }

                    Row(modifier = Modifier.padding(top = 24.dp)) {
                        Text("You have saved ", color = Color.White, fontSize = 16.sp)
                        Text("500g CO2", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

