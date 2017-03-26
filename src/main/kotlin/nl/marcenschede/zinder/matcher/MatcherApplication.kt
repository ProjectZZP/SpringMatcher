package nl.marcenschede.zinder.matcher

import nl.marcenschede.zinder.matcher.business.Matcher
import nl.marcenschede.zinder.matcher.business.MatcherDBInMemoryImpl
import nl.marcenschede.zinder.matcher.business.Profile
import nl.marcenschede.zinder.matcher.business.ProfileRequest
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class MatcherApplication {

    @RequestMapping(value = "/profile", method = arrayOf(RequestMethod.GET))
    fun postProfile(@RequestParam vararg tag: String): Collection<Profile> {

        val matcherDB = MatcherDBInMemoryImpl()
        matcherDB.store(Profile.create("scala@m.com", "scala", "akka", "tdd", "cleancode"))
        matcherDB.store(Profile.create("java@m.com", "java", "spring", "tdd", "cleancode"))

        val matcher = Matcher(matcherDB)

        return matcher.findMatchingAccounts(ProfileRequest(*tag))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(MatcherApplication::class.java, *args)
}

