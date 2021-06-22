package tw.idv.jew.androidtestsample

class AuthManager(private val loginService: ILoginService) {
    fun login(account: String, password: String): Boolean{
        return loginService.login(account, password)
    }
}

interface ILoginService{
    fun preLogin(account: String, password: String): Boolean

    fun login(account: String, password: String): Boolean
}

class LoginService : ILoginService{
    override fun preLogin(account: String, password: String): Boolean {
        return true
    }

    override fun login(account: String, password: String): Boolean {
        if (account.length < 6){
            return false
        }else if (password.length < 8){
            return false
        }
        return true
    }
}