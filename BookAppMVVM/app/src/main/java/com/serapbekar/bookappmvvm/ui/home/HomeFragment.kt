package com.serapbekar.bookappmvvm.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.serapbekar.bookappmvvm.R
import com.serapbekar.bookappmvvm.databinding.FragmentHomeBinding
import com.serapbekar.bookappmvvm.common.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), BookAdapter.BookListener {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModels<HomeViewModel>()
    private val bookAdapter by lazy { BookAdapter(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBooks.adapter = bookAdapter
        viewModel.getBooks()
        observeData()
    }

    private fun observeData() {
        viewModel.loadingLiveData.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it
        }

        viewModel.booksLiveData.observe(viewLifecycleOwner) { list ->
            if (list != null) {
                bookAdapter.submitList(list)
            }else{
                Snackbar.make(requireView(), "Empty List!", 1000).show()
            }
        }
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            Snackbar.make(requireView(), it, 1000).show()
        }
    }

    override fun onBookClick(id: Int) {
        val action = HomeFragmentDirections.homeToDetail(id)
        findNavController().navigate(action)
    }
}