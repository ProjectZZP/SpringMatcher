package nl.marcenschede.zinder.matcher.business

import java.util.*

class Profile private constructor(val id: String) {
    var tags: HashSet<String> = HashSet()

    companion object {

        fun create(id: String, vararg tags: String): Profile {
            val profile = Profile(id)

            profile.tags = HashSet(Arrays.asList(*tags))

            return profile
        }
    }
}
