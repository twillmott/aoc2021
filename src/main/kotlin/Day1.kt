object Day1 {
    fun puzzle1(): String {
        val inputs = getInputs("day1puz1.txt");
        var increaseCount = 0
        inputs.forEachIndexed {index, i ->
            if (index != 0 && i - inputs[index - 1] > 0.0) increaseCount++
        }
        return increaseCount.toString()
    }

    fun puzzle2(): String {
        var inputs = getInputs("day1puz2.txt");
        var increaseCount = 0
        inputs.forEachIndexed {index, i ->
            if (index > 0  && index < inputs.size - 2) {
                val firstWindow = inputs[index - 1] + inputs[index] + inputs[index + 1]
                val secondWindow = inputs[index] + inputs[index + 1] + inputs[index + 2]
                if (secondWindow > firstWindow) increaseCount++
            }
        }
        return increaseCount.toString()
    }

    private fun getInputs(file: String): List<Int> {
        return javaClass.getResource(file)
            .readText().split("\n")
            .map {n -> n.toInt()}
    }
}