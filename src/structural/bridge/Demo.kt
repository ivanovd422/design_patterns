package structural.bridge

import structural.bridge.remotes.AdvancedRemote
import structural.bridge.remotes.BasicRemote
import structural.bridge.devices.Device
import structural.bridge.devices.Radio
import structural.bridge.devices.Tv


object Demo {

    @JvmStatic
    fun main(args: Array<String>) {
        testDevice(Tv())
        testDevice(Radio())
    }

    private fun testDevice(device: Device) {
        println("Tests with basic remote.")
        val basicRemote = BasicRemote(device)
        basicRemote.power()
        device.printStatus()

        println("Tests with advanced remote.")
        val advancedRemote = AdvancedRemote(device)
        advancedRemote.power()
        advancedRemote.mute()
        device.printStatus()
    }
}