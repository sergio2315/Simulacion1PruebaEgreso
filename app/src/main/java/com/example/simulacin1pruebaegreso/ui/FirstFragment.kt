package com.example.simulacin1pruebaegreso.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simulacin1pruebaegreso.R
import com.example.simulacin1pruebaegreso.databinding.FragmentFirstBinding
import com.example.simulacin1pruebaegreso.viewModel.BooksViewModel

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel: BooksViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BooksAdapter()
        binding.rvBooks.adapter = adapter
        binding.rvBooks.layoutManager = LinearLayoutManager(context)
        viewModel.booksLiveDataDB.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("listado", it.toString())
                adapter.update(it)
            }
        })
    }
}