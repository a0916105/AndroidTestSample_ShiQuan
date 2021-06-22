package tw.idv.jew.androidtestsample

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AuthManagerTest {
    @MockK
    lateinit var loginService: ILoginService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun login() {
        val loginService = mockk<ILoginService>()
        val authManager = AuthManager(loginService)
        every { loginService.login(any(), any()) } returns true

        val result = authManager.login("123456", "12345678")

        verify { loginService.login("123456", "12345678") }
        Assert.assertEquals(true, result)
    }
}