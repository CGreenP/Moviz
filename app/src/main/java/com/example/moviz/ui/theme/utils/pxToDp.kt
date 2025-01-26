package com.example.moviz.ui.theme.utils

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Converts a pixel (px) value to density-independent pixel (dp) value.
 *
 * This function takes a pixel value and the current context to calculate the equivalent dp value.
 * It uses the display's density to perform the conversion.
 *
 * @param px The pixel value to be converted.
 * @param context The context used to get the display metrics. Defaults to the current composition's context.
 * @return The equivalent dp value as a Float.
 *
 * @sample
 * ```
 *  val dpValue = pxToDp(100) // Converts 100 pixels to dp based on the screen density.
 *  Text(text = "This is some text", modifier = Modifier.padding(dpValue.dp))
 * ```
 */
@Composable
fun pxToDp(px: Int, context: Context = LocalContext.current): Float {
    val displayMetrics = context.resources.displayMetrics
    val density = displayMetrics.density
    return px / density
}