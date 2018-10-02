package burp

import java.util.*


class BurpExtender: IBurpExtender {
    override fun registerExtenderCallbacks(callbacks: IBurpExtenderCallbacks) {
        callbacks.setExtensionName("UUID Payload Generator")
        callbacks.registerIntruderPayloadGeneratorFactory(PayloadGeneratorFactory())
    }
}


class PayloadGeneratorFactory: IIntruderPayloadGeneratorFactory {
    override val generatorName = "UUID Payload Generator"
    override fun createNewInstance(attack: IIntruderAttack): IIntruderPayloadGenerator {
        return PayloadGenerator()
    }
}


class PayloadGenerator: IIntruderPayloadGenerator {
    override fun hasMorePayloads() = true
    override fun reset() { }
    override fun getNextPayload(baseValue: ByteArray) = UUID.randomUUID().toString().toByteArray()
}
