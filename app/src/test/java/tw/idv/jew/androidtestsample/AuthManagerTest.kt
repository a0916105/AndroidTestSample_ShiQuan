package tw.idv.jew.androidtestsample

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AuthManagerTest {
//    @MockK
//    lateinit var loginService: ILoginService

    @SpyK
    var loginService = LoginService()

    @Mock
    lateinit var mockLoginService: ILoginService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun oriLogin() = runBlocking{
        val loginService = LoginService()
        val authManager = AuthManager(loginService)
        val result = authManager.login("123456", "12345678")
        Assert.assertEquals(true, result)
    }

    @Test
    fun mockLogin() = runBlocking{
//        val mockLoginService = Mockito.mock(ILoginService::class.java)
        val authManager = AuthManager(mockLoginService)
        Mockito.`when`(mockLoginService.login("123456", "12345678")).thenReturn(true)

        val result = authManager.login("123456", "12345678")

        Mockito.verify(mockLoginService).login("123456", "12345678")
        Assert.assertEquals(true, result)
    }

    @Test
    fun login() = runBlocking{
//        val loginService = mockk<ILoginService>()
//        loginService = mockk<ILoginService>()
        val authManager = AuthManager(loginService)
        coEvery { loginService.login(any(), any()) } returns true

        val result = authManager.login("123456", "12345678")

        coVerify{ loginService.login("123456", "12345678") }
        Assert.assertEquals(true, result)
    }

    @Test
    fun spyLogin() = runBlocking{
        /*val loginService = spyk<ILoginService>(LoginService())
        //val loginService = spyk(LoginService())   //This also works*/
//        loginService = spyk(LoginService())
        val authManager = AuthManager(loginService)
        coEvery { loginService.login(any(), any()) } returns true

        val result = authManager.login("123456", "12345678")

        coVerify{ loginService.login("123456", "12345678") }
        Assert.assertEquals(true, result)
    }

    @Test
    fun testUtil(){
        mockkObject(Util)   //??????::class
//        mockkStatic(Util::class)  //This will not work
        every { Util.getString() } returns "b"

        val result = Util.getString()

        verify { Util.getString() }
        assert(result == "b")
    }
}