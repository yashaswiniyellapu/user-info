package com.everest.userinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.everest.userinfo.model.User
import com.everest.userinfo.validations.ValidateFields

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val validate= ValidateFields(this)


        binding.validateButton.setOnClickListener {

            if (!validate.inputs(binding.inputEmail.text.trim().toString(),
                binding.inputPh.text.toString(),binding.inputPinCode.text.toString())
                                         &&
                !validate.mandatoryInputs(binding.inputEmail.text.trim().toString(),
                    binding.inputPh.text.toString(),binding.inputPinCode.text.toString(),
                binding.inputUserName.text.toString(),binding.inputAddress.text.toString())) {

                displayValidatedText(View.GONE, View.VISIBLE)
            }

        }


        binding.cancelButton.setOnClickListener{
            binding.inputTV.visibility= View.VISIBLE
            binding.displayTV.visibility=View.GONE
        }


        binding.confirmButton.setOnClickListener{
            intent= Intent(this,DisplayActivity::class.java)
            intent.putExtra("user",getUser())
            startActivity(intent)
        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(USER_NAME,binding.inputUserName.text.toString())
        outState.putString(EMAIL,binding.inputEmail.text.toString())
        outState.putString(PHONE_NUMBER,binding.inputPh.text.toString())
        outState.putString(PIN_CODE,binding.inputPinCode.text.toString())
        outState.putString(ADDRESS,binding.inputAddress.text.toString())
        outState.putInt("visibilityDisplay", binding.displayTV.visibility)
        outState.putInt("visibilityInput",binding.inputTV.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.disUsernameTV.text= savedInstanceState.getString(USER_NAME)
        binding.disEmailTV.text=savedInstanceState.getString(EMAIL)
        binding.disPhoneNumberTV.text=savedInstanceState.getString(PHONE_NUMBER)
        binding.disPinCodeTV.text= savedInstanceState.getString(PIN_CODE)
        binding.disAddressTV.text=savedInstanceState.getString(ADDRESS)
        binding.displayTV.visibility=savedInstanceState.getInt("visibilityDisplay")
        binding.inputTV.visibility=savedInstanceState.getInt("visibilityInput")
    }
    private fun getUser(): User {
        return User(
            binding.inputUserName.text.toString(),
            binding.inputPh.text.toString(),
            binding.inputEmail.text.toString(),
            binding.inputAddress.text.toString(),
            binding.inputPinCode.text.toString()
        )

    }
    private fun displayValidatedText(inputVisible: Int, validateDisplayVisible: Int)
    {
        binding.inputTV.visibility = inputVisible
        binding.displayTV.visibility= validateDisplayVisible
        binding.disUsernameTV.text = binding.inputUserName.text
        binding.disEmailTV.text = binding.inputEmail.text
        binding.disPhoneNumberTV.text = binding.inputPh.text
        binding.disPinCodeTV.text = binding.inputPinCode.text
        binding.disAddressTV.text = binding.inputAddress.text
    }


}
