package com.example.praktikummodul6

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.praktikummodul6.databinding.ItemNoteBinding

class NotesAdapter: RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    lateinit var onItemClick: ((Notes) -> Unit)
    lateinit var onDeleteClick: ((Notes) -> Unit)

    var noteList = arrayListOf<Notes>()

    fun setNotes(notes: ArrayList<Notes>) {
        noteList.clear()
        noteList.addAll(notes)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var note = noteList[position]
        holder.binding.tvTitle.text = note.title

        holder.itemView.setOnClickListener {
            onItemClick.invoke(note)
        }

        holder.binding.btnDelete.setOnClickListener {
            onDeleteClick.invoke(note)
        }
    }
}