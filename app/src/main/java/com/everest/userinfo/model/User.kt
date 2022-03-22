package com.everest.userinfo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(var userName:String, var phoneNumber:String, var email:String, var address:String,
var pinCode:String) : Parcelable {

}