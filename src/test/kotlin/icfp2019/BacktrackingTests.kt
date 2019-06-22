package icfp2019

import icfp2019.utils.ProblemFixtureLoader
import org.junit.jupiter.api.Test

class BacktrackingTests {
    @Test
    fun backtrackingAlgo1() {
        val problemFixtureLoader: Problem = ProblemFixtureLoader().fixtureFilePath("/Users/martinfahy/Dev/icfp-2019/problems/prob-003.desc")
        val solution = solve(problemFixtureLoader)
        println(solution)
    }

    @Test
    fun testAvailableMoves() {
        val problemFixtureLoader: Problem = ProblemFixtureLoader().fixtureFilePath("/Users/martinfahy/Dev/icfp-2019/problems/prob-003.desc")
        val gameState =
            GameState(GameBoard.gameBoardOf(problemFixtureLoader), listOf(RobotState(RobotId(0),
                problemFixtureLoader.startingPosition)), listOf(), listOf())

        BackTrackingStrategy().availableMoves(gameState)
    }
}