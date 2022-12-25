package com.ikhwan.townwatchingsemeru.data.repository

import com.ikhwan.townwatchingsemeru.data.remote.PostApi
import com.ikhwan.townwatchingsemeru.data.remote.dto.category.CategoryDto
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.AddPostResponseDto
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.PostDto
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.comment.AddCommentResponseDto
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.comment.CommentBody
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.comment.CommentDto
import com.ikhwan.townwatchingsemeru.data.remote.dto.post.like.LikeResponseDto
import com.ikhwan.townwatchingsemeru.domain.model.Post
import com.ikhwan.townwatchingsemeru.domain.repository.PostRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val api: PostApi
) : PostRepository{
    override suspend fun addPost(
        auth: String,
        description: RequestBody,
        latitude: RequestBody,
        longitude: RequestBody,
        category: RequestBody,
        level: RequestBody,
        status: RequestBody,
        image: MultipartBody.Part
    ): AddPostResponseDto {
        return api.addPost(
            auth, description, latitude, longitude, category, level, status, image
        )
    }
    override suspend fun getAllPost(
        categoryId: Int?,
        level: String?,
        status: Int?
    ): List<PostDto> {
        return api.getAllPost(
            categoryId, level, status
        )
    }

    override suspend fun addLike(auth: String, postId: Int): LikeResponseDto {
        return api.addLike(auth, postId)
    }

    override suspend fun getAllCategory(): List<CategoryDto> {
        return api.getAllCategory()
    }

    override suspend fun getComment(postId: Int): List<CommentDto> {
        return api.getComment(postId)
    }

    override suspend fun addComment(auth: String, comment: CommentBody): AddCommentResponseDto {
        return api.addComment(auth, comment)
    }
}