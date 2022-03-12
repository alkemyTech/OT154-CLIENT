package com.melvin.ongandroid.viewmodel.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.data.login.ResourceLogin
import com.melvin.ongandroid.data.login.repository.LoginRepository
import com.melvin.ongandroid.model.login.LoginModel
import androidx.lifecycle.Observer
import com.melvin.ongandroid.model.login.Data
import com.melvin.ongandroid.model.login.User
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class LoginViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: LoginRepository

    @Mock
    lateinit var viewModel: LoginViewModel

    @Mock
    lateinit var observer: Observer<ResourceLogin<LoginModel>>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        viewModel = LoginViewModel(repository)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun invalidEmail() {
        viewModel.loginResponse.observeForever(observer)
        viewModel.login("04@", "login12345")
        Mockito.verify(observer).onChanged(null)
    }

    @Test
    fun invalidPassword(){
        viewModel.loginResponse.observeForever(observer)
        viewModel.login("somosmas@alkmey.org", "log5")
        Mockito.verify(observer).onChanged(null)
    }

    @Test
    fun emailFieldIsEmpty(){
        viewModel.loginResponse.observeForever(observer)
        viewModel.login("", "log5")
        Mockito.verify(observer).onChanged(null)
    }

    @Test
    fun passwordFieldIsEmpty(){
        viewModel.loginResponse.observeForever(observer)
        viewModel.login("somosmas@alkmey.org", "")
        Mockito.verify(observer).onChanged(null)
    }


    @Test
    fun allFieldIsEmpty(){
        viewModel.loginResponse.observeForever(observer)
        viewModel.login("", "")
        Mockito.verify(observer).onChanged(null)
    }

    //To verify with Token and user after validation
//    @Test
//    fun `when the email and the password is valid`(){
//        viewModel.loginResponse.observeForever(observer)
//        viewModel.login("somosmas@alkmey.org", "login12345")
//        Mockito.verify(observer).onChanged(ResourceLogin.Success())
//    }



}













