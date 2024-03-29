package com.akashsoam.firestorelearn

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var saveButton: Button
    private lateinit var loadButton: Button
    private lateinit var textViewData: TextView

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val docRef: DocumentReference = db.collection("Notebook").document("My first note")
    private val KEY_TITLE = "title"
    private val KEY_DESCRIPTION = "description"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextTitle = findViewById(R.id.edit_text_title)
        editTextDescription = findViewById(R.id.edit_text_description)
        saveButton = findViewById(R.id.button_save)
        loadButton = findViewById(R.id.button_load)

        saveButton.setOnClickListener {
            saveNote()
        }
        loadButton.setOnClickListener {
            loadData()
        }
    }


    private fun saveNote() {
        val title = editTextTitle.text.toString()
        val description = editTextDescription.text.toString()

        val note = mutableMapOf<String, Any>()
        note[KEY_TITLE] = title
        note[KEY_DESCRIPTION] = description

        docRef.set(note).addOnSuccessListener {
            Toast.makeText(
                this@MainActivity,
                "note added successfully!",
                Toast.LENGTH_SHORT
            ).show()
        }.addOnFailureListener {
            Toast.makeText(
                this@MainActivity,
                "Could NOT add the note",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun loadData() {
        docRef.get().addOnSuccessListener { document ->

            val title = document.getString(KEY_TITLE)
            val description = document.getString(KEY_DESCRIPTION)
            val note = mutableMapOf<String, Any>()
            note["title"] = title!!
            note["description"] = description!!
        }.addOnFailureListener {
            Toast.makeText(this@MainActivity, "retrieval NOT successfull!", Toast.LENGTH_SHORT)
                .show()
        }
    }


}