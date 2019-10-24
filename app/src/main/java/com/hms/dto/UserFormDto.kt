package com.hms.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserFormDto(var firstName:String, var lastName:String, var mail:String) : Parcelable