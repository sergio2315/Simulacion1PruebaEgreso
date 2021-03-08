package com.example.simulacin1pruebaegreso.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.simulacin1pruebaegreso.R
import com.example.simulacin1pruebaegreso.databinding.FragmentSecondBinding
import com.example.simulacin1pruebaegreso.viewModel.BooksViewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val viewModel : BooksViewModel by activityViewModels()
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                viewModel.getDetailBooksByID(it.id).observe(viewLifecycleOwner, Observer {
                    Glide.with(binding.imageView2).load(it.imageLink).centerCrop().into(binding.imageView2)
                    binding.textView.text = it.language
                })
            }
        })
    }
}