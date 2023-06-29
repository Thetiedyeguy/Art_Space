package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtPage()
                }
            }
        }
    }
}

@Composable
fun ArtPage(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResource = when(result){
        1-> R.drawable.mona_lisa
        2-> R.drawable.portrait1
        3-> R.drawable.portrait2
        4-> R.drawable.portrait3
        5-> R.drawable.mona_lisa
        else-> R.drawable.mona_lisa
    }
    val title = when(result){
        1-> R.string.title_one
        2-> R.string.title_two
        3-> R.string.title_three
        4-> R.string.title_four
        5-> R.string.title_five
        else-> R.string.title_six
    }
    val subtext = when(result){
        1-> R.string.desc_one
        2-> R.string.desc_two
        3-> R.string.desc_three
        4-> R.string.desc_four
        5-> R.string.desc_five
        else-> R.string.desc_six
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = subtext),
            modifier = Modifier
                .weight(20f, true)
                .fillMaxHeight()
                .fillMaxWidth()
        )
        Text(
            text = stringResource(id = title),
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(2f)
                .fillMaxHeight()
        )


        Text(
            text = stringResource(id = subtext),
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(2f)
                .fillMaxHeight()
        )
        Row(
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Button(
                modifier = Modifier
                    .weight(3f),
                onClick = {
                    if(result > 1) {
                        result -= 1
                }
            }) {
                Text(text = "Previous")
            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
            Button(
                modifier = Modifier
                    .weight(3f),
                onClick = {
                    if(result < 6){
                        result += 1
                }
            }) {
                Text(text = "Next")
            }
            Spacer(
                modifier = Modifier
                    .weight(1f)
            )
        }
    }
}