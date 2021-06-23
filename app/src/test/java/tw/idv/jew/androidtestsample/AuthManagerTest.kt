package tw.idv.jew.androidtestsample

import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
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
    fun login() = runBlocking{
//        val loginService = mockk<ILoginService>()
        loginService = mockk<ILoginService>()
        val authManager = AuthManager(loginService)
        coEvery { loginService.login(any(), any()) } returns true

        val result = authManager.login("123456", "12345678")

        coVerify{ loginService.login("123456", "12345678") }
        Assert.assertEquals(true, result)
    }

    @Test
    fun testUtil(){
        mockkObject(Util)   //不用::class
//        mockkStatic(Util::class)  //This will not work
        every { Util.getString() } returns "b"

        val result = Util.getString()

        verify { Util.getString() }
        assert(result == "b")
    }
}