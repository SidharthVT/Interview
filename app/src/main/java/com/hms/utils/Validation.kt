package com.hms.utils

import java.util.regex.Pattern

object Validation {

    fun isValidMailId(textToCheck: String?): Boolean {
        val EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]" + "+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(textToCheck)
        return !(textToCheck?.length == 0 || !matcher.matches())
    }


    fun isValidName(txt: String): Boolean {
        return txt.length >= 2 && txt.length <= 15
    }
}
