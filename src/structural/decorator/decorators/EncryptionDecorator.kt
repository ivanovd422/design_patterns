package structural.decorator.decorators

import java.util.*

class EncryptionDecorator(source: DataSource) :
    DataSourceDecorator(source) {

    override fun writeData(data: String) {
        super.writeData(encode(data))
    }

    override fun readData(): String {
        return decode(super.readData())
    }

    private fun encode(data: String): String {
        val result = data.toByteArray()

        //... some work

        return Base64.getEncoder().encodeToString(result)
    }

    private fun decode(data: String?): String {
        val result: ByteArray = Base64.getDecoder().decode(data)

       //... some work

        return String(result)
    }
}