package structural.facade

import structural.facade.some_complex_media_library.*
import structural.facade.some_complex_media_library.BitrateReader.convert
import structural.facade.some_complex_media_library.BitrateReader.read
import java.io.File


class VideoConversionFacade {

    fun convertVideo(fileName: String, format: String): File {
        println("VideoConversionFacade: conversion started.")

        val file = VideoFile(fileName)
        val sourceCodec: Codec = CodecFactory.extract(file)

        val destinationCodec: Codec = if (format == "mp4") {
            OggCompressionCodec()
        } else {
            MPEG4CompressionCodec()
        }

        val buffer = read(file, sourceCodec)
        val intermediateResult = convert(buffer, destinationCodec)
        val result = AudioMixer().fix(intermediateResult)

        println("VideoConversionFacade: conversion completed.")
        return result
    }
}