package com.everest.userinfo


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.everest.userinfo.databinding.AcitvityDisplayBinding
import com.everest.userinfo.model.User


class DisplayActivity : AppCompatActivity() {
    private lateinit var binding: AcitvityDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = AcitvityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val user = intent.getParcelableExtra<User>("user")

        binding.resultTV.text = getString(
            R.string.confirm_message,
            user?.userName,
            user?.address,
            user?.pinCode,
            user?.phoneNumber,
            user?.email
        )

    }

}