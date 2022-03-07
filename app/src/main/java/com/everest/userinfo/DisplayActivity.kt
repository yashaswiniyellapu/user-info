package com.everest.userinfo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.AcitvityDisplayBinding


class DisplayActivity : AppCompatActivity() {
    private lateinit var binding: AcitvityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = AcitvityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras

        binding.resultTV.text = getString(
            R.string.confirm_message, bundle?.getString(USER_NAME), bundle?.getString(
                ADDRESS
            ), bundle?.getString(PIN_CODE), bundle?.get(PHONE_NUMBER), bundle?.getString(EMAIL)
        )

    }

}