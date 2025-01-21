package com.example.moviz.ui.theme.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun pxToDp(px: Int, context: Context = LocalContext.current): Float {
    val displayMetrics = context.resources.displayMetrics
    val density = displayMetrics.density
    return px / density
}