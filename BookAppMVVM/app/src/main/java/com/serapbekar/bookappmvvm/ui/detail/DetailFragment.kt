package com.serapbekar.bookappmvvm.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.serapbekar.bookappmvvm.R
import com.serapbekar.bookappmvvm.common.viewBinding
import com.serapbekar.bookappmvvm.databinding.FragmentDetailBinding
import com.serapbekar.bookappmvvm.common.invisible
import com.serapbekar.bookappmvvm.common.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBookDetail(args.id)
        observeData()
    }

    private fun observeData() = with(binding){
        viewModel.loadingLiveData.observe(viewLifecycleOwner) {
            binding.progressBar.isVisible = it }

        viewModel.bookDetailLiveData.observe(viewLifecycleOwner) { book ->
            if (book != null) {
                val bookTop = book.isBestSeller
                if(bookTop == true) {
                    ivTop.visible()
                }else{
                    ivTop.invisible()
                }
                tvName.text = book.name
                tvAuthor.text = book.author
                tvPublisher.text = book.publisher
                tvPrice.text = "${book.price} TL"
                com.bumptech.glide.Glide.with(ivBook.context).load(book.imageUrl).into(ivBook)
            }else{
                Snackbar.make(requireView(), "Book not found!", 1000).show()
            }
        }
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner) {
            Snackbar.make(requireView(), it, 1000).show()
        }
    }
}
