package com.example.pwassignment.domain.use_case

import android.util.Log.e
import com.example.pwassignment.common.Resource
import com.example.pwassignment.data.dto.StudentDashboard
import com.example.pwassignment.domain.repository.StudentDashboardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StudentDashboardUseCase @Inject constructor(
    private val repository: StudentDashboardRepository
) {
    operator fun invoke(token: String): Flow<Resource<StudentDashboard>> = flow {
        try {

            emit(Resource.Loading<StudentDashboard>())
            val studentDashboardResponse = repository.getDashboardData(token)

            if (studentDashboardResponse.body() != null) {
                emit(
                    Resource.Success<StudentDashboard>(
                        studentDashboardResponse.body() ?: StudentDashboard()
                    )
                )
            }
            else {
                emit(
                    Resource.Error<StudentDashboard>(
                        "Data not found"
                    )
                )
            }
        } catch (e: retrofit2.HttpException) {
            emit(
                Resource.Error<StudentDashboard>(
                    e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: java.io.IOException) {
            emit(Resource.Error<StudentDashboard>("Couldn't reach server. Check your internet connection"))
        } catch (e: Exception) {
            emit(Resource.Error<StudentDashboard>(message = "Unexpected Error Occurred"))
        }
    }
}