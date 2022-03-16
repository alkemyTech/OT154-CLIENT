package com.melvin.ongandroid.view.signup_user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verifyOrder
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class SignUpUserViewModelTest : TestCase(), LifecycleOwner {


    @RelaxedMockK
    private var _buttonRegisterIsEnabled: MutableLiveData<Boolean> = MutableLiveData()

    @RelaxedMockK
    var _errorMsgIsEnabled: MutableLiveData<Boolean> = MutableLiveData()


    private lateinit var signUpUserViewModel: SignUpUserViewModel
    private lateinit var booleanObserver: Observer<Boolean>
    private val registry = LifecycleRegistry(this)

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    override fun setUp() {
        super.setUp()
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        signUpUserViewModel = SignUpUserViewModel()
    }


    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    override fun getLifecycle(): Lifecycle {
        return registry
    }

    fun onCreate() {
        registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    fun onResume() {
        registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    fun onDestroy() {
        registry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testButtonRegisterIsEnabledWhenNameIsEmptyReturnFalse() = runTest {
        signUpUserViewModel.validateButtonRegister(NAME, EMAIL, PASS, PASS_CONFIRM)
        Mockito.`when`(signUpUserViewModel.buttonRegisterIsEnabled.apply {
            observeForever(booleanObserver)
            verifyOrder {
                booleanObserver.onChanged(false)
            }
        })

    }


    companion object {
        const val EMAIL = "email"
        const val NAME = "name"
        const val PASS = "pass"
        const val PASS_CONFIRM = "pass"

    }
}

//class SignUpUserViewModelTest : TestCase(), LifecycleOwner {

//    @get:Rule
//        val instantExecutorRule = InstantTaskExecutorRule()
//
//    private lateinit var signUpUserViewModel: SignUpUserViewModel
//   @RelaxedMockK
//    private lateinit var booleanObserver: Observer<Boolean>
//    private val registry = LifecycleRegistry(this)
//    private val testDispatcher = TestCoroutineDispatcher()
//
//
//    @Before
//    override fun setUp() {
//        super.setUp()
//        MockKAnnotations.init(this)
//        Dispatchers.setMain(testDispatcher)
//
//        signUpUserViewModel = SignUpUserViewModel()
//       // onCreate()
//        signUpUserViewModel.buttonRegisterIsEnabled.observeForever(booleanObserver)
//
//    }
//
//    override fun getLifecycle(): Lifecycle {
//        return registry
//    }
//
//    fun onCreate() {
//        registry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
//    }
//
//    fun onResume() {
//        registry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    }
//
//    fun onDestroy() {
//        registry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
//    }
//
//    @Test
//    fun testButtonRegisterIsEnabledWhenNameIsEmptyReturnFalse() = testDispatcher.runBlockingTest {
//        //onResume()
//        signUpUserViewModel.validateButtonRegister("", EMAIL, PASS, PASS_CONFIRM)
//        verifyOrder { booleanObserver.onChanged(false)
//        }
//    }
//
//
//    companion object {
//        const val EMAIL = "email"
//        const val NAME = "name"
//        const val PASS = "pass"
//        const val PASS_CONFIRM = "pass"
//
//    }

