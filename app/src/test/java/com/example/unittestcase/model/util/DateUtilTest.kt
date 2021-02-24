package com.example.unittestcase.model.util

import com.example.unittestcase.util.DateUtil
import org.junit.Assert
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DateUtilTest {
    companion object {
        private const val date = "02-2021" // MM - YEAR
    }

    @Test
    fun `given current timestamp return timestamp`() {
        assertDoesNotThrow(Executable {
            assertEquals(date, DateUtil.getCurrentTimeStamp())
        })
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11])
    fun `get month from number return success`(monthNumber: Int) {
        assertEquals(DateUtil.months[monthNumber], DateUtil.getMonthFromNumber(DateUtil.monthNumbers[monthNumber]))
    }

    @ParameterizedTest
    @ValueSource(ints = [13, 14, 15])
    fun `get month from number return error`(monthNumber: Int) {
        assertEquals(DateUtil.getMonthFromNumber(monthNumber.toString()), DateUtil.GET_MONTH_ERROR)
    }


}