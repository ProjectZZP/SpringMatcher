package nl.marcenschede.zinder.matcher.business

import java.util.*

fun Profile.matches(requestProfile: ProfileRequest): Boolean {
    val tagIsAvailableInProfile = { requestedTag :String ->
        val tagMatchesIgnoreCase = { tag : String -> tag.equals(requestedTag, ignoreCase = true) }

        tags.stream().anyMatch(tagMatchesIgnoreCase)
    }

    return requestProfile.tags.stream()
            .allMatch(tagIsAvailableInProfile)
}

class MatcherDBInMemoryImpl : MatcherDB {
    private val accountMap = HashMap<String, Profile>()

    override fun store(profile: Profile) {
        accountMap.put(profile.id, profile)
    }

    override fun findAccountById(profileId: String): Optional<Profile> {
        return Optional.ofNullable(accountMap[profileId])
    }

    override fun findMatchingAccounts(requestProfile: ProfileRequest): Collection<Profile> {
        return accountMap.values
                .filter { profile -> profile.matches(requestProfile) }
                .toList()
    }
}
