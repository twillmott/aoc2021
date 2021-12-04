object Day3 {

    fun puzzle1(): String {
        val inputs = javaClass.getResource("day3.txt")
            .readText().split("\n")
            .map {n -> n.split("").filter { it.isNotBlank() }}

        var gamma = ""
        var epsilon = ""

        for ((col) in inputs[0].withIndex()) {
            var zeros = 0
            var ones = 0
            for((row, val2) in inputs.withIndex()) {
                if (inputs[row][col] == "0") {
                    zeros++
                }
                if (inputs[row][col] == "1") {
                    ones++
                }
            }
            if (ones > zeros) {
                gamma += "1"
                epsilon += "0"
            }
            if (zeros > ones) {
                gamma += "0"
                epsilon += "1"
            }
        }

        return (Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2)).toString()
    }

    fun puzzle2(): String {
        val inputs = javaClass.getResource("day3.txt")
            .readText().split("\n")
            .map {n -> n.split("").filter { it.isNotBlank() }}

        var oxygenRating = findOxygenRating(inputs)
        var co2ScrubberRating = findCo2ScrubberRating(inputs);

        return (oxygenRating*co2ScrubberRating).toString();
    }

    fun findOxygenRating(inputs: List<List<String>>): Int {
        var instructions = inputs.toMutableList()

        for (col in 0..inputs[0].size) {
            var mcb = getMostCommonBit(instructions, col)
            var filteredInstructions = filterOutInstructions(instructions, mcb, col)
            instructions = filteredInstructions.toMutableList();
            if (filteredInstructions.size == 1) {
                break;
            }
        }
        var oxygenRatingBinary: String = instructions[0].joinToString("") { it }
        return Integer.parseInt(oxygenRatingBinary, 2)
    }

    fun findCo2ScrubberRating(inputs: List<List<String>>): Int {
        var instructions = inputs.toMutableList()

        for (col in 0..inputs[0].size) {
            var lcb = getLeastCommonBit(instructions, col)
            var filteredInstructions = filterOutInstructions(instructions, lcb, col)
            instructions = filteredInstructions.toMutableList();
            if (filteredInstructions.size == 1) {
                break;
            }
        }
        var oxygenRatingBinary: String = instructions[0].joinToString("") { it }
        return Integer.parseInt(oxygenRatingBinary, 2)
    }

    /**
     * Filter out instructions that don't match the MCB in the index column from a list of instructions.
     */
    private fun filterOutInstructions(diagnosticInstructions: List<List<String>>, mcb: String, index: Int): List<List<String>> {
        var filteredInstructions = mutableListOf<List<String>>()
        for (instruction in diagnosticInstructions) {
            if (instruction[index].equals(mcb)) filteredInstructions.add(instruction);
        }
        return filteredInstructions.toList();
    }

    /**
     * Find the LCB for a list of inputs at the given column index.
     */
    private fun getLeastCommonBit(inputs: List<List<String>>, columnIndex: Int): String {
        return if (getMostCommonBit(inputs, columnIndex) == "1") "0" else "1"
    }

    /**
     * Find the MCB for a list of inputs at the given column index.
     */
    private fun getMostCommonBit(inputs: List<List<String>>, columnIndex: Int): String {
        var zeros = 0;
        var ones = 0;
        for (input in inputs) {
            var bit = (input[columnIndex])
            if (bit.equals("0")) {
                zeros++;
            } else if (bit.equals("1")) {
                ones++;
            }
        }
        return if (zeros > ones) "0" else "1"
    }
}