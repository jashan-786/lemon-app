package com.example.leamonade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.leamonade.ui.theme.LeamonadeTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LeamonadeTheme {
                // A surface container using the 'background' color from the theme
                Lemonade()
            }
        }
    }
}

@Preview
@Composable
fun Lemonade() {
    mainContent(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )


}

@Composable
fun mainContent(modifier: Modifier = Modifier) {

    var desState by remember {
        mutableStateOf(1)
    }

    var res by remember {
        mutableStateOf(1)
    }

    var counter by remember {
   mutableStateOf(0)
    }


    var imageRes= when (res){
        1 -> {
                R.drawable.lemon_tree

        }
        2-> {

                R.drawable.lemon_squeeze
        }
        3-> {

            R.drawable.lemon_drink
        }
        4->{
            R.drawable.lemon_restart
        }
        else -> {
            R.drawable.lemon_tree
        }

    }
    var des= when (desState){
        1 -> R.string.des1
        2-> R.string.des2
        3->R.string.des3
        4->R.string.des4
        else -> R.string.des1

    }


    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(des), fontSize =18.sp)
        Spacer(modifier = Modifier.height(21.dp))

        Image(
            painter = painterResource(id = imageRes as Int),
            contentDescription = "0",
            modifier = Modifier
                .border(
                    BorderStroke(2.dp, Color.Cyan), shape = RoundedCornerShape(
                        CornerSize(10.dp)
                    )
                )
                .padding(24.dp)
                .clickable {


                    if (res == 1 || res == 3) {
                        res += 1
                        desState += 1
                        counter = (2..4).random()

                    } else if (res == 2) {
                     counter--
                        if(counter == 0)
                        {
                            res+=1
                            desState+=1
                        }

                    } else {
                        res = 1
                        desState = 1
                    }

                }


        )

    }


}

