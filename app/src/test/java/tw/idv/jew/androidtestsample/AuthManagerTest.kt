package tw.idv.jew.androidtestsample

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AuthManagerTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun validLogin() {
        val authManager = AuthManager()
//        val result = authManager.validLogin("123456", "")
        val result = authManager.validLogin("123456", "12345678")
        Assert.assertEquals(true, result)
    }
}