package patterns.structural.facade.internal

internal class NotificationService {
    fun notify(message: String, user: Int) {
        println("Message $message for $user")
    }
}