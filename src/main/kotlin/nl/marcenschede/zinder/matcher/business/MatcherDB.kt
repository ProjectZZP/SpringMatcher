package nl.marcenschede.zinder.matcher.business

interface MatcherDB {
    fun store(profile: Profile)

    fun findAccountById(profileId: String): Profile?

    fun findMatchingAccounts(requestProfile: ProfileRequest): Collection<Profile>
}
