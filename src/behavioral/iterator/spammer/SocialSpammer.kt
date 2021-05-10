package behavioral.iterator.spammer

import behavioral.iterator.social_networks.SocialNetwork

import behavioral.iterator.iterators.ProfileIterator
import behavioral.iterator.profile.Profile


class SocialSpammer(var network: SocialNetwork) {

    var iterator: ProfileIterator? = null

    fun sendSpamToFriends(profileEmail: String?, message: String) {
        println("\nIterating over friends...\n")
        iterator = network.createFriendsIterator(profileEmail)
        while (iterator?.hasNext() == true) {
            val profile: Profile? = iterator?.getNext()
            sendMessage(profile?.email, message)
        }
    }

    fun sendSpamToCoworkers(profileEmail: String?, message: String) {
        println("\nIterating over coworkers...\n")
        iterator = network.createCoworkersIterator(profileEmail)

        while (iterator?.hasNext() == true) {
            val profile: Profile? = iterator?.getNext()
            sendMessage(profile?.email, message)
        }
    }

    private fun sendMessage(email: String?, message: String) {
        println("Sent message to: '$email'. Message body: '$message'")
    }
}