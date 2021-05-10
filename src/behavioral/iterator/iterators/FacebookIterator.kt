package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile
import behavioral.iterator.social_networks.Facebook
import java.util.ArrayList


class FacebookIterator(
    private val facebook: Facebook,
    private val type: String,
    private val email: String
) : ProfileIterator {

    private var currentPosition = 0

    private val emails: MutableList<String> = ArrayList()
    private val profiles: MutableList<Profile?> = ArrayList()

    private fun lazyLoad() {
        if (emails.size != 0) return

        val profiles: List<String> = facebook.requestProfileFriendsFromFacebook(email, type)

        for (profile in profiles) {
            emails.add(profile)
            this.profiles.add(null)
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
        var friendProfile = profiles[currentPosition]
        if (friendProfile == null) {
            friendProfile = facebook.requestProfileFromFacebook(friendEmail)
            profiles[currentPosition] = friendProfile
        }
        currentPosition++
        return friendProfile
    }

    override fun reset() {
        currentPosition = 0
    }
}