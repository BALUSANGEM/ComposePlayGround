package com.nosort.myapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Column {
        Button(onClick = {
            navController.navigate("foundation_text")
        }) {
            Text(text = "Foundation")
        }
        Button(onClick = {
            navController.navigate("material3_text")
        }) {
            Text(text = "Material3")
        }
        Button(onClick = {
            navController.navigate("type_writer_text")
        }) {
            Text(text = "Type Writer")
        }
        Spacer(modifier = Modifier.height(16.dp))

    }
}