package nl.marcenschede.zinder.matcher.business

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MatcherTests {

    private var matcherApp: Matcher = Matcher(MatcherDBInMemoryImpl())

    @Test
    fun storeAccounts() {
        val profile = Profile.create("id1", "java", "spring", "tdd", "cleancode")
        matcherApp.store(profile)

        val foundAccount = matcherApp.findAccountByMailAddress("id1")

        assertThat(foundAccount?.id, equalTo("id1"))
    }

    @Nested
    inner class ProfileUpdateTests {

        @Test
        @Disabled("Not implemented yet")
        fun storeNewProfile() {
        }

        @Test
        @Disabled("Not implemented yet")
        fun updateProfile() {
        }

        @Test
        @Disabled("Not implemented yet")
        fun deleteProfile() {
        }

    }

    @Nested
    inner class FinderMethods {

        @BeforeEach
        fun init() {
            val profile1 = Profile.create("java@m.com", "java", "spring", "tdd", "cleancode")
            matcherApp.store(profile1)

            val profile2 = Profile.create("scala@m.com", "scala", "akka", "tdd", "cleancode")
            matcherApp.store(profile2)
        }

        @Test
        fun findAccountsBasedOnTags() {
            val requestProfile = ProfileRequest("Spring", "TDD")

            val matchingAccounts = matcherApp.findMatchingAccounts(requestProfile)

            assertThat(matchingAccounts.size, equalTo(1))
            assertThat(matchingAccounts.stream().findFirst().get().id, equalTo("java@m.com"))
        }

        @Test
        fun matchingProfileNotFound() {
            val requestProfile = ProfileRequest("Spring", "JUnit")

            val matchingAccounts = matcherApp.findMatchingAccounts(requestProfile)

            assertThat(matchingAccounts.size, equalTo(0))
        }

        @Test
        fun matchesMoreThanOneProfile() {
            val requestProfile = ProfileRequest("tdd")

            val matchingAccounts = matcherApp.findMatchingAccounts(requestProfile)

            assertThat(matchingAccounts.size, equalTo(2))
        }
    }


}
