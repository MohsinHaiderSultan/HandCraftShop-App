package com.example.mohsinhaider.handcraftshop.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mohsinhaider.handcraftshop.model.repositories.HandCraftRepositories
import com.example.mohsinhaider.handcraftshop.ui.HandCraft
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val handCraftsRepository = HandCraftRepositories()

    val isSuccessfullySaved= MutableStateFlow<Boolean?>(null)
    val failureMessage = MutableStateFlow<String?>(null)
    val data = MutableStateFlow<String?>(null)

    init {
        readHandcrafts()
    }
    fun saveHandCraft(handCraft: HandCraft) {
        viewModelScope.launch {
            val result = handCraftsRepository.saveHandCraft(handCraft)
            if (result.isSuccess) {
                isSuccessfullySaved.value = true
            } else {
                failureMessage.value = result.exceptionOrNull()?.message
            }
        }
    }

    fun readHandcrafts() {
        viewModelScope.launch {
            handCraftsRepository.getHandCrafts().catch {
                failureMessage.value = it.message
            }
                .collect {
                    data.value= it.toString()
                }
        }
    }
}