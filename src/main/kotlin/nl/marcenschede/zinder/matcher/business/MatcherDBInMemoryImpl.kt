package nl.marcenschede.zinder.matcher.business

import java.util.*

class MatcherDBInMemoryImpl : MatcherDB {
    private val accountMap = HashMap<String, Profile>()

    override fun store(profile: Profile) {
        accountMap.put(profile.id, profile)
    }

    override fun findAccountById(profileId: String): Profile? {
        return accountMap[profileId]
    }

    override fun findMatchingAccounts(requestProfile: ProfileRequest): Collection<Profile> {
        return accountMap.values
                .filter { profile -> profile.matches(requestProfile) }
                .toList()
    }

    fun Profile.matches(requestProfile: ProfileRequest): Boolean {
        val tagIsAvailableInProfile = { requestedTag: String ->
            val tagMatchesIgnoreCase = { tag: String -> tag.equals(requestedTag, ignoreCase = true) }

            tags.stream().anyMatch(tagMatchesIgnoreCase)
        }

        return requestProfile.tags.stream()
                .allMatch(tagIsAvailableInProfile)
    }
}
