package com.serapbekar.bookappmvvm.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.serapbekar.bookappmvvm.data.model.Books
import com.serapbekar.bookappmvvm.databinding.ItemBookBinding
import com.serapbekar.bookappmvvm.common.invisible
import com.serapbekar.bookappmvvm.common.visible

class BookAdapter(private val bookListener: BookListener) : ListAdapter<Books, BookAdapter.BookViewHolder>(
    BookDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            BookViewHolder = BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false), bookListener)

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) { holder.bind(getItem(position)) }

    class BookViewHolder(private val binding: ItemBookBinding, private val bookListener: BookListener): RecyclerView.ViewHolder(binding.root) {
        fun bind(books: Books) = with(binding){

            tvName.text = books.name
            tvPrice.text = "${books.price} TL"
            val bookTop = books.isBestSeller

            if(bookTop == true) {
                ivTop.visible()
            }else{
                ivTop.invisible()
            }

            Glide.with(ivBook.context).load(books.imageUrl).into(ivBook)
            root.setOnClickListener {
                bookListener.onBookClick(books.id?:1)
            }
        }
    }

    //Liste tanımlamaktan, update işlemi yapmaktan kurtarır
    class BookDiffCallBack : DiffUtil.ItemCallback<Books>() {
        override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
            return oldItem == newItem
        }
    }

    interface BookListener {
        fun onBookClick(id: Int)

    }
}