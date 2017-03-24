package nl.marcenschede.zinder.matcher.business;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;

public class Profile {
    private String id;
    private HashSet<String> tags;

    private Profile(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTags(HashSet<String> tags) {
        this.tags = tags;
    }

    public HashSet<String> getTags() {
        return tags;
    }

    public boolean matches(Profile requestProfile) {
        final Predicate<String> tagIsAvailableInProfile = requestedTag -> {
            final Predicate<String> tagMatchesIgnoreCase = tag -> tag.equalsIgnoreCase(requestedTag);

            return tags.stream().anyMatch(tagMatchesIgnoreCase);
        };

        return requestProfile.getTags().stream()
                .allMatch(tagIsAvailableInProfile);
    }

    public static Profile create(String id, String... tags) {
        final Profile profile = new Profile(id);

        profile.setTags(new HashSet<>(Arrays.asList(tags)));

        return profile;
    }
}
