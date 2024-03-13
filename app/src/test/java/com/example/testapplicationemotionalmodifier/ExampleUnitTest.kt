package com.example.testapplicationemotionalmodifier

import com.example.testapplicationemotionalmodifier.models.EmotionRequest
import com.example.testapplicationemotionalmodifier.network.RetrofitClient
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testPostEmotion() {
        val retrofitClient = RetrofitClient.retrofit

        val response = runBlocking {
            retrofitClient.postEmotion(EmotionRequest(listOf(1, 2, 3, 4, 5, 6), 5))
        }

        assertEquals(listOf(6, 2, 3, 4, 5, 6), response)
    }


}