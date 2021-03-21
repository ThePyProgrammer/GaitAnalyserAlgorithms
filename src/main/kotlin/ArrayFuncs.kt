
fun Array<Complex>.timesConj(): Array<Double> = run {
    val newList = mutableListOf<Double>()
    this.forEach {
        newList.add(it.mag * it.mag)
    }
    newList.toTypedArray()
}

infix operator fun Array<Double>.div(x: Double) = run {
    val newList = mutableListOf<Double>()
    this.forEach {
        newList.add(it / x)
    }
    newList.toTypedArray()
}

fun Array<Double>.slice(start: Int, end: Int, step: Int = 1) = run {
    val newList = mutableListOf<Double>()
    for(i in start..end step step) {
        newList.add(this[i])
    }
    newList.toTypedArray()
}


fun Array<Double>.sum() = run {
    var sum = 0.0
    this.forEach {
        sum += it
    }
    sum
}

