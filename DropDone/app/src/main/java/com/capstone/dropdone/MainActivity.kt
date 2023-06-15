package com.capstone.dropdone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var btnLogout: Button

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        btnLogout = findViewById(R.id.btnLogout)

        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser!=null) {
            textView.text = firebaseUser.displayName
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}