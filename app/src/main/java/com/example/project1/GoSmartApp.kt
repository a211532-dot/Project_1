package com.example.project1

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project1.ui.*

@Composable
fun GoSmartApp(viewModel: GoSmartViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val navController = rememberNavController()
    // Using a dark background to match your design
    val darkBgColor = Color(0xFF132216)

    Scaffold(
        bottomBar = { GoSmartBottomNavigationBar(navController) },
        containerColor = darkBgColor
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(innerPadding).background(darkBgColor)
        ) {
            composable("Home") {
                // Pass the shared viewModel and a navigation action for the "Go now" button
                HomeScreenLayout(
                    viewModel = viewModel,
                    onGoNowClicked = { navController.navigate("Map") }
                )
            }
            composable("Map") {
                TransitDetailScreen(viewModel = viewModel)
            }
            composable("Stations") { StationsScreen() }
            composable("Lines") { LinesScreen() }
            composable("Profile") { ProfileScreen() }
        }
    }
}

@Composable
fun GoSmartBottomNavigationBar(navController: NavHostController) {
    val darkBarColor = Color(0xFF1E3321)
    val activeColor = Color(0xFFBAF455)
    val inactiveColor = Color.White

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(darkBarColor)
            .padding(top = 12.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomNavItem(Icons.Default.Search, "Home", activeColor, navController)
        BottomNavItem(Icons.Default.LocationOn, "Stations", inactiveColor, navController)
        BottomNavItem(Icons.Default.List, "Lines", inactiveColor, navController)
        BottomNavItem(Icons.Default.Person, "Profile", inactiveColor, navController)
    }
}

@Composable
fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String, tint: Color, navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { navController.navigate(label) }
    ) {
        Icon(icon, contentDescription = label, tint = tint, modifier = Modifier.size(24.dp))
        Text(text = label, color = tint, fontSize = 12.sp)
    }
}