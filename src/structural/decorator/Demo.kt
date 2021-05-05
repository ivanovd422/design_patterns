package structural.decorator

import structural.decorator.decorators.*


object Demo {

    @JvmStatic
    fun main(args: Array<String>) {

        val salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000"
        val encoded: DataSourceDecorator = CompressionDecorator(
            EncryptionDecorator(
                FileDataSource("out/OutputDemo.txt")
            )
        )
        encoded.writeData(salaryRecords)
        val plain: DataSource = FileDataSource("out/OutputDemo.txt")
        println("- Input ----------------")
        println(salaryRecords)
        println("- Encoded --------------")
        System.out.println(plain.readData())
        println("- Decoded --------------")
        println(encoded.readData())
    }
}