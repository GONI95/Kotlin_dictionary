package com.example.kotlin_dictionary.Intent_Ex

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Student(
    var name: String = "LEE",
    var age: Int = 26
) : Parcelable {

}