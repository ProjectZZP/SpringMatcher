package nl.marcenschede.zinder.matcher

import nl.marcenschede.zinder.matcher.business.Profile
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.*

@SpringBootApplication
@RestController
class MatcherApplication {

    @PostMapping("/profile")
    fun postProfile(@RequestBody body: Profile) : String {

        return ""
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(MatcherApplication::class.java, *args)
}
