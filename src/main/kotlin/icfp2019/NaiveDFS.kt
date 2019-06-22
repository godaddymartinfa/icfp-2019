package icfp2019

import java.util.*

class NaiveDFS {
    fun depthFirstTraversal(graph: Array<Array<Node>>, startNode: Node): String {
        // Mark all the vertices / nodes as not visited.
        val visitedMap = mutableMapOf<Node, Boolean>().apply {
            graph.forEach { eachArr ->
                eachArr.forEach {
                    put(it, false)
                }
            }
        }


        // Create a stack for DFS. Both ArrayDeque and LinkedList implement Deque.
        val stack: Deque<Node> = ArrayDeque()

        // Initial step -> add the startNode to the stack.
        stack.push(startNode)

        // Store the sequence in which nodes are visited, for return value.
        val traversalList = mutableListOf<Node>()

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
                graph.get(currentNode.point.x).forEach { node ->
                    stack.push(node)
                }
            }

        }

        return traversalList.joinToString()
    }
}