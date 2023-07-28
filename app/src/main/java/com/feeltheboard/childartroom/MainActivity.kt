package com.feeltheboard.childartroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.feeltheboard.childartroom.ui.theme.ChildArtRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChildArtRoomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainSliderLayout()
                }
            }
        }
    }
}

@Composable
fun MainSliderLayout() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            color = MaterialTheme.colorScheme.surface,
            shape = MaterialTheme.shapes.extraSmall,
            shadowElevation = 3.dp,
        ) {
            Image(
                painter = painterResource(id = R.drawable.familyphoto),
                contentDescription = "Marina, Melissa and Rafael",
                modifier = Modifier
                    .padding(20.dp)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Image Title",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                )
                Text(text = "Image Author")
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // I want both buttons with the same size and a spacing between them
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
                    .fillMaxWidth(),
            ) {
                // Icon(painter = TODO(), contentDescription = "Previous")
                Text(text = "Previous")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
                    .fillMaxWidth(),
            ) {
                // Icon(painter = TODO(), contentDescription = "Next")
                Text(text = "Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    ChildArtRoomTheme {
        MainSliderLayout()
    }
}