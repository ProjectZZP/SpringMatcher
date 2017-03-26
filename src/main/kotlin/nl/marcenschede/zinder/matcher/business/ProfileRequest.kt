package nl.marcenschede.zinder.matcher.business

import java.util.*

class ProfileRequest private constructor() {
    var tags: HashSet<String> = HashSet()

    companion object {

        fun create(vararg tags: String): ProfileRequest {
            val profileRequest = ProfileRequest()

            profileRequest.tags = HashSet(Arrays.asList(*tags))

            return profileRequest
        }
    }
}
