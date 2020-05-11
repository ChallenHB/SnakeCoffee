package hb.challen

import org.graalvm.polyglot.Context
import org.graalvm.polyglot.Source
import org.graalvm.polyglot.Value
import java.io.File

class SnakeCoffeeProcess {

    fun run() {
        for (p in loadPlugins())
            p.runCode()
    }

    private fun loadPlugins(): Sequence<Plugin> {
       return listOf<Plugin>(MyPlugin()).asSequence()
    }

}

class MyPlugin : Plugin {

    override fun runCode() {
        val polyglot = Context.create()
        val array: Value = polyglot.eval("js", "[1, 2, 34]")

        val result: Int = array.getArrayElement(2).asInt()
        println("My Plugin Code javascript output = $result")

        // Load Javascript file and execute
        // Long running processes?
        val file = File("plugins", "example-plugin.js")
        val language = Source.findLanguage(file)
        val source = Source.newBuilder(language, file).build()

        polyglot.eval(source)

    }

}
