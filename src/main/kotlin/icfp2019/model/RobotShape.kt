package icfp2019.model

import icfp2019.analyzers.MoveAnalyzer
import icfp2019.core.Analyzer
import umontreal.ssj.util.BitMatrix

data class RobotShape(val bitMatrix: BitMatrix,
                      val gameBoard: GameBoard,
                      val gameState: GameState,
                      private var currentArmPosition1: Point,
                      private var currentArmPosition2: Point,
                      private var currentArmPosition3: Point) {


    // Game State and board for now till they're merged
    fun initialState() : () -> Unit {
        return {
            gameState.robotState.forEach {
                robotKey, robotStateValue ->
                MoveAnalyzer.analyze(gameBoard)(gameState)(robotStateValue.robotId, Action.DoNothing)
                    .takeIf { true }
                    ?.let {
                        currentArmPosition1 = Point(robotStateValue.currentPosition.x + 1, robotStateValue.currentPosition.y)
                        currentArmPosition2 = Point(robotStateValue.currentPosition.x + 1, robotStateValue.currentPosition.y + 1)
                        currentArmPosition3 = Point(robotStateValue.currentPosition.x + 1, robotStateValue.currentPosition.y - 1)
                    }?.run {
                        // Get rid of side-effects
                        with(bitMatrix) {
                            setBool(robotStateValue.currentPosition.x, robotStateValue.currentPosition.y, true)
                            setBool(robotStateValue.currentPosition.x + 1, robotStateValue.currentPosition.y, true)
                            setBool(robotStateValue.currentPosition.x + 1, robotStateValue.currentPosition.y + 1, true)
                            setBool(robotStateValue.currentPosition.x + 1, robotStateValue.currentPosition.y - 1, true)
                        }
                    }
            }
        }
    }

    fun paint() {

    }
}
