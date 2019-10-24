package com.hms.userform

import com.hms.dto.UserFormDto

class UserFormPresenterImpl private constructor(private val userFormView: UserFormView) : UserFormPresenter, UserFormModelImpl.UserFormModelListener {

    override fun onFailure(errorMsg:String) {

        userFormView.onFailure(errorMsg)
    }

    private val mUserFormModel: UserFormModel

    init {
        mUserFormModel =  UserFormModelImpl.getNewInstance(this)
    }

    override fun onValidate(userFormDto: UserFormDto)
    {
        mUserFormModel.onValidate(userFormDto)
    }

    override fun onSuccess() {
        userFormView.onSuccess()
    }

    companion object {

        fun getNewInstance(userFormView: UserFormView): UserFormPresenter {
            return UserFormPresenterImpl(userFormView)
        }
    }
}
