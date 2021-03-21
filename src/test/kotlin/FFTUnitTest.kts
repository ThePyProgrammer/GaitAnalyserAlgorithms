import com.thepyprogrammer.gaitanalyzeralgos.Complex
import com.thepyprogrammer.gaitanalyzeralgos.FFT
import kotlin.math.sqrt

val arr = arrayOf(Complex(0.0), Complex(0.5), Complex(sqrt(3.0)/2), Complex(1.0), Complex(sqrt(3.0)/2), Complex(0.5), Complex(0), Complex(-0.5)) // y = sin(pi*t/3)

println(arr.size)

val fft = FFT.fft(arr)

println(fft)