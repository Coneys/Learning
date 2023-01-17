package patterns.structural.proxy.factory

import patterns.structural.proxy.website.BlackListWebsite
import patterns.structural.proxy.website.RealWebsite
import patterns.structural.proxy.website.Website

object WebsiteFactory {
    fun create(): Website {
        return BlackListWebsite(RealWebsite())
    }
}