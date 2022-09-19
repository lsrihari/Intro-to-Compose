package com.example.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme
import androidx.compose.material.Text as Text



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    //state-hoisting
    var moneyCounter= remember {
        mutableStateOf(0)
    }

    Surface(modifier = Modifier.fillMaxSize(),
        color = Color(0xFF546E7A)) {
        Column( verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$${moneyCounter.value}", style = TextStyle(color =Color.White, fontSize = 30.sp, fontWeight = FontWeight.Bold))
            Spacer(modifier = Modifier.height(30.dp))
                CreateCircle(moneyCounter=moneyCounter.value){newValue->
                    moneyCounter.value=newValue
//                    moneyCounter.value =it+1
                }


        }

    }
}
@Composable
fun  CreateCircle(moneyCounter:Int=0,updateMoneyCounter:(Int)->Unit){

//    var moneyCounter by remember {
//        mutableStateOf(0)
//    }
    Card(modifier = Modifier
        .padding(3.dp)
        .size(105.dp)
        .clickable {
            Log.d("Money-Btn", "CreateCircle: $moneyCounter")
            updateMoneyCounter(moneyCounter+1)
        },
    shape = CircleShape,
    elevation = 20.dp) {
        Box(contentAlignment = Alignment.Center){
            Text(text = "Tap ${moneyCounter}", modifier = Modifier)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IntroToComposeTheme {
        Column {
            MyApp()
        }
    }
}