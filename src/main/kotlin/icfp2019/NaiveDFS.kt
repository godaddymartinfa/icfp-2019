package icfp2019

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class Graph<T> {
    val adjacencyMap: HashMap<T, HashSet<T>> = HashMap()

    fun addEdge(sourceVertex: T, destinationVertex: T) {
        // Add edge to source vertex / node.
        adjacencyMap
            .computeIfAbsent(sourceVertex) { HashSet() }
            .add(destinationVertex)
        // Add edge to destination vertex / node.
        adjacencyMap
            .computeIfAbsent(destinationVertex) { HashSet() }
            .add(sourceVertex)
    }

    override fun toString(): String = StringBuffer().apply {
        adjacencyMap.keys.forEach {
            append("$it-> ")
            append(adjacencyMap[it]?.joinToString(", ", "[", "]\n"))
        }
    }.toString()
}

class NaiveDFS {
    fun <T> depthFirstTraversal(graph: Graph<T>, startNode: T): String {
        // Mark all the vertices / nodes as not visited.
        val visitedMap = mutableMapOf<T, Boolean>().apply {
            graph.adjacencyMap.keys.forEach { node -> put(node, false) }
        }

        // Create a stack for DFS. Both ArrayDeque and LinkedList implement Deque.
        val stack: Deque<T> = ArrayDeque()

        // Initial step -> add the startNode to the stack.
        stack.push(startNode)

        // Store the sequence in which nodes are visited, for return value.
        val traversalList = mutableListOf<T>()

        // Traverse the graph.
        while (stack.isNotEmpty()) {
            // Pop the node off the top of the stack.
            val currentNode = stack.pop()

            if (!visitedMap[currentNode]!!) {

                // Store this for the result.
                traversalList.add(currentNode)

                // Mark the current node visited and add to the traversal list.
                visitedMap[currentNode] = true

                // Add nodes in the adjacency map.
                graph.adjacencyMap[currentNode]?.forEach { node ->
                    stack.push(node)
                }

            }

        }

        return traversalList.joinToString()
    }
}