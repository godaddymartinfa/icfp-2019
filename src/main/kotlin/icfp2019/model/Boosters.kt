package icfp2019.model

sealed class Boosters {
    companion object {
        fun fromString(code: Char) = when (code) {
            'B' -> ExtraArm
            'F' -> FastWheels
            'L' -> Drill
            'X' -> CloningLocation
            'C' -> CloneToken
            'R' -> Teleporter
            else -> throw IllegalArgumentException("Unknown boosters code: '$code'")
        }
    }

    object ExtraArm : Boosters()
    object FastWheels : Boosters()
    object Drill : Boosters()
    object Teleporter : Boosters()

    object CloningLocation : Boosters()
    object CloneToken : Boosters()
}
