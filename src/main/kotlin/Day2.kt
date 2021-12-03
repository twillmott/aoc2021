object Day2 {

    fun puzzle1(): String {
        val inputs = javaClass.getResource("day2.txt")
            .readText().split("\n")
            .map {n -> Models.NavigationInstruction(n)}

        var forward = 0
        var down = 0

        inputs.forEach {input ->
            when(input.direction) {
               Models.Direction.FORWARD -> forward += input.distance
               Models.Direction.UP -> down -= input.distance
               Models.Direction.DOWN -> down += input.distance
            }
        }

        return "Forward: " + forward + " Down: " + down + " Total: " + forward * down;
    }

    fun puzzle2(): String {
        val inputs = javaClass.getResource("day2.txt")
            .readText().split("\n")
            .map {n -> Models.NavigationInstruction(n)}

        var forward = 0
        var down = 0
        var aim = 0

        inputs.forEach {input ->
            when(input.direction) {
                Models.Direction.FORWARD -> {
                    forward += input.distance
                    down += aim * input.distance
                }
                Models.Direction.UP -> aim -= input.distance
                Models.Direction.DOWN -> aim += input.distance
            }
        }

        return "Forward: " + forward + " Down: " + down + " Total: " + forward * down;
    }
}