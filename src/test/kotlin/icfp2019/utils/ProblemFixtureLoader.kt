package icfp2019.utils

import icfp2019.Problem
import icfp2019.parseDesc
import icfp2019.solve
import java.io.File
import java.lang.IllegalStateException
import java.nio.file.Paths

class ProblemFixtureLoader {
    fun fixtureFilePath(filePath: String): Problem {
        val problemFile = File(filePath)
        return when {
            problemFile.exists() && problemFile.extension.equals("desc") -> parseDesc(problemFile.readText())
            else -> throw IllegalStateException("Cannot find file with filepath: ${filePath}")
        }
    }
}
