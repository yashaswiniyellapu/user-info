package com.everest.userinfo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.everest.userinfo.R
import com.everest.userinfo.databinding.FragmentInputBinding
import com.everest.userinfo.model.User
import com.everest.userinfo.model.UserViewModel

class InputFragment : Fragment(R.layout.fragment_input) {

    private lateinit var binding: FragmentInputBinding

    private lateinit var viewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInputBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(UserViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner)
        {

            binding.inputUserName.setText(viewModel.user.value?.userName)
            binding.inputPh.setText(viewModel.user.value?.phoneNumber)
            binding.inputEmail.setText(viewModel.user.value?.email)
            binding.inputAddress.setText(viewModel.user.value?.address)
            binding.inputPinCode.setText(viewModel.user.value?.pinCode)
        }


        binding.validateButton.setOnClickListener {
            setUser()
            if (this.context?.let { it1 -> viewModel.validateInputs(it1) } == true) {
                val validatedDisplayFragment = ValidateDisplayFragment()
                val transaction: FragmentTransaction =requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.inputTV, validatedDisplayFragment)
                transaction.addToBackStack(null)
                transaction.commit()
            }
        }
        return binding.root
    }

    private fun setUser() {
        viewModel.setUserDetails(
            User(
                binding.inputUserName.text.toString(),
                binding.inputPh.text.toString(),
                binding.inputEmail.text.toString(),
                binding.inputAddress.text.toString(),
                binding.inputPinCode.text.toString()
            )
        )
    }


}