package icfp2019

import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleGraph
import org.jgrapht.traverse.DepthFirstIterator
import org.jgrapht.traverse.GraphIterator
import java.util.*

// Move to an open space and push moves onto a stack, if no moves available then backtrack using the stack
class BackTrackingStrategy : Strategy {
    // Returns the problem output string
    override fun getActions(undirectedGraph: SimpleGraph<Node, DefaultEdge>, gameState: GameState): String {
        val it: GraphIterator<Node, DefaultEdge>  = DepthFirstIterator<Node, DefaultEdge>(undirectedGraph)
        val visitedMap = mutableMapOf<Node, Boolean>()
        while(it.hasNext()) {
            val currentNode: Node = it.next()
            if(!visitedMap.containsKey(currentNode)) {
                // Consume the node if we haven't seen the node before
                when(nodeIsConsumable(currentNode)) {
                    true -> gameStateMovement()
                }
            }
        }
        return movement;
    }

    private fun nodeIsConsumable(currentNode: Node): Boolean{
        return !currentNode.isWrapped
    }

    private fun gameStateMovement() {

    }
}
