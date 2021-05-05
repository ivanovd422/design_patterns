package structural.facade.some_complex_media_library

object BitrateReader {
    fun read(file: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: reading file...")
        return file
    }

    fun convert(buffer: VideoFile, codec: Codec?): VideoFile {
        println("BitrateReader: writing file...")
        return buffer
    }
}