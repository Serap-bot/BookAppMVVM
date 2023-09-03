package com.serapbekar.bookappmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serapbekar.bookappmvvm.common.viewBinding
import com.serapbekar.bookappmvvm.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}