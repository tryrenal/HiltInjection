package com.example.hiltinjection.presenter.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.hiltinjection.R
import com.example.hiltinjection.presenter.extensions.observe
import com.example.hiltinjection.presenter.ui.adapter.LaunchesAdapter
import com.example.hiltinjection.presenter.ui.viewmodels.LaunchesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_launches.*

@AndroidEntryPoint
class LaunchesFragment : Fragment(R.layout.fragment_launches) {

    private val viewModel : LaunchesViewModel by viewModels()
    private val adapter by lazy { LaunchesAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inscribeObservers()
        recyclerView_launches.adapter = adapter
    }

    private fun inscribeObservers() {
        observe(viewModel.pagedListLaunch) {
            adapter.submitList(it)
        }
    }
}