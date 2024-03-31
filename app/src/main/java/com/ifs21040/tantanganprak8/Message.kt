package com.ifs21040.tantanganprak8

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    var icon: Int,
    var name: String,
    var icon2: Int
) : Parcelable
