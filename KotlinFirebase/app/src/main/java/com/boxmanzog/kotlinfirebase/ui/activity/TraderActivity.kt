package com.boxmanzog.kotlinfirebase.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.boxmanzog.kotlinfirebase.R
import com.boxmanzog.kotlinfirebase.adapter.CryptosAdapter
import com.boxmanzog.kotlinfirebase.adapter.CryptosAdapterListener
import com.boxmanzog.kotlinfirebase.model.Crypto
import com.boxmanzog.kotlinfirebase.network.Callback
import com.boxmanzog.kotlinfirebase.network.FirestoreService
import com.google.firebase.firestore.FirebaseFirestore

class TraderActivity : AppCompatActivity(), CryptosAdapterListener {
    lateinit var firestoreService: FirestoreService
    private val cryptosAdapter : CryptosAdapter = CryptosAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trader)

        firestoreService = FirestoreService(FirebaseFirestore.getInstance())
        configureRecyclerView()
        loadCryptos()

    }

    private fun loadCryptos() {
        firestoreService.getCryptos(object : Callback<List<Crypto>> {
            override fun onSuccess(result: List<Crypto>?) {
                this@TraderActivity.runOnUiThread{
                    cryptosAdapter.cryptoList = result!!
                    cryptosAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailed(exception: Exception) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun configureRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = cryptosAdapter
    }

    fun showGeneralServerErrorMessage() {

    }

    override fun onBuyCryptoClicked(crypto: Crypto) {

    }
}