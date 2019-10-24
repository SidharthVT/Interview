package com.hms.utils

import org.junit.Test

import org.junit.Assert.*

class ValidationTest {

    @Test
    fun isValidMailId() {

        val input = arrayOf("sid@gmail.com", "sample@gmail.com", "Will@gmail.com", "Leo@gmail.com", "MartinSoccosse@gmail.com")
        val output = BooleanArray(input.size)
        val expected = BooleanArray(input.size)

        for (i in input.indices) {
            output[i] = Validation.isValidMailId(input[i])
            expected[i] = true
        }

        assertArrayEquals(expected, output)
    }

    @Test
    fun isValidName() {

        val input = arrayOf("sid", "sample", "Will", "Leo", "Martin Soccosse")
        val output = BooleanArray(input.size)
        val expected = BooleanArray(input.size)

        for (i in input.indices) {
            output[i] = Validation.isValidName(input[i])
            expected[i] = true
        }

        assertArrayEquals(expected, output)
    }
}