package com.melvin.ongandroid.view.fragments.contact_us

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.melvin.ongandroid.R
import com.melvin.ongandroid.data.datasource.ContactDataSourceImpl
import com.melvin.ongandroid.data.repository.ContactRepositoryImpl
import com.melvin.ongandroid.databinding.FragmentContactUsBinding
import com.melvin.ongandroid.data.local.model.Contact
import com.melvin.ongandroid.application.ComponentUtils.Companion.showAlert
import com.melvin.ongandroid.application.DataState
import com.melvin.ongandroid.application.Validator
import com.melvin.ongandroid.data.apiservice.APIContactManager
import com.melvin.ongandroid.presentation.contact_us.ContactViewModelFactory
import com.melvin.ongandroid.data.remote.network.APIManager
import com.melvin.ongandroid.presentation.contact_us.ContactUsViewModel



class ContactUs : Fragment(R.layout.fragment_contact_us) {
    lateinit var binding: FragmentContactUsBinding
    private val repository = ContactRepositoryImpl(ContactDataSourceImpl(APIContactManager()))
    private lateinit var viewModel: ContactUsViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactUsBinding.bind(view)
        buttonSubmitIsEnabled(false)
        setupTextChangeListener()
        setupOnClickListener()
        initViewModel()
        subscribeLiveData()

    }

    private fun setupTextChangeListener() {
        with(binding) {
            textfieldQuestionFragmentContactUs.addTextChangedListener(textWatcher)
            textfieldEmailFragmentContactUs.addTextChangedListener(textWatcher)
            textfieldFirstnameFragmentContactUs.addTextChangedListener(textWatcher)
            textfieldPhoneFragmentContactUs.addTextChangedListener(textWatcher)
        }
        binding.textfieldQuestionFragmentContactUs.addTextChangedListener(textWatcher)
        binding.textfieldEmailFragmentContactUs.addTextChangedListener(textWatcher)
        binding.textfieldFirstnameFragmentContactUs.addTextChangedListener(textWatcher)
        binding.textfieldPhoneFragmentContactUs.addTextChangedListener(textWatcher)

    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
           /*  val txtEmail = binding.textfieldEmailFragmentContactUs.text.toString().trim()
             if (!Validator.isEmailValid(txtEmail))
                 showToast(requireContext(), getString(R.string.invalid_email_text))*/

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            val txtEmail = binding.textfieldEmailFragmentContactUs.text.toString().trim()
            val txtName = binding.textfieldFirstnameFragmentContactUs.text.toString().trim()
            val txtLastName = binding.textfieldPhoneFragmentContactUs.text.toString().trim()
            val txtQuestions = binding.textfieldQuestionFragmentContactUs.text.toString().trim()

            buttonSubmitIsEnabled(txtEmail.isNotEmpty() && Validator.isEmailValid(txtEmail) && txtName.isNotEmpty() && txtLastName.isNotEmpty() && txtQuestions.isNotEmpty())
        }

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }
    }

    private fun setupOnClickListener() {
        binding.buttonSubmitFragmentContactus.setOnClickListener {
            viewModel.saveContact(
                Contact(
                    0,
                    binding.textfieldFirstnameFragmentContactUs.text.toString(),
                    binding.textfieldEmailFragmentContactUs.text.toString(),
                    binding.textfieldPhoneFragmentContactUs.text.toString(),
                    binding.textfieldQuestionFragmentContactUs.text.toString()
                )
            )
        }
    }

    private fun initViewModel() {
        ContactViewModelFactory(repository).run {
            viewModel = ViewModelProvider(this@ContactUs, this)[ContactUsViewModel::class.java]
        }
    }

    private fun subscribeLiveData() {
        with(viewModel) {
            contacts.observe(viewLifecycleOwner) {
                handleUiContact(it)
            }
        }
    }

    private fun handleUiContact(uiState: DataState<MutableList<Contact>>) {
        when (uiState) {
            is DataState.Success<MutableList<Contact>> -> {
                showAlert(
                    requireContext(),
                    getString(R.string.contact_send),
                    getString(R.string.contact_send_description),
                    getString(R.string.ok_button),
                    null
                )
                cleanComponents()
                handlerErrorVisibility(false)
                handlerProgressBarVisibility(false)
            }
            is DataState.Error -> {
                handlerErrorVisibility(true)
                handlerProgressBarVisibility(false)
            }
            is DataState.Loading -> {
                handlerErrorVisibility(false)
                handlerProgressBarVisibility(true)
            }
            is DataState.Idle -> Unit
        }
    }

    private fun cleanComponents() {
        with(binding) {
            textfieldFirstnameFragmentContactUs.setText("")
            textfieldPhoneFragmentContactUs.setText("")
            textfieldEmailFragmentContactUs?.setText("")
            textfieldQuestionFragmentContactUs?.setText("")
        }
    }

    private fun handlerProgressBarVisibility(show: Boolean) {
        with(binding) {
            iProgressBar.progressBar.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun handlerErrorVisibility(show: Boolean) {
        with(binding) {
            iGenericError.clGenericError.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

    private fun buttonSubmitIsEnabled(value: Boolean) {
        binding.buttonSubmitFragmentContactus.isEnabled = value
    }
}

