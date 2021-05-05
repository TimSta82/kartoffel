package de.bornholdtlee.defaultprojectkotlin.extensions

fun <T> List<T>.second(): T {
    if (isEmpty())
        throw NoSuchElementException("List is empty.")
    return this[1]
}

fun <T> List<T>.replace(index: Int, new: T): List<T> {
    return this.mapIndexed { i, item -> if (i == index) new else item }
}
