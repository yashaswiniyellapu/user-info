package com.everest.userinfo.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.everest.userinfo.R
import com.everest.userinfo.databinding.FragmentValidateBinding
import com.everest.userinfo.model.User
import com.everest.userinfo.model.UserViewModel


class ValidateDisplayFragment : Fragment(R.layout.fragment_validate) {

    private lateinit var binding: FragmentValidateBinding
    private lateinit var viewModel:UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentValidateBinding.inflate(inflater, container, false)
        val bundle: Bundle? = this.arguments
        val user = bundle?.getParcelable<User>("user")




        user?.let { displayValidatedText(it) }
        user?.let { passDataToConfirmScreen(it) }
        showInputScreenForCancelButton()
       viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        return binding.root
    }

    private fun displayValidatedText(user:User) {
        binding.disUsernameTV.text = user.userName
        binding.disEmailTV.text = user.email
        binding.disPinCodeTV.text = user.pinCode
        binding.disAddressTV.text = user.address
        binding.disPhoneNumberTV.text = user.phoneNumber
    }

    private fun passDataToConfirmScreen(user:User) {
        binding.confirmButton.setOnClickListener {
            val confirmBundle = Bundle()
            confirmBundle.putParcelable("user", user)
            val confirmFragment = ConfirmDisplayFragment()
            confirmFragment.arguments = confirmBundle
            val transaction: FragmentTransaction =requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.inputTV, confirmFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun showInputScreenForCancelButton() {
        binding.cancelButton.setOnClickListener {
            val inputFragment = InputFragment()
            val transaction: FragmentTransaction =requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.inputTV, inputFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }


}