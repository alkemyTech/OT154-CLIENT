package com.melvin.ongandroid.view.contact_us

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.melvin.ongandroid.R
import com.melvin.ongandroid.databinding.FragmentContactUsBinding
import com.melvin.ongandroid.databinding.FragmentHomeBinding
import com.melvin.ongandroid.utils.Validator

class ContactUs : Fragment(R.layout.fragment_contact_us) {
    lateinit var binding: FragmentContactUsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactUsBinding.bind(view)
        buttonSubmitIsEnabled(false)
        binding.textfieldQuestionFragmentContactUs.addTextChangedListener(textWatcher)
        binding.textfieldEmailFragmentContactUs.addTextChangedListener(textWatcher)
        binding.textfieldFirstnameFragmentContactUs.addTextChangedListener(textWatcher)
        binding.textfieldLastnameFragmentContactUs.addTextChangedListener(textWatcher)
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
            var txtEmail = binding.textfieldEmailFragmentContactUs.text.toString().trim()
            if (!Validator.isEmailValid(txtEmail)){
             val toast = Toast.makeText(context,"El Formato de email no es valido.",Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            var txtEmail = binding.textfieldEmailFragmentContactUs.text.toString().trim()
            var txtName = binding.textfieldFirstnameFragmentContactUs.text.toString().trim()
            var txtLastName = binding.textfieldLastnameFragmentContactUs.text.toString().trim()
            var txtQuestions = binding.textfieldQuestionFragmentContactUs.text.toString().trim()

            buttonSubmitIsEnabled(txtEmail.isNotEmpty() && Validator.isEmailValid(txtEmail) && txtName.isNotEmpty() && txtLastName.isNotEmpty() && txtQuestions.isNotEmpty())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    private fun buttonSubmitIsEnabled(value: Boolean) {
        binding.buttonSubmitFragmentContactus.isEnabled = value
    }
}

