package com.example.project1.ui


import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
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
fun LinesScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().background(Color(0xFF0F471A)).padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)) {
            Column {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Menu, "Menu", tint = Color.White)
                    Text("GoSMART", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                    Box(modifier = Modifier.width(24.dp))
                }
                Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp)) {
                    TextField(value = "", onValueChange = {}, placeholder = { Text("Search Lines", color = Color.Gray) }, modifier = Modifier.weight(1f).height(56.dp), colors = TextFieldDefaults.colors(unfocusedContainerColor = Color(0xFF383838)))
                    Button(onClick = {}, modifier = Modifier.height(56.dp), shape = androidx.compose.ui.graphics.RectangleShape, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBAF455)), contentPadding = PaddingValues(0.dp)) {
                        Icon(Icons.Default.Search, "Search", tint = Color.Black)
                    }
                }
            }
        }
        Column(modifier = Modifier.padding(16.dp)) {
            LineListItem("LRT Laluan Kelana Jaya")
            LineListItem("LRT Laluan Ampang")
            LineListItem("MRT Laluan Kajang")
        }
    }
}

@Composable
fun LineListItem(name: String) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(Icons.Default.List, "Line", tint = Color(0xFFBAF455))
        Text(name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 16.dp).weight(1f))
        Icon(Icons.Default.MoreVert, "More", tint = Color.White)
    }
}