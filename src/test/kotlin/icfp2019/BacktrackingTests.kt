package icfp2019

import icfp2019.utils.ProblemFixtureLoader
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BacktrackingTests {
    @Test
    fun backtrackingAlgo1() {
        val problemFixtureLoader: Problem = ProblemFixtureLoader().fixtureFilePath("../problems/prob-003.desc")
        val solution = solve(problemFixtureLoader)


    }
}