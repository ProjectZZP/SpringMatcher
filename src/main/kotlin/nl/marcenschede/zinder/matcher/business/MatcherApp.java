package nl.marcenschede.zinder.matcher.business;

import java.util.Collection;
import java.util.Optional;

public class MatcherApp {

    private MatcherDB matcherDB;

    public MatcherApp(MatcherDB matcherDB) {
        this.matcherDB = matcherDB;
    }

    public void store(Profile profile) {
        matcherDB.store(profile);
    }

    public Optional<Profile> findAccountByMailAddress(String id) {
        return matcherDB.findAccountById(id);
    }

    public Collection<Profile> findMatchingAccounts(Profile requestProfile) {
        return matcherDB.findMatchingAccounts(requestProfile);
    }
}
