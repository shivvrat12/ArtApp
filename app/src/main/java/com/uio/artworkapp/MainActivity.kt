package com.uio.artworkapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.uio.artworkapp.ui.theme.ArtWorkAppTheme
import java.security.KeyStore.TrustedCertificateEntry

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtWorkAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtWork()
                }
            }
        }
    }
}
fun getImage(myInt:Int):Int{
    var image = when(myInt){
        1 -> R.drawable.birmingham_museums_trust_sjr8ldyef7k_unsplash
        2 -> R.drawable.tamara_menzi_n_vnwqmmvoy_unsplash
        3 -> R.drawable.europeana_8e31onocvxg_unsplash
        else -> {
            R.drawable.ic_launcher_background
        }
    }
    return image;
}
@Composable
fun ArtWork(){
    var myInt by rememberSaveable { mutableStateOf(0) }


//    var image :Int= when(myInt){
//        1 -> R.drawable.birmingham_museums_trust_sjr8ldyef7k_unsplash
//        2 -> R.drawable.europeana_8e31onocvxg_unsplash
//        3 -> R.drawable.tamara_menzi_n_vnwqmmvoy_unsplash
//        else -> {
//            R.drawable.ic_launcher_background
//        }
//    }
    var text = "hello"

//    if(currentState.value == 1){
//        image.value = R.drawable.birmingham_museums_trust_sjr8ldyef7k_unsplash
//        text.value = "It is Something about Museums"
//    }
//    else if(currentState.value == 2){
//        image.value = R.drawable.europeana_8e31onocvxg_unsplash
//        text.value = "It is Europe's best Beauty"
//    }
//    else if (currentState.value == 3){
//        image.value = R.drawable.tamara_menzi_n_vnwqmmvoy_unsplash
//        text.value = "Look How beautiful it is!!"
//    }
//    else{
//        currentState.value = 1
//    }

    Column(modifier = Modifier.fillMaxSize()) {
        CardView(getImage(myInt))
        Spacer(modifier = Modifier.padding(10.dp))
        CardText(Text = text)
        Spacer(modifier = Modifier.padding(10.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = { if(myInt>0){
                myInt--
            }else{
                myInt=0
            }
                Log.d("MainActivity","Value: $myInt")
            }) {

                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.padding(25.dp))
            Button(onClick = { myInt++
                Log.d("MainActivity","Value: $myInt")

            }) {
                Text(text = "Next")
            }
        }
    }
}
@Composable
fun CardView(photo:Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp, 70.dp, 15.dp, 20.dp)
        .background(MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp))) {
        Image(painter = painterResource(photo), contentDescription = null, modifier = Modifier.padding(40.dp,40.dp))
    }
}
@Composable
fun CardText(Text:String){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp, 15.dp)) {
        Text(Text, modifier = Modifier.padding(5.dp,0.dp,0.dp,0.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun show(){
    ArtWork()
}