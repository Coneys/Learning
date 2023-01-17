package patterns.structural.proxy.website

import java.lang.IllegalStateException

internal class BlackListWebsite(private val realWebsite: RealWebsite) : Website {
    override fun read(url: String): String {
        if (url.contains("google")) throw IllegalStateException("Cmon, google?")
        if (url.contains("apple")) throw IllegalStateException("Ok, google was better")
        return realWebsite.read(url)
    }
}