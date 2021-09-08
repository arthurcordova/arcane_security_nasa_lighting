package com.arcanesecurity.nasalighting.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import com.arcanesecurity.nasalighting.R
import com.arcanesecurity.nasalighting.model.LightingStrike
import com.arcanesecurity.nasalighting.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.main_fragment) {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private val observerLights = Observer<List<LightingStrike>> {
        //todo: uses d=the it (List<LightingStrike>) to do something here
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.lights.observe(viewLifecycleOwner, observerLights)

        /**
         * Trigger to call NASA endpoint
         */
        viewModel.fetchLights()
    }

}