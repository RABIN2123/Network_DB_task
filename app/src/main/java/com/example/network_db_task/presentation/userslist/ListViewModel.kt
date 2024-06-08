package com.example.network_db_task.presentation.userslist

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.network_db_task.domain.MainRepository
import com.example.network_db_task.data.localdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(private val mainRepository: MainRepository, private val requireContext: Context?) : ViewModel() {
    private val _usersFlow = MutableStateFlow(User())
    val userState: StateFlow<User> = _usersFlow

    init {
        initData()
    }

    private fun initData() {
        viewModelScope.launch(Dispatchers.IO) {
            val newList = mainRepository.getUsers()
            _usersFlow.update {
                it.copy(
                    list = newList
                )
            }
            async {
                mainRepository.saveInLocalDb(newList)
            }
            async {
                requireContext?.let {context ->
                    newList.forEach { item ->
                        Glide.with(context).downloadOnly().load(item.picUrl).submit()
                    }
                }
            }
        }
    }


    companion object {
        fun provideFactory(
            mainRepository: MainRepository,
            requireContext: Context?
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ListViewModel(mainRepository, requireContext) as T
            }
        }
    }
}