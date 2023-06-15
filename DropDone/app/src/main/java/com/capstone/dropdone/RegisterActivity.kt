package com.capstone.dropdone

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstone.dropdone.databinding.ActivityRegisterBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseFirestore: FirebaseFirestore
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseFirestore = FirebaseFirestore.getInstance()

        if (firebaseAuth.currentUser != null) {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        binding.toLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            val confirmPass = binding.editPasswordConfrim.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                binding.editEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                binding.editPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.editPassword.error = "Password minimal 6 karakter"
                return@setOnClickListener
            }

            if (!password.equals(confirmPass)) {
                binding.editPasswordConfrim.error = "Password Tidak Cocok"
                return@setOnClickListener
            }

            registerFirebase(email, password)
        }
    }

    private fun registerFirebase(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this@RegisterActivity, "Register Berhasil", Toast.LENGTH_SHORT).show()

                    userId = firebaseAuth.currentUser?.uid
                    val documentReference: DocumentReference =
                        firebaseFirestore.collection("users").document(userId!!)
                    val user: MutableMap<String, Any> = HashMap()
                    user["username"] = binding.editUserName.text.toString()
                    user["email"] = binding.editEmail.text.toString()
                    documentReference.set(user).addOnSuccessListener(OnSuccessListener<Void?> {
                        Log.d(TAG, "onSuccess: user Profile is Created for $userId")
                    })

                    startActivity(Intent(applicationContext, LoginActivity::class.java))
                } else {
                    Toast.makeText(this@RegisterActivity, "Registrasi Gagal", Toast.LENGTH_LONG).show()
                }
            }
    }

    companion object {
        private const val TAG = "RegisterActivity"
    }
}
