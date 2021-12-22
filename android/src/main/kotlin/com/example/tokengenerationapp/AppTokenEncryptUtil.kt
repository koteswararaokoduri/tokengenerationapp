package com.example.tokengenerationapp

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.experimental.and

object AppTokenEncryptUtil {

    // Keys
    private val mKey = byteArrayOf(0x29.toByte(), 0x54.toByte(), 0x7b.toByte(), 0x5c.toByte(), 0xfd.toByte(), 0x78.toByte(), 0x44.toByte(), 0x39.toByte(), 0xeb.toByte(), 0x40.toByte(), 0x0d.toByte(), 0xcc.toByte(), 0x40.toByte(), 0xb9.toByte(), 0x7d.toByte(), 0xb1.toByte())
    private val mIV = byteArrayOf(0xd5.toByte(), 0xd7.toByte(), 0xe7.toByte(), 0x7c.toByte(), 0x86.toByte(), 0xbf.toByte(), 0xd9.toByte(), 0x3e.toByte(), 0xcf.toByte(), 0x29.toByte(), 0x7c.toByte(), 0x69.toByte(), 0x1c.toByte(), 0xdf.toByte(), 0x2c.toByte(), 0x19.toByte())

    // Rules
    private const val HASH_CODE = ".TokenHashCode."
    private const val CIPHER_METHOD = "AES/CBC/PKCS5Padding"

    /* ------------------------------ Encode */

    /**
     * Get token application token by encrypt rule
     */
    val encodeData: String
        get() {
            var resultString = ""
            try {
                val cipher = Cipher.getInstance(CIPHER_METHOD)
                val keySpec = SecretKeySpec(mKey, "AES")
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, IvParameterSpec(mIV))

                val timestamp = System.currentTimeMillis() / 1000L
                var data = timestamp.toString() + HASH_CODE
                while (data.length % 16 != 0) {
                    data += "0"
                }

                val encrypted = cipher.doFinal(data.toByteArray())
                resultString = byteArrayToHex(encrypted)

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return resultString
        }

    /**
     * Convert byte array to Hex String
     *
     * @param byteArray target byte array
     */
    private fun byteArrayToHex(byteArray: ByteArray): String {
        val stringBuilder = StringBuilder(byteArray.size * 2)
        for (tempByte in byteArray) {
            stringBuilder.append(String.format("%02x", tempByte and 0xff.toByte()))
        }
        return stringBuilder.toString()
    }
}