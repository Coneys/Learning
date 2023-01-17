package patterns.structural.proxy

import patterns.structural.proxy.factory.WebsiteFactory

fun main() {
    val website = WebsiteFactory.create()

    val treespotResult = website.read("https://test123456789.treespot.pl/")
    println("Treespot result")
    println(treespotResult)
    val googleResult = website.read("https://google.pl/")
    println("Google result")
    println(googleResult)

}