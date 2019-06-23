package icfp2019.analyzers

import icfp2019.GameBoard
import icfp2019.GameState
import icfp2019.Node
import icfp2019.core.Analyzer
import icfp2019.strategies.DFSStrategy
import org.jgrapht.graph.DefaultEdge

object DFSAnalyzer : Analyzer<DFSStrategy<Node, DefaultEdge>> {
    override fun analyze(map: GameBoard): (state: GameState) -> DFSStrategy<Node, DefaultEdge> {
        val completeGraph = GraphAnalyzer.analyze(map)
        return { graphState ->
            DFSStrategy(completeGraph(graphState))
        }
    }
}