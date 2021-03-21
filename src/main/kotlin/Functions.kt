import org.jetbrains.numkt.core.*
import org.jetbrains.numkt.math.*
import org.jetbrains.numkt.*
import org.jetbrains.numkt.statistics.mean

@ExperimentalNumkt
class Functions {
    /**
     * Do numerical integration of x
     */
    fun numIntegration(x: KtNDArray<Float>): Float {
        val term1: Float = sum(x[1..None..1])
        val term2: Float = sum(x[None..-1..1])
        return (term1 + term2)/(Constants.SR*2);
    }

    /**
     * Moore's Algorithm
     * Compute the Freeze Index
     */
    fun fi(data: KtNDArray<Float>) {
        val jPos = Constants.windowLength
        val i_max: Int = (data.shape[0] / Constants.stepSize).toInt()

        val time = zeros<Int>(i_max)
        for (i in 0..i_max) {
            val jStart = i * Constants.stepSize
            val jPos = jStart + Constants.windowLength

            // Time (sample nr) of this window
            val time[i] = jStart

            // get the signal in the window
            var y = data[jStart..jPos]
            y = y - mean(y)  // make signal zero-mean (mean normalization)

            // compute FFT (Fast Fourier Transform)
            val Y = fft(y, Constants.NFFT)
            Pyy = Y * conj(Y) / Constants.NFFT

        }
    }
}