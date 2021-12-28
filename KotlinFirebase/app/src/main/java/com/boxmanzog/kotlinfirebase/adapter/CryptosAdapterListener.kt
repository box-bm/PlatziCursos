package com.boxmanzog.kotlinfirebase.adapter

import com.boxmanzog.kotlinfirebase.model.Crypto

interface CryptosAdapterListener{
    fun onBuyCryptoClicked(crypto: Crypto)
}