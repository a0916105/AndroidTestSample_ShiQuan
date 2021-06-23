package tw.idv.jew.androidtestsample

class AuthManager(private val loginService: ILoginService) {
    suspend fun login(account: String, password: String): Boolean{
        return loginService.login(account, password)
    }
}

interface ILoginService{
    fun preLogin(account: String, password: String): Boolean

    suspend fun login(account: String, password: String): Boolean
}

class LoginService : ILoginService{
    override fun preLogin(account: String, password: String): Boolean {
        return true
    }

    override suspend fun login(account: String, password: String): Boolean {
        if (account.length < 6){
            return false
        }else if (password.length < 8){
            return false
        }
        return true
    }
}

object Util{
    @JvmStatic
    fun getString(): String = "a"
}