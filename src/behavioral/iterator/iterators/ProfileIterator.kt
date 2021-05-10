package behavioral.iterator.iterators

import behavioral.iterator.profile.Profile


interface ProfileIterator {
    fun hasNext(): Boolean
    fun getNext(): Profile?
    fun reset()
}