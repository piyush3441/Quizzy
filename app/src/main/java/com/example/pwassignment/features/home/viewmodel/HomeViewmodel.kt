package com.example.pwassignment.features.home.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pwassignment.common.Resource
import com.example.pwassignment.domain.use_case.StudentDashboardUseCase
import com.example.pwassignment.features.home.state.StudentDashboardState
import com.example.pwassignment.utils.AppConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewmodel @Inject constructor(
    private val dashboardDataUseCase: StudentDashboardUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StudentDashboardState())
    val studentDashboardState: State<StudentDashboardState> = _state

    init {
        // call the api here
        fetchDashboardData()
    }

    fun fetchDashboardData() {
        dashboardDataUseCase.invoke(AppConstants.API_TOKEN).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = StudentDashboardState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = StudentDashboardState(studentDashboard = result.data)
                }

                is Resource.Error -> {
                    _state.value = StudentDashboardState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }

            }
        }.launchIn(viewModelScope)
    }
}