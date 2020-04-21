package com.km.composelist

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.onPositioned
import androidx.ui.core.paint
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.layout.Row
import androidx.ui.layout.padding
import androidx.ui.layout.size
import androidx.ui.res.imageResource
import androidx.ui.unit.IntPxSize
import androidx.ui.unit.dp
import androidx.ui.unit.ipx

private fun IntPxSize.isInitialized(): Boolean {
    return width != 0.ipx && height != 0.ipx
}

@Composable
fun DisplayList(data: List<String>) {
    AdapterList(data = data) {
        ItemView(data = it)
    }
}

@Composable
fun ItemView(data: String) {
    Row(modifier = Modifier.padding(16.dp, 32.dp, 16.dp, 32.dp)) {
        Text(
            data,
            modifier = Modifier.padding(end = 8.dp) + Modifier.gravity(Alignment.CenterVertically)
        )
        ImageView(modifier = Modifier.size(width = 80.dp, height = 60.dp))
    }
}

@Composable
fun ImageView(modifier: Modifier = Modifier.None) {
    val model =
        state(init = { IntPxSize(0.ipx, 0.ipx) }, areEquivalent = { old, new -> old == new })

    val layoutModifier = Modifier.onPositioned {
        model.value = it.size
    }

    val imageModifier = if (model.value.isInitialized()) {
        val asset = imageResource(id = android.R.drawable.ic_dialog_alert)
        Modifier.paint(ImagePainter(asset))
    } else Modifier.None

    Box(modifier + imageModifier + layoutModifier)
}