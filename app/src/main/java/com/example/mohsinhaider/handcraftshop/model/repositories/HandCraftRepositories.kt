package com.example.mohsinhaider.handcraftshop.model.repositories

import com.example.mohsinhaider.handcraftshop.ui.HandCraft
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.snapshots
import com.google.firebase.firestore.toObjects
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await

class HandCraftRepositories {
    val handCraftCollection= FirebaseFirestore.getInstance().collection("Handcrfts")

    suspend fun saveHandCraft(handCraft: HandCraft):Result<Boolean>{
        try {
            val document = handCraftCollection.document()
            handCraft.id= document.id
            document.set(handCraft).await()
            return Result.success(true)
        }catch (e:Exception){
            return Result.failure(e)
        }
    }

    fun getHandCrafts()=handCraftCollection.snapshots().map { it.toObjects(HandCraft::class.java) }
}