class Models {

    data class NavigationInstruction(
        val direction: Direction,
        val distance: Int
    ) {
        constructor(instruction: String) : this(
            Direction.valueOf(instruction.split(" ")[0].uppercase()),
            instruction.split(" ")[1].toInt()
        ) {
        }
    }

    enum class Direction(val direction: String) {
        FORWARD("forward"),
        DOWN("down"),
        UP("up");

    }
}