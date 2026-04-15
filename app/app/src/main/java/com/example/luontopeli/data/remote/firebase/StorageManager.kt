package com.example.luontopeli.data.remote.firebase

class StorageManager {


    suspend fun uploadImage(localFilePath: String, spotId: String): Result<String> {
        return Result.success(localFilePath)
    }


    suspend fun deleteImage(spotId: String): Result<Unit> {
        return Result.success(Unit)
    }
}