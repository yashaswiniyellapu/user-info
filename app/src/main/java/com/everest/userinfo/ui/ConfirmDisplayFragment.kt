package com.everest.userinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.everest.userinfo.R
import com.everest.userinfo.databinding.FragmentConfirmBinding
import com.everest.userinfo.model.User
import com.everest.userinfo.model.UserViewModel

class ConfirmDisplayFragment : Fragment(R.layout.fragment_confirm) {

    private lateinit var binding: FragmentConfirmBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmBinding.inflate(inflater, container, false)

        val model= ViewModelProvider(requireActivity()).get(UserViewModel::class.java)
        val user = model.user.value

        val string = resources.getString(
            R.string.confirm_message,
            user?.userName,
            user?.phoneNumber,
            user?.address,
            user?.pinCode,
            user?.pinCode
        )
        binding.resultTV.text = string

        return binding.root
    }
}