package com.melvin.ongandroid.view.testimonial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import com.melvin.ongandroid.databinding.FragmentTestimonialsBinding
import com.melvin.ongandroid.model.Testimonial
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.mig35.carousellayoutmanager.CenterScrollListener

class TestimonialsFragment : Fragment() {
    private lateinit var binding: FragmentTestimonialsBinding
    private lateinit var adapterTestimonials: TestimonialsAdapter
    private val testimonialList: MutableList<Testimonial> = mutableListOf(
        Testimonial(
            1,
            "Javier",
            "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
            "asdasdasdaasdasd ad ad asd asd asd"
        ),
        Testimonial(
            2,
            "Javier",
            "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
            "asdasdasdaasdasd ad ad asd asd asd"
        ),
        Testimonial(
            3,
            "Javier",
            "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
            "asdasdasdaasdasd ad ad asd asd asd"
        ),
        Testimonial(4, "Javier", "", "asdasdasdaasdasd ad ad asd asd asd"),
        Testimonial(
            5,
            "Javier",
            "https://www.gravatar.com/avatar/205e460b479e2e5b48aec07710c08d50",
            "asdasdasdaasdasd ad ad asd asd asd"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        adapterTestimonials.setTestimonials(testimonialList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestimonialsBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupRecyclerView() {
        adapterTestimonials = TestimonialsAdapter()
        with(binding.rvTestimonial) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
            adapter = adapterTestimonials
        }
    }
}