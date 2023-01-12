package patterns.structural.bridge.inRealCode

class Addressee(val name: String, val country: String)
class Payment(val amount: Int, val to: Addressee)

interface PaymentProcess {
    fun validate(payment: Payment): Boolean
    fun execute(payment: Payment): Boolean
}



class StandardUserPayUPaymentProcess() : PaymentProcess {
    override fun validate(payment: Payment): Boolean {
        return payment.amount < 1000 && payment.to.country == "Poland"
    }

    override fun execute(payment: Payment): Boolean {
        // send to PayU with http
        return true
    }
}

open class StandardUserPrzelewy24PaymentProcess() : PaymentProcess {
    override fun validate(payment: Payment): Boolean {
        return payment.amount < 1000 && payment.to.country == "Poland"
    }

    override fun execute(payment: Payment): Boolean {
        // send to Przelewy24 with http
        return true
    }
}

class StandardUserPrzelewy24ExpressPaymentProcess(): StandardUserPrzelewy24PaymentProcess() {
    override fun execute(payment: Payment): Boolean {
        // send to Przelewy24 with http using Express endpoint
        return true
    }
}


class VipUserPayUPaymentProcess : PaymentProcess {
    override fun validate(payment: Payment): Boolean {
        return payment.to.country != "Russia"
    }

    override fun execute(payment: Payment): Boolean {
        // send to PayU with http
        return true
    }
}

class VipUserPrzelewy24PaymentProcess : PaymentProcess {
    override fun validate(payment: Payment): Boolean {
        return payment.to.country != "Russia"
    }

    override fun execute(payment: Payment): Boolean {
        // send to Przelewy24 with http
        return true
    }
}