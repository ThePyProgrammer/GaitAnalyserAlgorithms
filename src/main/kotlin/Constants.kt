import org.jetbrains.numkt.core.*
import org.jetbrains.numkt.math.*
import org.jetbrains.numkt.*
import kotlin.math.pow
import kotlin.math.roundToInt

@ExperimentalNumkt
object Constants {
    val SR = 64.0
    val stepSize = 1.0
    val offDelay = 2.0
    val onDelay = 2.0

    val NFFT = 256.0
    val windowLength = 256.0
    val locoBand = array(arrayOf(0.5, 3.0))
    val freezeBand = array(arrayOf(3.0, 8.0))

    val f_res = SR / NFFT
    val f_nr_LBs: Int = locoBand[0, 0].scalar?.div(f_res)?.let { it.roundToInt() }!!
    val f_nr_LBe: Int = locoBand[0, 1].scalar?.div(f_res)?.let { it.roundToInt() }!!
    val f_nr_FBs: Int = freezeBand[0, 0].scalar?.div(f_res)?.let { it.roundToInt() }!!
    val f_nr_FBe: Int = freezeBand[0, 1].scalar?.div(f_res)?.let { it.roundToInt() }!!

    val d = NFFT / 2

    val freezeTH = 1.5
    val powerTH = 2.0.pow(11.5)

}