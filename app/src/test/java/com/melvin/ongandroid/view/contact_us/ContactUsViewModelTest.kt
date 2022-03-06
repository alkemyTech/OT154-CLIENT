package com.melvin.ongandroid.view.contact_us

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.data.repository.ContactRepository
import com.melvin.ongandroid.model.Contact
import com.melvin.ongandroid.view.utils.DataState
import com.melvin.ongandroid.view.utils.Response
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.ResponseCache

@ExperimentalCoroutinesApi
class ContactUsViewModelTest {

    @RelaxedMockK
    private lateinit var repository: ContactRepository

    private lateinit var contactUsViewModel: ContactUsViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        contactUsViewModel = ContactUsViewModel(repository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `given correct formatted email a name and a message return true`() {
        var correctContact: Contact = Contact(0, "Mauro", "mauro@gmail.com", "3513315", "hola")
        var listOfContacts = listOf(correctContact)
        var dataState = contactUsViewModel.contacts.value
        var listOfContactsCheck = mutableListOf<Contact>()
        when (dataState) {
            is DataState.Success -> {
                val client = dataState.data
                listOfContactsCheck.add(client)
            }
            is Error -> {
                val error = dataState.cause
            }
            else -> null
        }
        contactUsViewModel.saveContact(correctContact)
//        assert(listOfContacts.first() == contactUsViewModel.contacts.value)
    }
}