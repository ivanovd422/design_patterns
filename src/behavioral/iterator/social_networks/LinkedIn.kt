package behavioral.iterator.social_networks

import behavioral.iterator.iterators.LinkedInIterator

import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile


class LinkedIn(cache: List<Profile>?) : SocialNetwork {

    private var contacts: List<Profile>? = cache ?: listOf()

    override fun createFriendsIterator(profileEmail: String?): ProfileIterator {
        return LinkedInIterator(this, "friends", profileEmail!!)
    }

    override fun createCoworkersIterator(profileEmail: String?): ProfileIterator {
        return LinkedInIterator(this, "coworkers", profileEmail!!)
    }

    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile? {
        simulateNetworkLatency()
        println("LinkedIn: Loading profile '$profileEmail' over the network...")
        return findContact(profileEmail)
    }

    fun requestRelatedContactsFromLinkedInAPI(profileEmail: String, contactType: String): List<String> {
        simulateNetworkLatency()
        println("LinkedIn: Loading '$contactType' list of '$profileEmail' over the network...")

        val profile = findContact(profileEmail)
        return profile?.getContacts(contactType) ?: listOf()
    }

    private fun findContact(profileEmail: String): Profile? {
        for (profile in contacts!!) {
            if (profile.email == profileEmail) {
                return profile
            }
        }
        return null
    }

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }
}