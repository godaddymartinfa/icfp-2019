package icfp2019.analyzers

import icfp2019.core.Analyzer
import icfp2019.core.Proposal
import icfp2019.model.GameBoard
import icfp2019.model.GameState
import icfp2019.strategies.DFSStrategy

object DFSAnalyzer : Analyzer<Proposal> {
    override fun analyze(map: GameBoard): (state: GameState) -> Proposal {
        val completeGraph = GraphAnalyzer.analyze(map)
        return { graphState ->
            DFSStrategy.compute(map).invoke(graphState)
        }
    }
}