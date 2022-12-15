package com.hari.firstkotlinproj.view_binding

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.hari.firstkotlinproj.databinding.ViewBindingSampleBinding

class ViewBindingSample: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ViewBindingSampleBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        var numberOfClicks = 0;
        binding.doneButton.setOnClickListener {
            Snackbar.make(binding.root, "${++numberOfClicks} time(s) done clicked", Snackbar.LENGTH_LONG).show()
            binding.sampleText.text = "${numberOfClicks} time(s) done clicked"
        }
    }
}