package com.hms.userform

import com.hms.dto.UserFormDto
import com.hms.utils.Constants
import com.hms.utils.Validation

class UserFormModelImpl private constructor(private val userFormModelListener:UserFormModelListener) : UserFormModel {

    override fun onValidate(userFormDto: UserFormDto) {

        var errorMsg = ""
        var status = true

        if ((!Validation.isValidName(userFormDto.firstName))||(!Validation.isValidName(userFormDto.lastName)))
        {
            status = false
            errorMsg = Constants.ErrorCode.NAME_ERROR
        }

        if (!Validation.isValidMailId(userFormDto.mail))
        {
            status = false
            errorMsg = errorMsg + "\n\n" + Constants.ErrorCode.MAIL_ID_ERROR
        }

        if (status)
            userFormModelListener.onSuccess()
        else
            userFormModelListener.onFailure(errorMsg)

    }

    interface UserFormModelListener{
        fun onSuccess()
        fun onFailure(errorMsg:String)
    }

    companion object {

        fun getNewInstance(userFormModelListener: UserFormModelListener):UserFormModel {
            return UserFormModelImpl(userFormModelListener)
        }
    }

}
