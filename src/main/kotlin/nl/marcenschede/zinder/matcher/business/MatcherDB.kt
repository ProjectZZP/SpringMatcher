package nl.marcenschede.zinder.matcher.business

import java.util.*

interface MatcherDB {
    fun store(profile: Profile)

    fun findAccountById(profileId: String): Optional<Profile>

    fun findMatchingAccounts(requestProfile: ProfileRequest): Collection<Profile>
}
