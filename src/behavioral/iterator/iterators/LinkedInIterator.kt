package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_networks.LinkedIn
import java.util.ArrayList


class LinkedInIterator(
    private val linkedIn: LinkedIn,
    private val type: String,
    private val email: String
) : ProfileIterator {
    private var currentPosition = 0
    private val emails: MutableList<String> = ArrayList()
    private val contacts: MutableList<Profile?> = ArrayList()

    private fun lazyLoad() {
        if (emails.size != 0) return

        val profiles: List<String> = linkedIn.requestRelatedContactsFromLinkedInAPI(
            email, type
        )

        for (profile in profiles) {
            emails.add(profile)
            contacts.add(null)
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override fun getNext(): Profile? {
        if (!hasNext()) {
            return null
        }

        val friendEmail = emails[currentPosition]
        var friendContact = contacts[currentPosition]
        if (friendContact == null) {
            friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail)
            contacts[currentPosition] = friendContact
        }
        currentPosition++
        return friendContact
    }

    override fun reset() {
        currentPosition = 0
    }
}