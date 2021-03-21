import org.jetbrains.numkt.core.*
import org.jetbrains.numkt.math.*
import org.jetbrains.numkt.*
import kotlin.math.pow
import kotlin.math.roundToInt

@ExperimentalNumkt
object Constants {
    val SR = 64F
    val stepSize = 1F
    val offDelay = 2F
    val onDelay = 2F

    val NFFT = 256F
    val windowLength = 256F
    val locoBand = array(arrayOf<Float>(0.5F, 3F))
    val freezeBand = array(arrayOf<Float>(3F, 8F))

    val f_res: Float = SR / NFFT
    val f_nr_LBs: Int? = locoBand[0, 0].scalar?.div(f_res)?.let { it.roundToInt() }
    val f_nr_LBe: Int? = locoBand[0, 1].scalar?.div(f_res)?.let { it.roundToInt() }
    val f_nr_FBs: Int? = freezeBand[0, 0].scalar?.div(f_res)?.let { it.roundToInt() }
    val f_nr_FBe: Int? = freezeBand[0, 1].scalar?.div(f_res)?.let { it.roundToInt() }

    val d = NFFT / 2

    val freezeTH = 1.5F
    val powerTH = 2F.pow(11.5F)

}