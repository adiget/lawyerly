package com.ags.annada.lawyerly.data

import com.ags.annada.lawyerly.model.Lawyer

class LawyersRepository {
    var lawyers = mutableListOf<Lawyer>()

    init {
        lawyers.add(Lawyer(1, "Lawyer 1", "Speciality", "lawyer1",4.8f, "£60.90", true ))
        lawyers.add(Lawyer(2, "Lawyer 2", "Speciality", "lawyer2",4.5f, "£55.50", false))
        lawyers.add(Lawyer(3, "Lawyer 3", "Speciality", "lawyer3",4.1f, "£90.00", true))
        lawyers.add(Lawyer(4, "Lawyer 4", "Speciality", "lawyer4",4.6f, "£65.50", true))
        lawyers.add(Lawyer(5, "Lawyer 5", "Speciality", "lawyer5",4.5f, "£100.50", false))
        lawyers.add(Lawyer(6, "Lawyer 6", "Speciality", "lawyer1",4.8f, "£60.90", true))
        lawyers.add(Lawyer(7, "Lawyer 7", "Speciality", "lawyer2",4.9f, "£55.50", false))
        lawyers.add(Lawyer(8, "Lawyer 8", "Speciality", "lawyer3",5.1f, "£90.00", true))
    }

    fun getLawyersList(): List<Lawyer> {
        return lawyers
    }

    fun getLawyerDetails(lawyerId: Int): Lawyer? {
        return lawyers.find { it.id == lawyerId }
    }
}