package com.example.compose.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.ui.theme.ComposeTheme

class WeChat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
              Image(imageResource(id = R.drawable.banana),modifier = Modifier
                  .padding(8.dp)
                  .unread()
                  .clip(RoundedCornerShape(4.dp)))
            }
        }
    }
}

fun Modifier.unread():Modifier =
    this.drawWithContent {
        drawContent()
        drawIntoCanvas { canvas->
            val paint = Paint().apply {
                color = Color.Red
            }
            canvas.drawCircle(Offset(size.width-1.dp.toPx(),1.dp.toPx()),8.dp.toPx(),paint)

        }
    }

