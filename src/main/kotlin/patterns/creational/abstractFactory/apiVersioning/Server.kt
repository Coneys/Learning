package patterns.creational.abstractFactory.apiVersioning

data class HttpRequest(val method: String, val parameters: List<String>)
data class HttpResponse(val body: String)


class Command(val containsAbc: Boolean, val wantsLowercase: Boolean)
class Response(val text: String, val commitHash: String) {
    fun toHttpResponse(): HttpResponse {
        return if (commitHash.isEmpty())
            HttpResponse(text)
        else HttpResponse("$text,$commitHash")
    }
}

abstract class HandleFactory {
    abstract fun createCommand(httpRequest: HttpRequest): Command
    abstract fun createResponse(command: Command): Response
}

class V1HandleFactory : HandleFactory() {
    override fun createCommand(httpRequest: HttpRequest): Command {
        return Command(httpRequest.parameters.contains("abc"), false)
    }

    override fun createResponse(command: Command): Response {
        return Response("ABC YUUPI", "")
    }

}

class V2HandleFactory : HandleFactory() {
    override fun createCommand(httpRequest: HttpRequest): Command {
        val containsAbc = httpRequest.parameters.contains("abc")
        val wantsLowercase = httpRequest.parameters.contains("lowercase=true")
        return Command(containsAbc, wantsLowercase)
    }

    override fun createResponse(command: Command): Response {
        val initialText = "ABC YUUPI"
        val text = if (command.wantsLowercase) initialText.lowercase()
        else initialText

        return Response(text, "commit#123")
    }
}


class HandleVersionPolicy {
    fun decide(httpRequest: HttpRequest): HandleFactory {
        val isVersion2 = httpRequest.parameters.contains("version=2")

        val factory = if (isVersion2) V2HandleFactory()
        else V1HandleFactory()
        return factory
    }
}

fun handle(httpRequest: HttpRequest): HttpResponse {


    val factory = HandleVersionPolicy().decide(httpRequest)

    val command = factory.createCommand(httpRequest)
    return factory.createResponse(command).toHttpResponse()

}

fun main() {
    val response = handle(HttpRequest("GET", listOf("abc")))
    println(response.body)

    val response2 = handle(HttpRequest("GET", listOf("abc", "version=2", "lowercase=true")))
    println(response2.body)

}