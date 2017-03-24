package nl.marcenschede.zinder.matcher.business;

import nl.marcenschede.zinder.matcher.business.MatcherDB;
import nl.marcenschede.zinder.matcher.business.Profile;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatcherDBInMemoryImpl implements MatcherDB {
    private Map<String, Profile> accountMap = new HashMap<>();

    @Override
    public void store(Profile profile) {
        accountMap.put(profile.getId(), profile);
    }

    @Override
    public Optional<Profile> findAccountById(String profileId) {
        return Optional.ofNullable(accountMap.get(profileId));
    }

    @Override
    public Collection<Profile> findMatchingAccounts(Profile requestProfile) {
        return accountMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(profile ->  profile.matches(requestProfile))
                .collect(Collectors.toSet());
    }
}
