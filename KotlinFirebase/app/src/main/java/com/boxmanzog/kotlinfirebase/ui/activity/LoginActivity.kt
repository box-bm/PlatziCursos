package com.boxmanzog.kotlinfirebase.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.boxmanzog.kotlinfirebase.R
import com.boxmanzog.kotlinfirebase.model.User
import com.boxmanzog.kotlinfirebase.network.Callback
import com.boxmanzog.kotlinfirebase.network.FirestoreService
import com.boxmanzog.kotlinfirebase.network.USERS_COLLECTION_NAME
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"
    private val AUTH: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var firestoreService: FirestoreService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firestoreService = FirestoreService(FirebaseFirestore.getInstance())
    }


    fun onStartClicked(view: View) {
        view.isEnabled = false
        AUTH.signInAnonymously()
            .addOnCompleteListener {
                task ->
                if(task.isSuccessful) {
                    val username = findViewById<EditText>(R.id.username).text.toString()

                    firestoreService.findUserbyId(username, object : Callback<User> {
                        override fun onSuccess(result: User?) {
                            if(result == null) {
                                val user = User()
                                user.username = username
                                saveUserAndStartMainActivity(user, view)
                            } else {
                                startMainActivity(username)
                            }
                        }

                        override fun onFailed(exception: Exception) {
                            showErrorMessage(view)
                            view.isEnabled = true
                        }

                    })
                } else {
                    showErrorMessage(view)
                    view.isEnabled = true
                }
            }
    }

    private fun saveUserAndStartMainActivity(user: User, view: View) {
        firestoreService.setDocument(user, USERS_COLLECTION_NAME, user.username, object : Callback<Void> {
            override fun onSuccess(result: Void?) {
                startMainActivity(user.username)
            }

            override fun onFailed(exception: Exception) {
                showErrorMessage(view)
                Log.e(TAG, "error $exception")
                view.isEnabled = true
            }

        })
    }

    private fun showErrorMessage(view: View) {
        Snackbar.make(view, getString(R.string.error_while_connecting_to_the_server), Snackbar.LENGTH_LONG)
            .setAction("Info", null).show()
    }

    private fun startMainActivity(username: String) {
        val intent = Intent(this@LoginActivity, TraderActivity::class.java)
        intent.putExtra("USERNAME_KEY", username)
        startActivity(intent)
        finish()
    }
}