package icfp2019

import org.jgrapht.Graph
import org.jgrapht.graph.DefaultEdge

interface Strategy {
    // Given a state, return a list of actions, indexed by Robot id.
    fun apply(undirectedGraph: Graph<Node, DefaultEdge>, gameState: GameState, initialPosition: Node): Iterable<Action>
}