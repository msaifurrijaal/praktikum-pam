package com.example.praktikummodul6

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.praktikummodul6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val INTENT_ITEM = "intent_item"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var notesAdapter: NotesAdapter
    private var listNotes = arrayListOf<Notes>(
        Notes("Catatan Uang Harian", "Harus hemat kalo mau jajan yaaa...."),
        Notes("UTS BULAN APRIL", "Persiapan belajar buat UTS semoga sukses!"),
        Notes("Tugas Praktikum PAM", "Kerjakan Tugas praktikum PAM Modul 6"),
        Notes("Belajar Pemrograman Android", "Belajar materi Service dan geo Location Android"),
        Notes("Target 6 Bulan kedepan", "Ini adalah targetku dalam 6 bulan kedepan..."),
        Notes("Bahan Belajar", "Catatan untuk bahan belajar"),
        Notes("Alamat penting", "Kumpulan alamat penting"),
        Notes("Catatan uang mingguan", "Harus hemat kalo mau jajan yaaa...."),
        Notes("Notes contoh aja", "Contoh doangg......")
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setTitle("Notes App")
        setNotesRV()
        onAction()
    }

    private fun onAction() {
        binding.fabAdd.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            val view = layoutInflater.inflate(R.layout.dialog_add_note, null)
            alert.apply {
                setView(view)
                setCancelable(false)
                setTitle("Add New Note")
                setPositiveButton(
                    "Save", DialogInterface.OnClickListener { dialogInterface, i ->
                        val title = view.findViewById<EditText>(R.id.et_title)
                        val note = view.findViewById<EditText>(R.id.et_note)
                        var newNote = Notes(title.text.toString(), note.text.toString())
                        listNotes.add(0, newNote)
                        notesAdapter.setNotes(listNotes)
                })
                setNegativeButton(
                    "Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                    }
                )
            }
            alert.show()
        }

        notesAdapter.onItemClick = {
            startActivity(
                Intent(this@MainActivity, DetailActivity::class.java)
                    .putExtra(INTENT_ITEM, it)
            )
        }

        notesAdapter.onDeleteClick = { note ->
            listNotes.remove(note)
            notesAdapter.setNotes(listNotes)
        }
    }

    private fun setNotesRV() {
        notesAdapter = NotesAdapter()
        binding.rvNotes.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = notesAdapter
        }

        notesAdapter.setNotes(listNotes)
    }

}