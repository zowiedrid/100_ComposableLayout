package com.example.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composable.ui.theme.ComposableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TampilLayar(
                        pesan = getString(R.string.greeting),
                        dari = getString(R.string.name)
                    )
                }
            }
        }
    }
}

@Composable
fun TampilText(message:String,from:String,modifier: Modifier= Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Text(
            text = message,
            color = Color.Yellow,
            fontSize = 90.sp,
            lineHeight = 90.sp,
            textAlign = TextAlign.Center)
        Text(
            text = from,
            color = Color.Magenta,
            fontSize = 60.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Center,
            modifier= Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(8.dp)
        )
    }
}

@Composable
fun TampilLayar(pesan:String,dari:String){
    val image = painterResource(id = R.drawable.wlpr)
    Box{
        Image(
            painter = image,
            contentDescription = "Gambar",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
        TampilText(
            message = pesan,
            from = dari,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableTheme {
        TampilLayar(pesan = "Selamat Malam!", dari = "dari UMY")
    }
}