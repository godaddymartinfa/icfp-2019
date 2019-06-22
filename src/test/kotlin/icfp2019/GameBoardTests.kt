package icfp2019

import icfp2019.utils.ProblemFixtureLoader
import org.junit.jupiter.api.Test

class GameBoardTests {
    @Test
    fun buildAGameBoard() {
        val problemFixtureLoader: Problem = ProblemFixtureLoader().fixtureFilePath("/Users/martinfahy/Dev/icfp-2019/problems/prob-003.desc")
        val gameBoardOf: GameBoard = GameBoard.gameBoardOf(problemFixtureLoader)
        println(gameBoardOf.cells)
    }
}