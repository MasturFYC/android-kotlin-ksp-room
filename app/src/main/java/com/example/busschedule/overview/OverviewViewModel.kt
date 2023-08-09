package com.example.busschedule.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.busschedule.network.Customer
import com.example.busschedule.network.SapuLidiApi
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {
    // The internal MutableLiveData that stores the status of the most recent request
    private val _customer = MutableLiveData<List<Customer>>()
    // The external immutable LiveData for the request status
    val customer: LiveData<List<Customer>> = _customer
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getCustomers("")
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */

    private fun getCustomers(txt: String) {
        viewModelScope.launch {
            try {
                val listResult = SapuLidiApi.retrofitService.getCustomers(txt)
                _customer.value = listResult
            } catch (e: Exception) {
                _customer.value = listOf()
            }
        }
    }

}