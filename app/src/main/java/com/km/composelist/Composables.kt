package com.km.composelist

import android.graphics.Paint
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.*
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.Box
import androidx.ui.graphics.painter.ImagePainter
import androidx.ui.layout.*
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
    Row(modifier = LayoutPadding(16.dp, 32.dp, 16.dp, 32.dp)) {
        Text(
            data,
            modifier = LayoutPadding(end = 8.dp) + LayoutAlign.CenterVertically
        )
        ImageView(modifier = LayoutSize(width = 80.dp, height = 60.dp))
    }
}

@Composable
fun ImageView(modifier: Modifier = Modifier.None) {
    val model =
        state(init = { IntPxSize(0.ipx, 0.ipx) }, areEquivalent = { old, new -> old == new })

    val layoutModifier = onPositioned {
        model.value = it.size
    }

    val imageModifier = if (model.value.isInitialized()) {
        val asset = imageResource(id = android.R.drawable.ic_dialog_alert)
        ImagePainter(asset).asModifier()
    } else Modifier.None

    Box(modifier + imageModifier + layoutModifier)
}