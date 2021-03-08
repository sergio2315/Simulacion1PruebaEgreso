package com.example.simulacin1pruebaegreso.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacin1pruebaegreso.databinding.BooksItemListBinding
import com.example.simulacin1pruebaegreso.model.pojo.Books

class BooksAdapter: RecyclerView.Adapter<BooksAdapter.BooksAdapterVH>() {
    private var listBooks = listOf<Books>()
    private val selectedItem  =  MutableLiveData<Books>()

    fun selectedItem() = selectedItem
    fun update(list: List<Books>) {
        listBooks = list
        notifyDataSetChanged()
    }

    inner class BooksAdapterVH(private val binding: BooksItemListBinding)
        :RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(books: Books) {
            Glide.with(binding.imageView).load(books.imageLink).centerCrop().into(binding.imageView)
            binding.txTitle.text = books.title
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedItem().value = listBooks[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksAdapterVH {
        return BooksAdapterVH(BooksItemListBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: BooksAdapterVH, position: Int) {
        val books = listBooks[position]
        holder.bind(books)
    }
    override fun getItemCount(): Int = listBooks.size

}