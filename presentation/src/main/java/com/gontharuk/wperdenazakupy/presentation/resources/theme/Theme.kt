package com.gontharuk.wperdenazakupy.presentation.resources.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val darkColorScheme = darkColorScheme(
    primary = Primary_dark,
//    onPrimary = OnPrimary_dark,
//    primaryContainer = PrimaryContainer_dark,
//    onPrimaryContainer = OnPrimaryContainer_dark,
    inversePrimary = InversePrimary_dark,
//    secondary = Secondary_dark,
//    onSecondary = OnSecondary_dark,
//    secondaryContainer = SecondaryContainer_dark,
//    onSecondaryContainer = OnSecondaryContainer_dark,
//    tertiary = Tertiary_dark,
//    onTertiary = OnTertiary_dark,
//    tertiaryContainer = TertiaryContainer_dark,
//    onTertiaryContainer = OnTertiaryContainer_dark,
//    background = Background_dark,
//    onBackground = OnBackground_dark,
//    surface = Surface_dark,
//    onSurface = OnSurface_dark,
//    surfaceVariant = SurfaceVariant_dark,
//    onSurfaceVariant = OnSurfaceVariant_dark,
//    surfaceTint = SurfaceTint_dark,
//    inverseSurface = InverseSurface_dark,
//    inverseOnSurface = InverseOnSurface_dark,
//    error = Error_dark,
//    onError = OnError_dark,
//    errorContainer = ErrorContainer_dark,
//    onErrorContainer = OnErrorContainer_dark,
//    outline = Outline_dark,
//    outlineVariant = OutlineVariant_dark,
//    scrim = Scrim_dark
)

private val lightColorScheme = lightColorScheme(
    primary = Primary_light,
//    onPrimary = OnPrimary_light,
//    primaryContainer = PrimaryContainer_light,
//    onPrimaryContainer = OnPrimaryContainer_light,
    inversePrimary = InversePrimary_light,
//    secondary = Secondary_light,
//    onSecondary = OnSecondary_light,
//    secondaryContainer = SecondaryContainer_light,
//    onSecondaryContainer = OnSecondaryContainer_light,
//    tertiary = Tertiary_light,
//    onTertiary = OnTertiary_light,
//    tertiaryContainer = TertiaryContainer_light,
//    onTertiaryContainer = OnTertiaryContainer_light,
//    background = Background_light,
//    onBackground = OnBackground_light,
//    surface = Surface_light,
//    onSurface = OnSurface_light,
//    surfaceVariant = SurfaceVariant_light,
//    onSurfaceVariant = OnSurfaceVariant_light,
//    surfaceTint = SurfaceTint_light,
//    inverseSurface = InverseSurface_light,
//    inverseOnSurface = InverseOnSurface_light,
//    error = Error_light,
//    onError = OnError_light,
//    errorContainer = ErrorContainer_light,
//    onErrorContainer = OnErrorContainer_light,
//    outline = Outline_light,
//    outlineVariant = OutlineVariant_light,
//    scrim = Scrim_light
)

@Composable
fun WperdeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkColorScheme
        else -> lightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}