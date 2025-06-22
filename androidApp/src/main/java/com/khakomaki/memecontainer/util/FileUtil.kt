package com.khakomaki.memecontainer.util

import android.content.Context
import android.net.Uri
import okio.IOException
import java.io.File
import java.util.UUID

fun saveUriToFile(context: Context, uri: Uri): String {
    val inputStream = context.contentResolver.openInputStream(uri)
        ?: throw IOException("Cannot open input stream from URI: $uri")

    val file = File(context.getExternalFilesDir("memes"), "${UUID.randomUUID()}.jpg")
    file.outputStream().use { outputStream ->
        inputStream.use { inputStream ->
            inputStream.copyTo(outputStream)
        }
    }
    return file.absolutePath
}
