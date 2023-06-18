package course.examples.controlflow

fun main() {
    val userData = UserData("1", "user1")
    executeSecureOperation(userData)

    with(userData) {
        executeSecureOperation2()
    }
}

private fun executeSecureOperation(userData: UserData) {
    println("Executing secure operation for user ${userData.username}")
}

context(UserData)
private fun executeSecureOperation2() {
    println("Executing secure operation 2 for user $username")
}

private data class UserData(
    val id: String,
    val username: String,
)
