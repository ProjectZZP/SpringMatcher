package nl.marcenschede.zinder.matcher.business;

import java.util.Collection;
import java.util.Optional;

public interface MatcherDB {
    void store(Profile profile);

    Optional<Profile> findAccountById(String profileId);

    Collection<Profile> findMatchingAccounts(Profile requestProfile);
}
