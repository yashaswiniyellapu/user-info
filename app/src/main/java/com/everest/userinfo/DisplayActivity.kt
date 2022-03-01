package com.everest.userinfo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.AcitvityDisplayBinding
import com.everest.userinfo.databinding.ActivityHomeBinding

class DisplayActivity : AppCompatActivity() {
    private lateinit var binding : AcitvityDisplayBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = AcitvityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras
        binding.resultTV.text=
            "Hi "+ (bundle?.getString("userName")) +", How are you? Are you staying at "+bundle?.getString("userAddress")+"-"+
                    bundle?.getString("pinCode")+". " +
                    "I am not able to contact you on "+bundle?.getString("phoneNumber")+ ". " +
                    "Can I email you the details at "+bundle?.getString("email")
    }

}