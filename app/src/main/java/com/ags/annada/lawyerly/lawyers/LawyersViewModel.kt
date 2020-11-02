package com.ags.annada.lawyerly.lawyers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ags.annada.lawyerly.Event
import com.ags.annada.lawyerly.data.LawyersRepository
import com.ags.annada.lawyerly.model.Lawyer

class LawyersViewModel : ViewModel() {
    private var _items: MutableLiveData<List<Lawyer>> = MutableLiveData()

    val items: LiveData<List<Lawyer>> = _items

    private val _openDetailsEvent = MutableLiveData<Event<Int>>()
    val openDetailsEvent: LiveData<Event<Int>> = _openDetailsEvent

    private val repository = LawyersRepository()

    init {
        _items.value = repository.getLawyersList()
    }

    fun openLawyerDetails(lawyerId: Int) {
        _openDetailsEvent.value = Event(lawyerId)
    }

    fun sortByLawyers() {
        //Sory By Lawyer
    }

    fun filterLawyers() {
        //Filter Lawyers
    }
}