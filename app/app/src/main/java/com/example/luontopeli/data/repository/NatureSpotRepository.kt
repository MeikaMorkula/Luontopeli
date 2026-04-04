package com.example.luontopeli.data.repository

import com.example.luontopeli.data.local.dao.NatureSpotDao
import com.example.luontopeli.data.local.entity.NatureSpot
import com.example.luontopeli.data.remote.firebase.AuthManager
import com.example.luontopeli.data.remote.firebase.FirestoreManager
import com.example.luontopeli.data.remote.firebase.StorageManager
import kotlinx.coroutines.flow.Flow


class NatureSpotRepository(
    private val dao: NatureSpotDao,
    private val firestoreManager: FirestoreManager,
    private val storageManager: StorageManager,
    private val authManager: AuthManager
) {
    /** Flow-virta kaikista luontolöydöistä aikajärjestyksessä (uusin ensin) */
    val allSpots: Flow<List<NatureSpot>> = dao.getAllSpots()

    val spotsWithLocation: Flow<List<NatureSpot>> = dao.getSpotsWithLocation()


    suspend fun insertSpot(spot: NatureSpot) {
        val spotWithUser = spot.copy(userId = authManager.currentUserId, synced = true)
        dao.insert(spotWithUser)
    }

    suspend fun deleteSpot(spot: NatureSpot) {
        dao.delete(spot)
    }


    suspend fun getUnsyncedSpots(): List<NatureSpot> {
        return dao.getUnsyncedSpots()
    }
}