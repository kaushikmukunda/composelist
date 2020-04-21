package com.km.composelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    private val display = listOf(
        "approval", "watch", "squeeze", "abashed",
        "envious", "bulb", "cakes", "hall",
        "kindly", "remember", "event", "ratty",
        "glove", "sprout", "rapid", "lucky",
        "peaceful", "pricey", "afterthought", "rightful",
        "program", "tongue", "bottle", "gaudy",
        "wish", "beginner", "sand", "offend",
        "hands", "idiotic", "basketball", "aspiring",
        "exist", "jittery", "tickle", "friend",
        "mere", "coherent", "cent", "grip"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DisplayList(display)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        DisplayList(listOf("Abc", "def", "ghi"))
    }
}