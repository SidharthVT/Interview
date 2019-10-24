package com.hms.userform

import com.hms.dto.UserFormDto

interface UserFormModel {

    fun onValidate(userFormDto: UserFormDto)
}
