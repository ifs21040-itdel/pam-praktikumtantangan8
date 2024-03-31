package com.ifs21040.tantanganprak8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifs21040.tantanganprak8.databinding.ItemMessageBinding

class ListMessageAdapter(private val listMessage: ArrayList<Message>) :
    RecyclerView.Adapter<ListMessageAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder {
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val message = listMessage[position]
        holder.bind(message)
    }

    override fun getItemCount(): Int = listMessage.size

    inner class ListViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) {
            with(binding) {
                itemmessage.setImageResource(message.icon)
                messageitem.text = message.name
                imageView4.setImageResource(message.icon2)

                // Tambahkan event listener untuk item di sini
                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(message)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Message)
    }
}
