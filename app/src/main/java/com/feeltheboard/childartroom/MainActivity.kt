package com.feeltheboard.childartroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
    var currentPictureIndex by remember { mutableStateOf(0) }
    val familyPicture = when(currentPictureIndex){
        0 -> R.drawable.familyphoto1
        1 -> R.drawable.familyphoto2
        2 -> R.drawable.familyphoto3
        else -> R.drawable.familyphoto1
    }
    val pictureTitle = when(currentPictureIndex){
        0 -> "Family in Sydney"
        1 -> "My kingdom"
        2 -> "The party is On"
        else -> "Family in Sydney"
    }
    val pictureAuthor = when(currentPictureIndex){
        0 -> "Rafael Moreira"
        1 -> "Marina Parente"
        2 -> "Bruna Campelo"
        else -> "Rafael Moreira"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.7f),
            color = MaterialTheme.colorScheme.surface,
            shape = MaterialTheme.shapes.extraSmall,
            shadowElevation = 3.dp,
        ) {
            Image(
                painter = painterResource(id = familyPicture),
                contentDescription = "Picture Selected",
                modifier = Modifier
                    .size(480.dp)
                    .padding(20.dp),
                contentScale = ContentScale.Crop
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
                    text = pictureTitle, // TODO: GooglePhotos Title? Location? Faces?
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(bottom = 15.dp)
                )
                Text(text = pictureAuthor) // TODO: GooglePhotos User name?
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    currentPictureIndex--
                    if (currentPictureIndex < 0) {
                        currentPictureIndex = 2
                    }
                },
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(80.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_navigate_before_24),
                    contentDescription = "Previous"
                )
            }
            Button(
                onClick = {
                    currentPictureIndex++
                    if (currentPictureIndex > 2) {
                        currentPictureIndex = 0
                    }
                          },
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(80.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_navigate_next_24),
                    contentDescription = "Next"
                )
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