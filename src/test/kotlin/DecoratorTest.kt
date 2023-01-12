import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import patterns.structural.decorator.DefaultUserRepository
import patterns.structural.decorator.LoggingUserRepository
import patterns.structural.decorator.User
import patterns.structural.decorator.ValidationUserRepository
import java.lang.IllegalArgumentException

class DecoratorTest {
    private val defaultRepo = DefaultUserRepository()

    @Test
    fun loggingTest() {
        println("Should print log:")
        LoggingUserRepository(defaultRepo).get("abc")
    }

    @Test
    fun validationTest() {
        assertThrows<IllegalArgumentException> {
            ValidationUserRepository(defaultRepo).add(User("xx"))
        }
    }

    @Test
    fun combinationTest() {
        val validationUserRepository = ValidationUserRepository(defaultRepo)
        val combined = LoggingUserRepository(validationUserRepository)
        println("Should print log:")
        combined.get("xyz")
        assertThrows<IllegalArgumentException> {
            combined.add(User("xx"))
        }
    }
}