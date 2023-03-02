package course

import kotlin.random.Random


fun main() {
    // Celcius to Fahrenheit conversion
    val inputOutputMapping = mapOf(
        0.0 to 32.0,
        10.0 to 50.0,
        20.0 to 68.0,
        35.0 to 95.0,
    )

    val learningRate = 0.001
    val numIterations = 100000

    val linearRegression = LinearRegression(
        trainingData = inputOutputMapping,
        learningRate = learningRate,
        numIterations = numIterations
    )

    println(linearRegression.predict(100.0)) // outputs 212
}

@Suppress("UNCHECKED_CAST")
class LinearRegression<INPUT, OUTPUT>(
    private val trainingData: Map<INPUT, OUTPUT>,
    private val learningRate: Double,
    private val numIterations: Int,
) {
    private var theta0 = Random.nextDouble()
    private var theta1 = Random.nextDouble()

    init {
        train()
    }

    private fun train() {
        for (i in 0 until numIterations) {
            var sum0 = 0.0
            var sum1 = 0.0
            trainingData.entries.forEach { entry ->
                val prediction = theta0 + theta1 * (entry.key as Double)
                sum0 += prediction - (entry.value as Double)
                sum1 += (prediction - (entry.value as Double)) * (entry.key as Double)
            }
            theta0 -= learningRate * sum0 / trainingData.size
            theta1 -= learningRate * sum1 / trainingData.size
        }
    }

    fun predict(input: INPUT): OUTPUT {
        return (theta0 + theta1 * (input as Double)) as OUTPUT
    }
}
