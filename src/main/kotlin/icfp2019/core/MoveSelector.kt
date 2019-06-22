package icfp2019.core

import icfp2019.*

interface MoveSelector {
    fun selectFrom(strategies: Iterable<Strategy>): (map: GameBoard) -> (state: GameState) -> Proposal
}

object DefaultMoveSelector : MoveSelector {
    override fun selectFrom(strategies: Iterable<Strategy>): (map: GameBoard) -> (state: GameState) -> Proposal {
        TODO("not implemented") // To change body of created functions use File | Settings | File Templates.
    }

    fun availableMoves(robot: RobotState, gameState: GameState): List<Action> {
        val moves = mutableListOf<Action>()
        val cell = gameState.gameBoard.get(robot.currentNode.point)

        // Asking about a bad location... No moves
        if (!gameState.gameBoard.isInBoard(robot.currentNode.point)) {
            return moves
        }

        // Things independent of point or location
//        moves.add(Action.DoNothing)
//        moves.add(Action.TurnClockwise)
//        moves.add(Action.TurnCounterClockwise)
//        moves.add(Action.PlantTeleportResetPoint)
//        for (location: Point in gameState.teleportDestination) {
//            moves.add(Action.TeleportBack(location))
//        }

        fun canMoveTo(point: Point): Boolean {
            return gameState.gameBoard.isInBoard(point) && !cell.isObstacle
        }

        // Check directions
        if (canMoveTo(robot.currentNode.point.up())) {
            moves.add(Action.MoveUp)
        }

        if (canMoveTo(robot.currentNode.point.down())) {
            moves.add(Action.MoveDown)
        }

        if (canMoveTo(robot.currentNode.point.right())) {
            moves.add(Action.MoveRight)
        }

        if (canMoveTo(robot.currentNode.point.left())) {
            moves.add(Action.MoveLeft)
        }

        // Are we on a clone point?
        if (cell.hasBooster(Booster.CloningLocation)) {
            moves.add(Action.CloneRobot)
        }

        return moves
    }
}
