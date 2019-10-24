package com.hms.userform

import com.hms.dto.UserFormDto

interface UserFormPresenter {

    fun onValidate(userFormDto: UserFormDto)

}
