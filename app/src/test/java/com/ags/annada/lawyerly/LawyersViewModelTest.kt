package com.ags.annada.lawyerly

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ags.annada.lawyerly.lawyers.LawyersViewModel
import com.ags.annada.lawyerly.model.Lawyer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class LawyersViewModelTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Captor
    lateinit var captor: ArgumentCaptor<ArrayList<Lawyer>>

    val observer: Observer<List<Lawyer>> = mock()
    private lateinit var sut: LawyersViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);
        sut = LawyersViewModel()
        sut.items.observeForever(observer)
    }

    @Test
    fun `test items livedata notifies when it is observed`() {
        captor.run {
            verify(observer, times(1)).onChanged(capture())
        }
    }
}