package patterns.structural.decorator

interface UserRepository {
    fun add(user: User)
    fun get(name: String): User?
}

class DefaultUserRepository : UserRepository {
    private val users = mutableListOf<User>()
    override fun add(user: User) {
        users.add(user)
    }

    override fun get(name: String) = users.firstOrNull() { it.name == name }
}

// Wymaganie 1


class LoggingUserRepository(private val userRepository: UserRepository) : UserRepository by userRepository {
    override fun get(name: String): User? {
        println("Requesting user with name $name")
        return userRepository.get(name)
    }
}

//Wymaganie 2

class ValidationUserRepository(private val userRepository: UserRepository) : UserRepository by userRepository {
    override fun add(user: User) {
        require(user.name.length >= 5)
        userRepository.add(user)
    }
}

// Wymaganie 3 - gotowe

fun main() {
    println("Should print log:")
    LoggingUserRepository(DefaultUserRepository()).get("abc")

    println()
    println("--------------------")
    println()

    println("Should throw error:")
    try {
        ValidationUserRepository(DefaultUserRepository()).add(User("ab"))
    } catch (e: Exception) {
        println("Err ${e.message}")
    }

    println()
    println("--------------------")
    println()
    println("Combination:")

    val combined = LoggingUserRepository(ValidationUserRepository(DefaultUserRepository()))
    combined.get("combined")
    try {
        combined.add(User("com"))
    } catch (e: Exception) {
        println("Err ${e.message}")
    }

}
