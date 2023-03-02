package course.examples

private interface Element {}

fun main() {
    data class TextElement(val value: String) : Element {
        override fun toString(): String {
            return value
        }
    }

    class HtmlElement(val name: String) : Element {
        val children = mutableListOf<Element>()
        val attributes = hashMapOf<String, String>()

        fun child(init: HtmlElement.() -> Unit) {
            val child = HtmlElement("child")
            child.init()
            children.add(child)
        }

        operator fun String.unaryPlus() {
            children.add(TextElement(this))
        }

        override fun toString() =
            "<$name ${attributes.map { "${it.key}='${it.value}'" }.joinToString(" ")}>${children.joinToString("")}</$name>"
    }

    fun html(init: HtmlElement.() -> Unit): HtmlElement {
        val html = HtmlElement("html")
        html.init()
        return html
    }

    val result = html {
        child {
            child {
                +"text"
            }
        }
    }

    println(result)
    // Output:
// <html><child><child>text</child></child></html>
}


