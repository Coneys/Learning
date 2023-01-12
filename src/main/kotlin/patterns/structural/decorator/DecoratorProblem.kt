package patterns.structural.decorator


open class UserRepo {
    private val users = mutableListOf<User>()
    open fun add(user: User) {
        users.add(user)
    }

    open fun get(name: String) = users.firstOrNull() { it.name == name }
}

// Wymaganie pierwsze
// Logowanie przy każdej operacji get w CZĘŚCI SYSTEMU (bez zmieniania domyślnej implementacji)

class LoggingUserRepo() : UserRepo() {
    override fun get(name: String): User? {
        println("Requesting user with name $name")
        return super.get(name)
    }
}

// Wymaganie drugie
// Walidacja dodawania użytkownika (min 5 liter w nazwie) w CZĘŚCI SYSTEMU

class ValidationUserRepo() : UserRepo() {
    override fun add(user: User) {
        require(user.name.length >= 5)
        super.add(user)
    }
}

// Wymaganie trzecie
// Czasami ma się zadziać i logowanie i walidacja

class LoggingValidationUserRepo() : UserRepo() {
    //...
}

fun main() {
    println("Should print log:")
    LoggingUserRepo().get("abc")

    println()
    println("--------------------")
    println()

    println("Should throw error:")
    ValidationUserRepo().add(User("ab"))

}