package patterns.structural.proxy.website

import java.net.URL

internal class RealWebsite: Website {
    override fun read(url: String): String {
        return URL(url).readText()
    }
}