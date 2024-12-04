package com.example.ajdynamicviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ajdynamicviewer.ui.theme.AJDynamicViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ImageViewerScreen()
            AJDynamicViewerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AJDynamicViewerTheme {
        Greeting("Android")
        ImageViewerScreen()
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
        // Display the image
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = "Displayed Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )

        // Row for buttons
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { currentImage = R.drawable.image1 },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text("Red")
            }

            Button(
                onClick = { currentImage = R.drawable.image2 },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green)
            ) {
                Text("Green")
            }

            Button(
                onClick = { currentImage = R.drawable.image3 },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
            ) {
                Text("Blue")
            }
        }
    }
}
