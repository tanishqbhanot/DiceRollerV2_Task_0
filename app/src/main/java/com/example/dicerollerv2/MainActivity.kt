package com.example.dicerollerv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerv2.ui.theme.DiceRollerV2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerV2Theme {
                DiceRoller()
            }
        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DiceRoller(modifier: Modifier = Modifier){
    DiceRollerImage()
}

@Composable
fun DiceRollerImage() {
    var count by remember { mutableStateOf(0) }
    val imageResource = when (count) {
        0 -> R.drawable.some
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    val txt = when (count) {
        0 -> "READY?"
        1 -> "1"
        2 -> "2"
        3 -> "3"
        4 -> "4"
        5 -> "5"
        else -> "6"
    }
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = txt,
                color = Color(0xFF85929e),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 32.dp, end = 32.dp),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(imageResource),
                contentDescription = null,
                modifier = Modifier.height(500.dp).width(500.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { count = (1..6).random() }, colors = ButtonColors(
                    Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White
                )
            ) {
                Text("ROLL")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { count = 0 }, colors = ButtonColors(
                    Color.Black,
                    contentColor = Color.White,
                    disabledContainerColor = Color.White,
                    disabledContentColor = Color.White
                )
            ) {
                Text("RESET")
            }
        }
    }
}