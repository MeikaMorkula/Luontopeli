package com.example.luontopeli.data.repository

import com.example.luontopeli.data.local.dao.WalkSessionDao
import com.example.luontopeli.data.local.entity.WalkSession
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WalkRepository @Inject constructor(
    private val walkSessionDao: WalkSessionDao
) {
    fun getAllWalkSessions(): Flow<List<WalkSession>> =
        walkSessionDao.getAll()

    suspend fun insertWalkSession(session: WalkSession) =
        walkSessionDao.insert(session)

    suspend fun updateWalkSession(session: WalkSession) =
        walkSessionDao.update(session)

    suspend fun deleteWalkSession(session: WalkSession) =
        walkSessionDao.delete(session)

    suspend fun deleteAllWalkSessions() =
        walkSessionDao.deleteAll()
}