package com.melvin.ongandroid.view.signup_user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.*
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verifyOrder
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SignUpUserViewModelTest : TestCase(), LifecycleOwner {



    @RelaxedMockK
    private var _buttonRegisterIsEnabled: MutableLiveData<Boolean> = MutableLiveData()
    @RelaxedMockK
    private val _errorMsgIsEnabled: MutableLiveData<Boolean> = MutableLiveData()


    private lateinit var signUpUserViewModel: SignUpUserViewModel
    private lateinit var booleanObserver: Observer<Boolean>
    private val registry = LifecycleRegistry(this)

    @get:Rule
    var rule:InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    override fun setUp() {
        super.setUp()
        MockKAnnotations.init(this)
//        Dispatchers.setMain(testDispatcher)

        Dispatchers.setMain(Dispatchers.Unconfined)
        signUpUserViewModel = SignUpUserViewModel()
    }


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

    @Test
    fun testButtonRegisterIsEnabledWhenNameIsEmptyReturnFalse() = runTest {
        signUpUserViewModel.validateButtonRegister("", EMAIL, PASS, PASS_CONFIRM)
        signUpUserViewModel.buttonRegisterIsEnabled.apply {
            observeForever(booleanObserver)
        }
        verifyOrder {
            booleanObserver.onChanged(false)


        }
    }


    companion object {
        const val EMAIL = "email"
        const val NAME = "name"
        const val PASS = "pass"
        const val PASS_CONFIRM = "pass"

    }

//    @ExperimentalCoroutinesApi
//    class ContactUsViewModelTest {
//        @get:Rule
//        val instantExecutorRule = InstantTaskExecutorRule()
//
//        private lateinit var viewModel: ContactUsViewModel
//
//        @MockK
//        lateinit var repository: ContactRepository
//
//        @RelaxedMockK
//        lateinit var contactStateObserver: Observer<DataState<Contact>>
//
//
//        private val testDispatcher = TestCoroutineDispatcher()
//
//        private lateinit var lifeCycleTestOwner: LifeCycleTestOwner
//
//        @Before
//        fun setUp() {
//            MockKAnnotations.init(this)
//            Dispatchers.setMain(testDispatcher)
//            lifeCycleTestOwner = LifeCycleTestOwner()
//            lifeCycleTestOwner.onCreate()
//            viewModel = ContactUsViewModel(
//                repository
//            )
//            viewModel.contacts.observe(lifeCycleTestOwner, contactStateObserver)
//        }
//
//        @Test
//        fun `save contats test, when is called, then return success flow`() =
//            testDispatcher.runBlockingTest {
//
//                // GIVEN
//                lifeCycleTestOwner.onResume()
//
//
//                val contact = mockk<Contact>(relaxed = true)
//
//                coEvery { repository.saveContact(contact) } returns
//                        flowOf(
//                            Response.Loading,
//                            Response.Success(data = contact),
//                        )
//
//                // WHEN
//                viewModel.saveContact(contact)
//
//                // THEN
//                coVerify(exactly = 1) { repository.saveContact(contact) }
//
//
//                verifyOrder {
//                    contactsStateObserver.onChanged(DataState.Idle)
//                    contactsStateObserver.onChanged(DataState.Loading(true))
//                    contactsStateObserver.onChanged(DataState.Success(response.data))
//                }
//            }
//    }
}

