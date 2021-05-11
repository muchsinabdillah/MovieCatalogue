package com.mov.moviecatalogue.utils

fun String.year(): String {
    return this.substring(0, 4)
}