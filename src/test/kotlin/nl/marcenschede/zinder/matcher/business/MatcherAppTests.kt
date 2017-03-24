package nl.marcenschede.zinder.matcher.business

import nl.marcenschede.zinder.matcher.business.MatcherApp
import nl.marcenschede.zinder.matcher.business.MatcherDBInMemoryImpl
import nl.marcenschede.zinder.matcher.business.Profile
import org.junit.jupiter.api.*
import org.junit.runner.RunWith
import java.util.Optional

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class MatcherAppTests {

    private var matcherApp: MatcherApp = MatcherApp(MatcherDBInMemoryImpl())

    @Test
    fun storeAccounts() {
        val profile = Profile.create("id1", "java", "spring", "tdd", "cleancode")
        matcherApp.store(profile)

        val foundAccount = matcherApp.findAccountByMailAddress("id1")

        assertThat(foundAccount.get().id, equalTo("id1"))
    }

    @Nested
    inner class ProfileUpdateTests {

        @Test
        @Disabled
        fun storeNewProfile() {
            Assertions.fail("Not implemented yet")
        }

        @Test
        @Disabled
        fun updateProfile() {
            Assertions.fail("Not implemented yet")
        }

        @Test
        @Disabled
        fun deleteProfile() {
            Assertions.fail("Not implemented yet")
        }

    }

    @Nested
    inner class FinderMethods {

        private var profile1: Profile? = null
        private var profile2: Profile? = null

        @BeforeEach
        fun init() {
            profile1 = Profile.create("java@m.com", "java", "spring", "tdd", "cleancode")
            matcherApp.store(profile1)

            profile2 = Profile.create("scala@m.com", "scala", "akka", "tdd", "cleancode")
            matcherApp.store(profile2)
        }

        @Test
        fun findAccountsBasedOnTags() {
            val requestProfile = Profile.create("", "Spring", "TDD")

            val matchingAccounts = matcherApp.findMatchingAccounts(requestProfile)

            assertThat(matchingAccounts.size, equalTo(1))
            assertThat(matchingAccounts.stream().findFirst().get().id, equalTo("java@m.com"))
        }

        @Test
        fun matchingProfileNotFound() {
            val requestProfile = Profile.create("", "Spring", "JUnit")

            val matchingAccounts = matcherApp.findMatchingAccounts(requestProfile)

            assertThat(matchingAccounts.size, equalTo(0))
        }

        @Test
        fun matchesMoreThanOneProfile() {
            val requestProfile = Profile.create("", "tdd")

            val matchingAccounts = matcherApp.findMatchingAccounts(requestProfile)

            assertThat(matchingAccounts.size, equalTo(2))
        }
    }


}
