package tw.idv.jew.androidtestsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

class LoginViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = CoroutinesTestRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun test_login_success() {

    }

    @Test
    fun test_login_fail() {

    }
}