package com.ags.annada.lawyerly.lawyerdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ags.annada.lawyerly.data.LawyersRepository

class LawyerDetailViewModel : ViewModel() {
    private val repository = LawyersRepository()

    private var _lawyerId: MutableLiveData<Int> = MutableLiveData()
    val lawyerId: LiveData<Int> = _lawyerId

    val lawyerName = Transformations.map(lawyerId){ repository.getLawyerDetails(it)?.name}
    val lawyerSpeciality = Transformations.map(lawyerId){ repository.getLawyerDetails(it)?.speciality}
    val lawyerImage = Transformations.map(lawyerId){ repository.getLawyerDetails(it)?.image}
    val rating = Transformations.map(lawyerId){ repository.getLawyerDetails(it)?.rating}
    val price = Transformations.map(lawyerId){ repository.getLawyerDetails(it)?.price}
    val verified = Transformations.map(lawyerId){ repository.getLawyerDetails(it)?.verified}

    fun setLawyerId(lawyerId: Int) {
        _lawyerId.value = lawyerId
    }
}