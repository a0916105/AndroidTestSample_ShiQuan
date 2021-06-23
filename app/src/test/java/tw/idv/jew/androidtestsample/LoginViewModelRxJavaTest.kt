package tw.idv.jew.androidtestsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoginViewModelRxJavaTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val repository = mockk<LoginRepository>(relaxed = true)

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler {
            Schedulers.trampoline()
        }
        RxJavaPlugins.setIoSchedulerHandler {
            Schedulers.trampoline()
        }
    }

    @Test
    fun test_login2_parameter() {
        val viewModel = LoginViewModel(repository)

        every { repository.login2(any(), any()) }.returns(Single.just(true))

        viewModel.login2("abc", "123")

        verify { repository.login2("abc", "123") }
    }
}