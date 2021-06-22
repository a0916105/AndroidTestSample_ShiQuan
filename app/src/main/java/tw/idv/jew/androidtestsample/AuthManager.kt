package tw.idv.jew.androidtestsample

class AuthManager {
    fun validLogin(account: String, password: String): Boolean{
        if (account.length < 6){
            return false
        }else if (password.length < 8){
            return false
        }
        return true
    }
}