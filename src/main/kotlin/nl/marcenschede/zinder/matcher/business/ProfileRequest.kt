package nl.marcenschede.zinder.matcher.business

import java.util.*

class ProfileRequest(vararg tags: String) {
    val tags: HashSet<String> = HashSet(Arrays.asList(*tags))

//    companion object {
//
//        fun create(vararg tags: String): ProfileRequest {
//            val profileRequest = ProfileRequest()
//
//            profileRequest.tags = HashSet(Arrays.asList(*tags))
//
//            return profileRequest
//        }
//    }
}
