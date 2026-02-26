package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.basitbhatti.compose.library.ui.theme.AppTheme

@Composable
fun HomeScreen(navController: NavHostController) {


    Column(
        modifier = Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp)
    ) {

        Text(text = "Compoe UI Kit")



    }


}


@Preview
@Composable
private fun HomePrev() {

    AppTheme {
        HomeScreen(navController = rememberNavController())
    }

}
