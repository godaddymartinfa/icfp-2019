package icfp2019.strategies

import icfp2019.Action
import icfp2019.GameState
import icfp2019.Node
import icfp2019.Strategy
import icfp2019.core.DefaultMoveSelector
import icfp2019.core.MoveSelector
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleGraph
import org.jgrapht.traverse.DepthFirstIterator
import org.jgrapht.traverse.GraphIterator
import java.util.*

// Move to an open space and push moves onto a stack, if no moves available then backtrack using the stack
class DFS : Strategy {
    // Returns the problem output string
    override fun apply(undirectedGraph: Graph<Node, DefaultEdge>, gameState: GameState, initialPosition: Node): Iterable<Action>{
        val it: GraphIterator<Node, DefaultEdge>  = DepthFirstIterator<Node, DefaultEdge>(undirectedGraph)
        val visitedMap = mutableMapOf<Node, Boolean>()
        visitedMap.putIfAbsent(initialPosition, true)

        //val debugList: MutableList<String> = mutableListOf()
        val traversalList: MutableList<Action> = mutableListOf()
        while(it.hasNext()) {
            val currentNode: Node = it.next()
            if(!visitedMap.containsKey(currentNode)) {
                // Consume the node if we haven't seen the node before
                val moves: List<Action> = when(!currentNode.hasWrapper()) {
                    true -> DefaultMoveSelector.availableMoves(gameState.robotState, gameState)
                    false -> listOf()
                }

                val pickMove = pickMove(moves)
                traversalList.add(pickMove)
                //debugList.add(pickMove.toSolutionString() + " ${currentNode}")
            }
        }
        return traversalList
    }

    // A "heuristic" for picking movements random shuffle and get the first
    private fun pickMove(moves: List<Action>): Action {
        return moves.shuffled().get(0)
    }
}
