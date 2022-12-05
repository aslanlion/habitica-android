package com.habitrpg.android.habitica.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.google.android.material.composethemeadapter.createMdcTheme
import com.habitrpg.android.habitica.R
import com.habitrpg.common.habitica.extensions.getThemeColor

@Composable
fun HabiticaTheme(
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val layoutDirection = LocalLayoutDirection.current
    val (colors, _, shapes) = createMdcTheme(
        context = context,
        layoutDirection = layoutDirection,
        setTextColors = true
    )
    MaterialTheme(
        colors = colors ?: MaterialTheme.colors,
        typography = Typography(
            defaultFontFamily = FontFamily.Default,
            h1 = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                letterSpacing = (0.05).sp
            ),
            h2 = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 28.sp,
                letterSpacing = (0.05).sp
            ),
            subtitle1 = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
            ),
            subtitle2 = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                letterSpacing = 0.1.sp
            ),
            body1 = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                letterSpacing = 0.35.sp,
                lineHeight = 16.sp
            ),
            body2 = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                letterSpacing = 0.2.sp,
                lineHeight = 16.sp
            ),
            button = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                letterSpacing = 1.25.sp
            ),
            caption = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            ),
            overline = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 10.sp,
                letterSpacing = 1.5.sp
            )
        ),
        shapes = Shapes(
            RoundedCornerShape(4.dp),
            RoundedCornerShape(8.dp),
            RoundedCornerShape(12.dp)
        ),
        content = content
    )
}

val Typography.caption1
    get() = caption
val Typography.caption2
get() = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 12.sp,
    letterSpacing = 0.4.sp
)
val Typography.caption3
    get() = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        letterSpacing = 0.3.sp,
        lineHeight = 14.sp
    )
val Typography.caption4
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.35.sp
    )
val Typography.subtitle3
    get() = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    )
object HabiticaTheme {
    val typography: Typography
        @Composable
        get() = MaterialTheme.typography


    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val colors: HabiticaColors
        @Composable
        get() {
            val context = LocalContext.current
            return HabiticaColors(
                windowBackground = Color(context.getThemeColor(R.attr.colorWindowBackground)),
                contentBackground = Color(context.getThemeColor(R.attr.colorContentBackground)),
                contentBackgroundOffset = Color(context.getThemeColor(R.attr.colorContentBackgroundOffset)),
                textPrimary = Color(context.getThemeColor(R.attr.textColorPrimary)),
                textSecondary = Color(context.getThemeColor(R.attr.textColorSecondary)),
                textTertiary = Color(context.getThemeColor(R.attr.colorTertiary)),
                textDimmed = Color(ContextCompat.getColor(context, R.color.text_dimmed)),
            )
        }
}

class HabiticaColors(
    val windowBackground: Color,
    val contentBackground: Color,
    val contentBackgroundOffset: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textDimmed: Color
)