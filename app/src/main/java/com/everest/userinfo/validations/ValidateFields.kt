package com.everest.userinfo.validations


import android.util.Patterns
import android.widget.Toast
import com.everest.userinfo.HomeActivity
import com.everest.userinfo.databinding.ActivityHomeBinding

class ValidateFields constructor(
    private var binding: ActivityHomeBinding,
    private var homeActivity: HomeActivity
) {

    fun validateInputs(): Boolean {
        if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.text.trim()).matches()) {
            Toast.makeText(
                homeActivity,
                "Email should have @ and .com or co.in",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        if (binding.inputPh.text.length != 10) {
            Toast.makeText(
                homeActivity,
                "phone number should be only length of 10",
                Toast.LENGTH_SHORT
            ).show()
            return true
        }
        if (binding.inputPinCode.text.length != 6) {
            Toast.makeText(homeActivity, "pin code should be only length of 6", Toast.LENGTH_SHORT)
                .show()
            return true
        }
        return false
    }

    fun validateMandatoryInputs(): Boolean {
        if (binding.inputEmail.text.isEmpty()) {
            Toast.makeText(homeActivity, "Email should not empty", Toast.LENGTH_SHORT).show()
            return true
        }
        if (binding.inputPh.text.isEmpty()) {

            Toast.makeText(homeActivity, "phone number should not empty", Toast.LENGTH_SHORT).show()
            return true
        }
        if (binding.inputPinCode.text.isEmpty()) {
            Toast.makeText(homeActivity, "pin code should not empty", Toast.LENGTH_SHORT).show()
            return true
        }
        if (binding.inputUserName.text.isEmpty()) {
            Toast.makeText(homeActivity, "username should not empty", Toast.LENGTH_SHORT).show()
            return true
        }
        if (binding.inputAddress.text.isEmpty()) {
            Toast.makeText(homeActivity, "address should not empty", Toast.LENGTH_SHORT).show()
            return true
        }
        return false
    }


}