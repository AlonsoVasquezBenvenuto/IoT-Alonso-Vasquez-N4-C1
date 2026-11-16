package com.example.pruebaunidad2alonsovasquez

import java.security.MessageDigest

fun String.sha256(): String {
    val bytes = this.toByteArray(Charsets.UTF_8)
    val digest = MessageDigest.getInstance("SHA-256")
    val hashBytes = digest.digest(bytes)
    return hashBytes.joinToString("") { "%02x".format(it) }
}