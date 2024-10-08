package com.example.mygame.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.mygame.R
import com.example.mygame.model.Quiz
import com.example.mygame.navhost.NavigationItem
import com.example.mygame.ui.theme.MyGameTheme




@Composable
fun QuizScreen(navController: NavHostController, quizlevel: String) {
    val quiz = remember {
        Quiz()
    }

    val level = remember {
        mutableIntStateOf(quizlevel.toInt())
    }
    val currentQuestion = remember {
        mutableStateOf(quiz.createQuiz(level.intValue))
    }
    val score = remember {
        mutableIntStateOf(0)
    }
    val quesNum = remember {
        mutableIntStateOf(1)
    }
    val limit = remember {
        mutableIntStateOf(10)
    }
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.FillBounds
                )
        }) {
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                val height = 30.dp
                val width = 30.dp
                Image(
                    modifier = Modifier
                        .width(width)
                        .height(height),
                    painter = painterResource(id = R.drawable.coin),
                    contentDescription = "coin"
                )
                Text(
                    text = "${score.intValue}",
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Row {

                Button(onClick = { /*TODO*/ }){
                    Text(
                        text = "Questions : ${quesNum.intValue}/${limit.intValue}",
                        fontWeight = FontWeight.Medium)
                }

            }
        }
        Row {
            Text(
                text = currentQuestion.value,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

        }


        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                if (quiz.checkAnswer("+")) {
                    score.intValue++
                }
                currentQuestion.value = quiz.createQuiz(level.intValue)
                quesNum.intValue++

            }) {
                Text(
                    text = "+",
                    modifier = Modifier.padding(13.dp),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

            }
        }
        if (level.intValue != 1) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(), Arrangement.SpaceBetween
            ) {
                Button(onClick = {
                    if (quiz.checkAnswer("*")) {
                        score.intValue++
                    }
                    currentQuestion.value = quiz.createQuiz(level.intValue)
                    quesNum.intValue++
                }) {
                    Text(
                        text = "*",
                        modifier = Modifier.padding(13.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                }

                Button(onClick = {
                    if (quiz.checkAnswer("/")) {
                        score.intValue++
                    }
                    currentQuestion.value = quiz.createQuiz(level.intValue)
                    quesNum.intValue++
                }) {
                    Text(
                        text = "/",
                        modifier = Modifier.padding(13.dp),
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                if (quiz.checkAnswer("-")) {
                    score.intValue++
                }
                currentQuestion.value = quiz.createQuiz(level.intValue)
                quesNum.intValue++
            }) {
                Text(
                    text = "-",
                    modifier = Modifier.padding(13.dp),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

            }
        }
//        Row {
//            if (score.intValue != 0 && score.intValue % 10 == 0){
//                DialogWithImage(
//                    onConfirmation = { /*TODO*/ },
//                    imageDescription = "Perfect"
//                )
//            }
//        }

        Spacer(modifier = Modifier.padding(20.dp))

        Row {
            Button(onClick = { navController.navigate("record") }) {
                Text(text = "END THE GAME")
            }
        }


    }
}

//@Composable
//fun DialogWithImage(
//    onConfirmation: () -> Unit,
//    imageDescription: String,
//) {
//    Dialog(onConfirmation) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(375.dp)
//                .padding(16.dp),
//            shape = RoundedCornerShape(16.dp),
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.coin),
//                    contentDescription = imageDescription,
//                    contentScale = ContentScale.Fit,
//                    modifier = Modifier
//                        .height(160.dp)
//                )
//                Text(
//                    text = "PERFECT!",
//                    modifier = Modifier.padding(16.dp),
//                )
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth(),
//                    horizontalArrangement = Arrangement.Center,
//                ) {
//
//                    TextButton(
//                        onClick = { onConfirmation() },
//                        modifier = Modifier.padding(8.dp),
//                    ) {
//                        Text("Okay")
//                    }
//                }
//            }
//        }
//    }
//}







@Preview(showBackground = true)
@Composable
fun QuizScreenPreview() {
    MyGameTheme {
        NavigationItem.Quiz
    }
}