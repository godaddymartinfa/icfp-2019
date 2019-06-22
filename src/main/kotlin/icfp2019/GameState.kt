package icfp2019

data class GameState(
    val gameBoard: GameBoard,
    val robotState: RobotState // For now one robot
//    val teleportDestination: List<Point>,
//    val unusedBoosters: List<Booster>
)
