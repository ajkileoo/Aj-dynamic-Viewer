package com.example.ajdynamicviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ajdynamicviewer.ui.theme.DynamicImageViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DynamicImageViewerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageViewerScreen()
                }
            }
        }
    }
}

@Composable
fun ImageViewerScreen() {
    var currentImage by remember { mutableStateOf(R.drawable.image1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Crossfade(targetState = currentImage) { imageId ->
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "Displayed Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { currentImage = R.drawable.image1 },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Red")
            }

            Button(
                onClick = { currentImage = R.drawable.image2 },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text("Green")
            }

            Button(
                onClick = { currentImage = R.drawable.image3 },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
            ) {
                Text("Blue")
            }
        }
    }
}
