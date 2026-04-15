package com.example.luontopeli.data.local.dao

import androidx.room.*
import com.example.luontopeli.data.local.entity.WalkSession
import kotlinx.coroutines.flow.Flow

@Dao
interface WalkSessionDao {

    @Query("SELECT * FROM walk_sessions ORDER BY startTime DESC")
    fun getAll(): Flow<List<WalkSession>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(session: WalkSession)

    @Update
    suspend fun update(session: WalkSession)

    @Delete
    suspend fun delete(session: WalkSession)

    @Query("DELETE FROM walk_sessions")
    suspend fun deleteAll()
}