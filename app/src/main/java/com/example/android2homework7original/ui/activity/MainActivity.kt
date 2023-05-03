package com.example.android2homework7original.ui.activity

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android2homework7original.databinding.ActivityMainBinding
import com.example.android2homework7original.models.TextModel
import com.example.android2homework7original.ui.adapters.TextAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val db = Firebase.firestore
    private val list: ArrayList<TextModel> = ArrayList()
    private val textAdapter = TextAdapter()
    private val collectionRef = db.collection("user")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListener()
        initialize()
        setData()
    }

    private fun setData() {
        collectionRef.get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    list.add(document.data["name"] as TextModel)
                }
                TextAdapter.setList(list)
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }


    private fun initialize() {
        binding.recyclerViewText.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = textAdapter
        }
    }

    private fun setUpListener() {
        binding.button.setOnClickListener {
            val messageEt = binding.editText.text.toString()

            val user = hashMapOf(
                "name" to messageEt
            )
            db.collection("user").add(user).addOnSuccessListener {
                Toast.makeText(this, "add items", Toast.LENGTH_SHORT).show()
            }
        }
    }
}