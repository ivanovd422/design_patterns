package structural.decorator.decorators

import java.io.IOException
import java.io.FileReader
import java.io.File
import java.io.FileOutputStream


class FileDataSource(private val name: String) : DataSource {

    override fun writeData(data: String) {
        val file = File(name)
        try {
            FileOutputStream(file).use { fos -> fos.write(data.toByteArray(), 0, data.length) }
        } catch (ex: IOException) {
            println(ex.message)
        }
    }

    override fun readData(): String {
        var buffer: CharArray? = null
        val file = File(name)

        try {
            FileReader(file).use { reader ->
                buffer = CharArray(file.length().toInt())
                buffer?.let {
                    reader.read(it)
                }
            }
        } catch (ex: IOException) {
            println(ex.message)
        }

        return if (buffer == null) String() else String(buffer!!)
    }
}