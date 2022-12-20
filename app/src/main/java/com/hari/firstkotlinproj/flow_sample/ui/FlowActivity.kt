package com.hari.firstkotlinproj.flow_sample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.hari.firstkotlinproj.databinding.FlowActivityBinding
import com.hari.firstkotlinproj.flow_sample.view_model.FlowViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FlowActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = FlowActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[FlowViewModel::class.java]
        binding.stateFlowBtn.setOnClickListener {

            viewModel.triggerStateFlow()
        }
        binding.sharedFlowBtn.setOnClickListener {

            viewModel.triggerSharedFlow()
        }

        val s = lifecycleScope.launch {

            viewModel.countDown.collect {
                time -> binding.coldFlowText.text = "Cold flow countdown is $time"
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.stateFlow.collectLatest {
                stateVal -> binding.stateFlowText.text = stateVal
            }
        }

        lifecycleScope.launchWhenStarted {
            viewModel.sharedFlow.collectLatest {
                stateVal -> binding.sharedFlowText.text = stateVal
            }
        }
    }
}