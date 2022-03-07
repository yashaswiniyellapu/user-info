package com.everest.userinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.everest.userinfo.validations.ValidateFields

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.validateButton.setOnClickListener {


            if (!ValidateFields(binding, this).validateInputs() && !ValidateFields(
                    binding,
                    this
                ).validateMandatoryInputs()
            ) {
                binding.inputTV.visibility = View.GONE
                binding.displayTV.visibility= View.VISIBLE
                binding.disUsernameTV.text = binding.inputUserName.text
                binding.disEmailTV.text = binding.inputEmail.text
                binding.disPhoneNumberTV.text = binding.inputPh.text
                binding.disPinCodeTV.text = binding.inputPinCode.text
                binding.disAddressTV.text = binding.inputAddress.text
            }

        }
        binding.cancelButton.setOnClickListener{
            binding.inputTV.visibility= View.VISIBLE
            binding.displayTV.visibility=View.GONE
        }
        binding.confirmButton.setOnClickListener{
            val bundle = Bundle()
            bundle.putString(USER_NAME,binding.inputUserName.text.toString())
            bundle.putString(EMAIL,binding.inputEmail.text.toString())
            bundle.putString(PHONE_NUMBER,binding.inputPh.text.toString())
            bundle.putString(PIN_CODE,binding.inputPinCode.text.toString())
            bundle.putString(ADDRESS,binding.inputAddress.text.toString())
            intent= Intent(this,DisplayActivity::class.java)
            intent.putExtras(bundle)
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


}
