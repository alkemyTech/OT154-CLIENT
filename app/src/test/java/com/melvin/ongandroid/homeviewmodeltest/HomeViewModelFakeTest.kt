///**
// * Clase para realizar unittest de la clase HomeViewModel
// *
// * @author Martin Re
// */
//
package com.melvin.ongandroid.homeviewmodeltest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.melvin.ongandroid.data.repository.GetActivitiesInteractor
import com.melvin.ongandroid.data.local.model.ActivityModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelFakeTest {

    @ExperimentalCoroutinesApi
    class HomeViewModelFakeTest {

        private lateinit var homeViewModel: HomeViewModelFake

        @RelaxedMockK
        private lateinit var interactor: GetActivitiesInteractor

        @get:Rule
        var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

        @Before
        fun setUp() {
            MockKAnnotations.init(this)

            homeViewModel = HomeViewModelFake()

            homeViewModel.setActivitiesInteractor(interactor)

            Dispatchers.setMain(Dispatchers.Unconfined)
        }


        @After
        fun onAfter() {
            Dispatchers.resetMain()
        }

        @Test
        fun `when list activities is empty, hide carousel (set property isGone = true)`() =
            runTest {

                coEvery { interactor() } returns emptyList()

                homeViewModel.getListActivities()

                assert(homeViewModel.carouselIsgone.value == true)

            }


        @Test
        fun `validate that list activities is not empty`() = runTest {
            coEvery { interactor() } returns getListActivitiesFromInteractor()

            homeViewModel.getListActivities()

            homeViewModel.activities.value?.let { assert(it.isNotEmpty()) }

        }


        @Test
        fun `when list activities is not empty, set and load carousel`() = runTest {

            val carouselist: List<CarouselItem> = listOf(
                CarouselItem("https://imagemusica.jpg", "CLASE DE MUSICA"),
                CarouselItem("https://imagearte.jpg", "CLASE DE ARTE")
            )

            coEvery { interactor() } returns getListActivitiesFromInteractor()

            homeViewModel.getListActivities()

            assert(homeViewModel.activities.value == carouselist)

        }


        private fun getListActivitiesFromInteractor(): List<ActivityModel> {
            return listOf(
                ActivityModel(
                    "24-2-2022", null, "activity1", null, 958,
                    "https://imagemusica.jpg", "clase de musica", 2, "24-2-2022", null
                ),
                ActivityModel(
                    "24-2-2022", null, "activity1", null, 958,
                    "https://imagearte.jpg", "clase de arte", 2, "24-2-2022", null
                )
            )
        }
    }
}