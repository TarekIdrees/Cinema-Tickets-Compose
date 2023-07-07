package com.example

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.cinematickets.ui.theme.CinemaTicketsTheme
import com.example.navigation.CinemaTicketsNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaTicketsApp() {
    CinemaTicketsTheme() {
        Scaffold {
            val navController = rememberNavController()
            CinemaTicketsNavGraph(navController = navController)
        }
    }
}