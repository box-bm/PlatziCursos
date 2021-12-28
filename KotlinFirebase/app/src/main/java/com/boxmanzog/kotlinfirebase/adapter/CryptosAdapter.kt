package com.boxmanzog.kotlinfirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.boxmanzog.kotlinfirebase.R
import com.boxmanzog.kotlinfirebase.model.Crypto
import com.squareup.picasso.Picasso

class CryptosAdapter(val cryptosAdapterListener: CryptosAdapterListener) :
    RecyclerView.Adapter<CryptosAdapter.ViewHolder>() {

    var cryptoList: List<Crypto> = ArrayList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image = view.findViewById<ImageView>(R.id.image)
        var name = view.findViewById<TextView>(R.id.nameTextView)
        var availableTextView = view.findViewById<TextView>(R.id.availableTextView)
        var buyBottom = view.findViewById<Button>(R.id.buyButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.crypto_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crypto = cryptoList[position]
        Picasso.get().load(crypto.imageUrl).into(holder.image)
        holder.name.text = crypto.name
        holder.availableTextView.text = holder.itemView.context.getString(
            R.string.available_message,
            crypto.available.toString()
        )
        holder.buyBottom.setOnClickListener {
            cryptosAdapterListener.onBuyCryptoClicked(crypto)
        }
    }

    override fun getItemCount(): Int {
        return cryptoList.size
    }

}