package com.hms.userform

interface UserFormView {

    fun onSuccess()

    fun onFailure(errorMsg:String)
}
