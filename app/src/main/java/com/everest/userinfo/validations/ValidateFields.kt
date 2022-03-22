package com.everest.userinfo.validations


import android.content.Context
import android.util.Patterns
import android.widget.Toast
import com.everest.userinfo.HomeActivity

class ValidateFields constructor(private var context: Context) {

    fun inputs(email:String, phNo:String, pinCode:String): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
          makeToast("Email should have @ and .com or co.in")
            return true
        }
        if (phNo.length != 10) {
          makeToast("phone number should be only length of 10")
            return true
        }
        if (pinCode.length != 6) {
            makeToast("pin code should be only length of 6")
            return true
        }
        return false
    }

    fun mandatoryInputs(email:String, phNo:String, pinCode:String, userName:String, address:String): Boolean {
        if (email.isEmpty()) {
            makeToast("Email should not empty")
            return true
        }
        if (phNo.isEmpty()) {

            makeToast("phone number should not empty")
            return true
        }
        if (pinCode.isEmpty()) {
           makeToast("pin code should not empty")
            return true
        }
        if (userName.isEmpty()) {
            makeToast("username should not empty")
            return true
        }
        if (address.isEmpty()) {
            makeToast("address should not empty")
            return true
        }
        return false
    }

    private fun makeToast(message:String)
    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }


}