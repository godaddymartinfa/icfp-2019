package icfp2019.core

<<<<<<< HEAD
import icfp2019.Action
import icfp2019.GameBoard
import icfp2019.GameState
=======
import icfp2019.model.GameBoard
import icfp2019.model.GameState
>>>>>>> master

interface Strategy {
    fun compute(map: GameBoard): (state: GameState) -> Proposal
    fun computePath(map: GameBoard): (state: GameState) -> List<Action>
}
