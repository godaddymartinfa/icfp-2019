package icfp2019.model

data class RobotState(
    val robotId: RobotId,
    val currentPosition: Point,
    val orientation: Orientation = Orientation.Up,
    val remainingFastWheelTime: Int? = null,
    val remainingDrillTime: Int? = null
) {
    fun checkOpenOrientations(): MutableList<Orientation> {
        return when(orientation) {
            Orientation.Up -> mutableListOf(Orientation.Down, Orientation.Left, Orientation.Right)
            Orientation.Left -> mutableListOf(Orientation.Up, Orientation.Down, Orientation.Right)
            Orientation.Right -> mutableListOf(Orientation.Down, Orientation.Up, Orientation.Right)
            Orientation.Down -> mutableListOf(Orientation.Up, Orientation.Down, Orientation.Right)
        }
    }
}
