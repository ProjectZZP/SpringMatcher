package nl.marcenschede.zinder.matcher

import nl.marcenschede.zinder.matcher.business.ProfileRequest
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class MatcherApplication {

//    @Autowired
//    var matcherDb: MatcherDB = null

    @PostMapping("/profile")
    fun postProfile(@RequestBody profileRequest: ProfileRequest) : String {

//        val matcher = Matcher()

//        return matcher.findMatchingAccounts(profileRequest)
        return ""
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(MatcherApplication::class.java, *args)
}
