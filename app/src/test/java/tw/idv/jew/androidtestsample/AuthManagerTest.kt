package tw.idv.jew.androidtestsample

import io.mockk.*
import io.mockk.impl.annotations.MockK
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

        verify(
//            ordering = Ordering.ORDERED
            exactly = 3
        ){
//            loginService.preLogin("123456", "12345678")
            loginService.login("123456", "12345678")
        }
        Assert.assertEquals(true, result)
    }
}