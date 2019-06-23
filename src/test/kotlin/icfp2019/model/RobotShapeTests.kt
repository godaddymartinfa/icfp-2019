package icfp2019.model

import icfp2019.parseTestMap
import org.junit.jupiter.api.Test

class RobotShapeTests {
    val map = """
                XXXXXXXXXXXXXXXXXXXXXXXXXX
                XX..XXXXXXXXXXXXXX..XXXXXX
                XX..XXXXXXXXXXXXXX..XXXXXX
                XX..XXXXXXXXXXXXXX..XXXXXX
                XX..XXXXXXXXXXXXXX..XXXXXX
                XX...XXXXXXXXXXXX...XXXXXX
                XX...XXXXXXXXXXXX...XXXXXX
                XX...XXXXXX.XXXXX...XXXXXX
                XX...XXXXX..XXXXX...XXXXXX
                XX....XXXX..XXXX....XXXXXX
                XX.....XX....XX.....XXXXXX
                XXwwwwwwwwwwwwwwwwwwwwXXXX
                XXwwwwwwwwwwwwwwwwwwwwXXXX
                XXwwwwwwwwwwwwwwwwwwwwXXXX
                XXwwwwwwwwwwwwwwwwwwwwXXXX
                XXwwwwwwwwwwwwwwwwwwwwXXXX
                XXwwwwwwww@wwwwwwwwwwwXXXX
                XXXXXXXXXXXXXXXXXXXXXXXXXX"""

    @Test
    fun testRobotShape() {
        val problem = parseTestMap(map)
        problem.startingPosition
    }
}