package icfp2019.strategies

import icfp2019.analyzers.GraphAnalyzer
import icfp2019.core.MoveSelector
import icfp2019.core.Proposal
import icfp2019.core.Strategy
import icfp2019.model.Action
import icfp2019.model.GameBoard
import icfp2019.model.GameState
import icfp2019.model.Node
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.traverse.DepthFirstIterator
import org.jgrapht.traverse.GraphIterator

// Move to an open space and push moves onto a stack, if no moves available then backtrack using the stack
object DFSStrategy : Strategy {
    override fun compute(map: GameBoard): (state: GameState) -> Proposal {
        return { gameState ->
            val undirectedGraph: Graph<Node, DefaultEdge> = GraphAnalyzer.analyze(map).invoke(gameState)
            val it: GraphIterator<Node, DefaultEdge> = DepthFirstIterator<Node, DefaultEdge>(undirectedGraph)
            val visitedMap = mutableMapOf<Node, Boolean>()
            visitedMap.putIfAbsent(gameState.robotState.currentNode, true)

            val traversalList: MutableList<Action> = mutableListOf()
            while (it.hasNext()) {
                val currentNode: Node = it.next()
                if (!visitedMap.containsKey(currentNode)) {
                    // Consume the node if we haven't seen the node before
                    val moves: List<Action> = when (!currentNode.isWrapped) {
                        true -> MoveSelector.availableMoves(gameState.robotState, gameState)
                        false -> listOf()
                    }

                    traversalList.add(pickMove(moves))
                }
            }
            traversalList
        }
    }

    // A "heuristic" for picking movements random shuffle and get the first
    private fun pickMove(moves: List<Action>): Action {
        return moves.shuffled().first()
    }
}
