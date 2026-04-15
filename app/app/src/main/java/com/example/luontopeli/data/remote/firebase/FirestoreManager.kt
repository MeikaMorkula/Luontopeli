package com.example.luontopeli.data.remote.firebase

import com.example.luontopeli.data.local.entity.NatureSpot
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


class FirestoreManager {


    suspend fun saveSpot(spot: NatureSpot): Result<Unit> {
        return Result.success(Unit)
    }


    fun getUserSpots(userId: String): Flow<List<NatureSpot>> {
        return flowOf(emptyList())
    }
}