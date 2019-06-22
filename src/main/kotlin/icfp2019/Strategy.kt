package icfp2019

import org.jgrapht.graph.DefaultEdge
import org.jgrapht.graph.SimpleGraph

interface Strategy {
    // Given a state, return a list of actions, indexed by Robot id.
    fun getActions(undirectedGraph: SimpleGraph<Node, DefaultEdge>, gameState: GameState): String
}