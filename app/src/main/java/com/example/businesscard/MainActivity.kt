package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ContactInfo(icon: ImageVector, info: String) {
    Row(modifier = Modifier.padding(4.dp)) {
        Spacer(modifier = Modifier.width(50.dp))
        Icon(
            icon,
            contentDescription = null,
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = info,
            color = Color.White
        )
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .background(Color(0xFF291B4E))
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(all = 16.dp)
                .weight(1f)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = stringResource(R.string.Name),
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                color = Color.White,
                modifier = Modifier.padding(all = 4.dp)
            )
            Text(
                text = stringResource(R.string.post),
                fontWeight = FontWeight.Light,
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 4.dp, end = 4.dp, bottom = 4.dp)
            )
        }

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier
                .padding(all = 16.dp)
                .fillMaxWidth()
        ) {
            ContactInfo(icon = Icons.Rounded.Call, info = stringResource(R.string.phone_number))
            ContactInfo(icon = Icons.Rounded.Share, info = stringResource(R.string.socials))
            ContactInfo(icon = Icons.Rounded.Email, info = stringResource(R.string.email))
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}