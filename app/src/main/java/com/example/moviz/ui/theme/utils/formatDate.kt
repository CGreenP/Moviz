package com.example.moviz.ui.theme.utils

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Formats a date string from "yyyy-MM-dd" to "dd-MM-yyyy".
 *
 * This function takes a date string in the format "yyyy-MM-dd" and converts it to a
 * date string in the format "dd-MM-yyyy". It uses SimpleDateFormat for parsing and formatting.
 *
 * @param dateString The date string to format, expected in "yyyy-MM-dd" format.
 * @return The formatted date string in "dd-MM-yyyy" format.
 * @throws java.text.ParseException if the input date string is not in the expected "yyyy-MM-dd" format.
 * @throws NullPointerException if the parsed date is null (which should not happen in normal use due to the format)
 *
 * @Example
 * ```
 * val formattedDate = formatDate("2023-10-27")
 * println(formattedDate) // Output: 27-10-2023
 * ```
 */
fun formatDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())

    val date = inputFormat.parse(dateString)
    return outputFormat.format(date!!)
}