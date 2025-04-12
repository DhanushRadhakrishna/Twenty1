package com.habits.twenty1.presentation.text

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import com.habits.twenty1.R

    // [START android_compose_text_df_provider]
    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )
    // [END android_compose_text_df_provider]


    val fontName = GoogleFont("Fira Code")

    val FiraCodeFont = FontFamily(
        Font(googleFont = fontName, fontProvider = provider)
    )
