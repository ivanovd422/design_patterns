package structural.facade



object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val converter = VideoConversionFacade()
        val mp4Video = converter.convertVideo("youtubevideo.ogg", "mp4")
        // ...
    }
}