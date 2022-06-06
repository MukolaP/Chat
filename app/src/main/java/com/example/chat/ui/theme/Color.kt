package com.example.chat.ui.theme

import androidx.compose.ui.graphics.Color

data class Colors(
    val primaryBackground: Color,
    val secondaryBackground: Color,
    val colorSecondaryUser: Color,
    val headerTextColor: Color,
    val primaryTextColor: Color,
    val primaryTintColor: Color,
)

val lightPalette = Colors(
    primaryBackground = Color.White,
    secondaryBackground = Color(0xFF6200EE),
    colorSecondaryUser = Color.LightGray,
    headerTextColor = Color.Black,
    primaryTextColor = Color(0xFF59442B),
    primaryTintColor = Color(0xFF3700B3),
)

val darkPalette = Colors(
    primaryBackground = Color.White,
    secondaryBackground = Color.Black,
    colorSecondaryUser = Color.White,
    headerTextColor = Color.Black,
    primaryTextColor = Color(0xFF59442B),
    primaryTintColor = Color.Black,
)