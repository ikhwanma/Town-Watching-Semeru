package com.ikhwan.townwatchingsemeru.domain.use_case.post

import com.ikhwan.townwatchingsemeru.common.Resource
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.toPost
import com.ikhwan.townwatchingsemeru.domain.model.Post
import com.ikhwan.townwatchingsemeru.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserPostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    operator fun invoke(auth: String): Flow<Resource<List<Post>>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(repository.getUserPost(auth).map { it.toPost() }))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server, check connection"))
        }
    }
}