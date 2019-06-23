package icfp2019.model

import icfp2019.analyzers.MoveAnalyzer
import icfp2019.core.Analyzer
import umontreal.ssj.util.BitMatrix

data class RobotShape(val bitMatrix: BitMatrix,
                      val gameBoard: GameBoard,
                      val gameState: GameState) {
    // Game State and board for now till they're merged
    fun paintInitialConfiguration() : () -> Unit {
        return {
            gameState.robotState.forEach {
                key, value ->
                MoveAnalyzer.analyze(gameBoard)(gameState)(value.robotId, Action.DoNothing)
                    .takeIf { true }
                    ?.run {
                        // Get rid of side-effects
                        with(bitMatrix) {
                            setBool(value.currentPosition.x, value.currentPosition.y, true)
                            setBool(value.currentPosition.x + 1, value.currentPosition.y, true)
                            setBool(value.currentPosition.x + 1, value.currentPosition.y + 1, true)
                            setBool(value.currentPosition.x + 1, value.currentPosition.y - 1, true)
                        }
                    }
            }
        }
    }

    fun paint() {

    }

    override fun hashCode(): Int {
        return bitMatrix.hashCode()
    }


}
