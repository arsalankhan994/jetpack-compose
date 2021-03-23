package com.erselankhan.composeproject.component

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.erselankhan.composeproject.R

@Composable
fun SimpleText() {
    Text(text = "My name is Erselan Khan")
}

@Composable
fun TextWithCustomColor() {
    Text(
        text = stringResource(id = R.string.random_text),
        color = Color.Green
    )
}

@Composable
fun TextWithCustomFont() {
    Text(
        text = stringResource(id = R.string.random_text),
        fontFamily = FontFamily.SansSerif
    )
}

@Composable
fun TextWithCustomSize() {
    Text(
        text = stringResource(id = R.string.random_text),
        fontSize = 10.sp
    )
}

@Composable
fun TextWithCustomStyle() {
    Text(
        text = stringResource(id = R.string.random_text),
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun TwoTextVertically() {
    Column {
        Text(text = "My name is Erselan Khan")
        Text(
            text = stringResource(id = R.string.random_text).repeat(20),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
fun SimpleClickableText() {
    ClickableText(
        text = AnnotatedString("Click Me"),
        onClick = { offset ->
            Log.d("ClickableText", "$offset -th character is clicked.")
        }
    )
}
