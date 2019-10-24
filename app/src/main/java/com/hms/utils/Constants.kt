package com.hms.utils

interface Constants {

    interface ErrorCode {
        companion object {
            val NAME_ERROR = "Name should be minimum 2 letters and maximum of 15 letters"
            val MAIL_ID_ERROR = "Invalid email"
        }
    }
}
