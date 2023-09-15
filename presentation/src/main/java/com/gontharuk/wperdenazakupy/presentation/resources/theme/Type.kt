package com.gontharuk.wperdenazakupy.presentation.resources.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val typography = Typography(
//    displayLarge = TextStyle(),
//    displayMedium = TextStyle(),
//    displaySmall = TextStyle(),
//    headlineLarge = TextStyle(),
//    headlineMedium = TextStyle(),
//    headlineSmall = TextStyle(),
    titleLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
//    titleSmall = TextStyle(),
//    bodyLarge = TextStyle(),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        letterSpacing = 0.sp
    ),
//    labelLarge = TextStyle(),
//    labelMedium = TextStyle(),
//    labelSmall = TextStyle(),
)