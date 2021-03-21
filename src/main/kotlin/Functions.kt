import Constants.NFFT
import Constants.SR
import Constants.f_nr_FBe
import Constants.f_nr_FBs
import Constants.f_nr_LBe
import Constants.f_nr_LBs
import Constants.powerTH
import Constants.stepSize
import Constants.windowLength
import org.jetbrains.numkt.core.*
import org.jetbrains.numkt.math.*
import org.jetbrains.numkt.*
import org.jetbrains.numkt.statistics.mean

@ExperimentalNumkt
class Functions {
    /**
     * Do numerical integration of x
     */
    fun numIntegration(x: Array<Double>): Double {
        val term1: Double = x.slice(1, x.size).sum()
        val term2: Double = x.slice(0, -1).sum()
        return (term1 + term2)/(SR*2);
    }

    /**
     * Moore's Algorithm
     * Compute the Freeze Index
     */
    fun fi(data: KtNDArray<Double>) {
        var jPos: Double
        val i_max: Int = (data.shape[0] / stepSize).toInt()

        val time = zeros<Int>(i_max)
        val freezeIndex = zeros<Double>(i_max)
        for (i in 0..i_max) {
            val jStart = i * stepSize
            jPos = jStart + windowLength

            // Time (sample nr) of this window
            time[i] = jStart.toInt()


            // get the signal in the window
            var y = data[jStart..jPos]
            y = y - mean(y)  // make signal zero-mean (mean normalization)

            // compute FFT (Fast Fourier Transform)
            val Y = FFT.fft(y)
            val Pyy: Array<Double> = Y.timesConj() / NFFT


            //--- calculate sumLocoFreeze and freezeIndex --- [f_nr_LBs..f_nr_LBe]
            val areaLocoBand = numIntegration(Pyy.slice(f_nr_LBs,f_nr_LBe, 1))
            val areaFreezeBand = numIntegration(Pyy.slice(f_nr_FBs,f_nr_FBe, 1))

            // Extension of Baechlin to handle low-energy situations (e.g. standing)
            freezeIndex[i] = if(areaFreezeBand + areaLocoBand >= powerTH) areaFreezeBand / areaLocoBand else 0.0

        }
    }
}