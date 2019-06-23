package icfp2019.model

data class Node(
    val point: Point,
    val isObstacle: Boolean,
    val isWrapped: Boolean = false,
    val hotTiles: HotTiles? = null
) {
    fun hasBooster(hotTiles: HotTiles): Boolean {
        if (this.hotTiles != null) {
            return this.hotTiles == hotTiles
        }
        return false
    }
}
