package com.example.praktikummodul6

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Notes(
    var title: String,
    var note: String
): Parcelable
