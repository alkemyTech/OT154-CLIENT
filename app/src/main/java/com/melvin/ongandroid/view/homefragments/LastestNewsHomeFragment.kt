package com.melvin.ongandroid.view.homefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.melvin.ongandroid.databinding.FragmentLastestNewsHomeBinding
import com.melvin.ongandroid.viewmodel.LastestNewsViewModel

class LastestNewsHomeFragment : Fragment() {

    private var _binding: FragmentLastestNewsHomeBinding? = null
    private val binding get() = _binding!!

    private val lastestNewsViewModel: LastestNewsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLastestNewsHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.lastestNewsCarousel.addData(lastestNewsViewModel.addItems())
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}