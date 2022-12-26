package com.ikhwan.townwatchingsemeru.presentation.edit_password

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ikhwan.townwatchingsemeru.common.Resource
import com.ikhwan.townwatchingsemeru.data.remote.dto.user.editpassword.EditPasswordBody
import com.ikhwan.townwatchingsemeru.domain.model.UpdatePasswordResponse
import com.ikhwan.townwatchingsemeru.domain.use_case.user.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditPasswordViewModel @Inject constructor(
    private val userUseCase: UserUseCase
) : ViewModel() {

    fun editPassword(
        auth: String,
        editPassword: EditPasswordBody
    ): LiveData<Resource<UpdatePasswordResponse>> =
        userUseCase.editPassword(auth, editPassword).asLiveData()

}