package icfp2019.model

sealed class HotTiles {
    companion object {
        fun fromString(code: Char) = when (code) {
            'B' -> ExtraArm
            'F' -> FastWheels
            'L' -> Drill
            'X' -> CloningLocation
            'C' -> CloneToken
            'R' -> Teleporter
            else -> throw IllegalArgumentException("Unknown hotTiles code: '$code'")
        }
    }

    object Boost : HotTiles()
    object ExtraArm : HotTiles()
    object FastWheels : HotTiles()
    object Drill : HotTiles()
    object Teleporter : HotTiles()

    object CloningLocation : HotTiles()
    object CloneToken : HotTiles()
}
