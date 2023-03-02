package course.assignments.solutions

fun main() {
    class Row(val cells: MutableList<String> = mutableListOf()) {
        operator fun String.unaryPlus() {
            cells.add(this)
        }
    }

    class Table(val rows: MutableList<Row> = mutableListOf()) {
        fun row(init: Row.() -> Unit) {
            val row = Row()
            row.init()
            rows.add(row)
        }

        operator fun Row.unaryPlus() {
            rows.add(this)
        }

        override fun toString(): String {
            val sb = StringBuilder()
            val maxCols = rows.map { it.cells.size }.max()
            rows.forEachIndexed() { index, row ->
                val renderHeader = index == 1
                if (renderHeader) {
                    sb.append("|")
                    for (i in 1..maxCols) {
                        sb.append("----|")
                    }
                    sb.append("\n")
                }

                for (cell in row.cells) {
                    sb.append("| $cell ")
                    for (i in 1..(maxCols - row.cells.size)) {
                        sb.append("|")
                    }
                }
                sb.append("|\n")

            }
            return sb.toString()
        }
    }

    fun table(init: Table.() -> Unit): Table {
        val table = Table()
        table.init()
        return table
    }

    val result = table {
        row {
            + "Name"
            + "Age"
            + "City"
        }
        row {
            + "John"
            + "42"
            + "London"
        }
        row {
            + "Jane"
            + "36"
            + "Paris"
        }
    }

    println(result)
}
