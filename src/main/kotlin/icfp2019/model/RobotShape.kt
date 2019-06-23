package icfp2019.model

import icfp2019.analyzers.MoveAnalyzer
import icfp2019.core.Analyzer
import umontreal.ssj.util.BitMatrix

data class RobotShape(val bitMatrix: BitMatrix,
                      val gameBoard: GameBoard,
                      val gameState: GameState) {

    // Game State and board for now till they're merged
    fun initialConfiguration() : () -> Unit {
        return {
            gameState.robotStateList.forEach { robotState ->
                MoveAnalyzer.analyze(gameBoard)(gameState)(robotState.robotId, Action.DoNothing)
                    .takeIf { it == true }
                    ?.let {
                        val copiedBitMatrix: Any = immutableCopyOf()
                        copiedBitMatrix.setBool(robotState.currentPosition.x, robotState.currentPosition.y, true)
                        copiedBitMatrix.setBool(robotState.currentPosition.x + 1, robotState.currentPosition.y, true)
                        copiedBitMatrix.setBool(robotState.currentPosition.x + 1, robotState.currentPosition.y - 1, true)
                    }
            }
        }
    }


    // Create an immutable copy
    fun immutableCopyOf(): {
        return BitMatrix(bitMatrix.numRows(), bitMatrix.numColumns())
    }

    override fun hashCode(): Int {
        return bitMatrix.hashCode()
    }


}
