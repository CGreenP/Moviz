package com.example.moviz.ui.theme.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun formatDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    val date = inputFormat.parse(dateString)
    return outputFormat.format(date!!)
}