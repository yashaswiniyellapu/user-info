package com.everest.userinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.everest.userinfo.databinding.ActivityHomeBinding
import com.everest.userinfo.ui.InputFragment


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var inputFragment = InputFragment()
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.inputTV, inputFragment)
            transaction.commit()
        }


    }
}

