package nl.marcenschede.zinder.matcher.business

class Matcher(private val matcherDB: MatcherDB) {

    fun store(profile: Profile) {
        matcherDB.store(profile)
    }

    fun findAccountByMailAddress(id: String): Profile? {
        return matcherDB.findAccountById(id)
    }

    fun findMatchingAccounts(requestProfile: ProfileRequest): Collection<Profile> {
        return matcherDB.findMatchingAccounts(requestProfile)
    }
}
