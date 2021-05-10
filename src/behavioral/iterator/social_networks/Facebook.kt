package behavioral.iterator.social_networks

import behavioral.iterator.iterators.FacebookIterator
import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile


class Facebook(cache: List<Profile>?) : SocialNetwork {

    private var profiles: List<Profile>? = cache ?: listOf()

    override fun createFriendsIterator(profileEmail: String?): ProfileIterator {
        return FacebookIterator(this, "friends", profileEmail!!)
    }

    override fun createCoworkersIterator(profileEmail: String?): ProfileIterator {
        return FacebookIterator(this, "coworkers", profileEmail!!)
    }

    fun requestProfileFromFacebook(profileEmail: String): Profile? {
        simulateNetworkLatency()
        println("Facebook: Loading profile '$profileEmail' over the network...")
        return findProfile(profileEmail)
    }

    fun requestProfileFriendsFromFacebook(profileEmail: String, contactType: String): List<String> {
        simulateNetworkLatency()
        println("Facebook: Loading '$contactType' list of '$profileEmail' over the network...")

        val profile = findProfile(profileEmail)
        return profile?.getContacts(contactType) ?: listOf()
    }

    private fun findProfile(profileEmail: String): Profile? {
        for (profile in profiles!!) {
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