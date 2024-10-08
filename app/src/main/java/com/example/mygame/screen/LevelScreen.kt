package com.example.mygame.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mygame.R
import com.example.mygame.navhost.NavigationItem
import com.example.mygame.ui.theme.MyGameTheme


@Composable
fun LevelScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Button(onClick = { navController.navigate("quiz/1") }, colors = ButtonDefaults.buttonColors( Color(
                0xFF7F49E0
            )
            )) {
                Image(
                    painter = painterResource(R.drawable.level1),
                    contentDescription = "Level 1 button",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp, 70.dp)
                )
                Text(text = "Level 1")

            }
        }

        Row (modifier = Modifier.padding(0.dp,10.dp)){
            Button(onClick = { navController.navigate("quiz/2") }, colors = ButtonDefaults.buttonColors( Color(
                0xFFE0BA49
            )
            )) {
                Image(
                    painter = painterResource(R.drawable.level1),
                    contentDescription = "Level 2 button",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp, 70.dp)
                )
                Text(text = "Level 2")

            }
        }

        Row (modifier = Modifier.padding(0.dp,10.dp)){
            Button(onClick = { navController.navigate("quiz/3") }, colors = ButtonDefaults.buttonColors( Color(
                0xFFE0BA49
            )
            )) {
                Image(
                    painter = painterResource(R.drawable.level1),
                    contentDescription = "Level 3 button",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp, 70.dp)
                )
                Text(text = "Level 3")

            }
        }

        Row (modifier = Modifier.padding(0.dp,10.dp)){
            Button(onClick = { navController.navigate("record") }, colors = ButtonDefaults.buttonColors( Color(
                0xFFABE049
            )
            )) {
                Text(text = "Record")

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LevelScreenPreview() {
    MyGameTheme {
        NavigationItem.Level
    }
}