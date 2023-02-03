package com.example.spaceartapp

import android.os.Bundle
import android.service.autofill.Validators.and
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spaceartapp.ui.theme.SpaceArtAppTheme

private const val TAG= "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceArtAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Buss()
                }
            }
        }
    }
}


@Preview
@Composable
fun Buss() {
    var pictureNumber by remember {
        mutableStateOf(0)
    }

    var imageRes: Int
    var stringTitleRes: Int
    var stringAuthorRes: Int
    var stringAuthorRes2: Int

            imageRes = R.drawable.and
            stringTitleRes = R.string.name
            stringAuthorRes = R.string.link
             stringAuthorRes2 = R.string.contact



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ImageCard(imageRes)

        Spacer(modifier = Modifier.height(30.dp))

        TextCard(stringTitleRes,stringAuthorRes,stringAuthorRes2)

        Spacer(modifier = Modifier.height(15.dp))

        Row() {
            TextCard(stringTitleRes,stringAuthorRes,stringAuthorRes2)
        }
        
    }
}

@Composable
fun ImageCard(imageRes: Int, modifier: Modifier = Modifier){
    Card(elevation = 10.dp) {
        Box(
            modifier = modifier
                .width(350.dp)
                .border(width = 3.dp, Color.Black, shape = RectangleShape)
                .padding(all = 30.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null
            )
        }
    }
}

@Composable
fun TextCard(
    stringResTitle:Int,
    stringResAuthor:Int,
    stringAuthorRes2:Int,
    modifier: Modifier = Modifier
){
    val paddingModifier  = Modifier.padding(10.dp)
    Card(elevation = 10.dp, modifier = paddingModifier.width(300.dp)) {

        Column(verticalArrangement = Arrangement.Center,
            modifier = modifier.padding(all = 20.dp)) {

            Text(text = stringResource(id = stringResTitle), fontSize = 18.sp)
            Row() {
                Text(text = stringResource(id = stringResAuthor), fontWeight = FontWeight.Bold)
            }
            Row() {
                Text(text = stringResource(id = stringAuthorRes2), fontWeight = FontWeight.Bold)

            }
        }
    }
}



fun nextPicture(currentPicture: Int):Int{
    var temp = currentPicture
    if (temp == 3){
        return 0
    } else {
        return temp++
    }
}





