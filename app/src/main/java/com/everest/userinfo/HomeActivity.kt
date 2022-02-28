package com.everest.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
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


    }


}
