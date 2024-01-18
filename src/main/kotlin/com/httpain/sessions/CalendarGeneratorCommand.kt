package com.httpain.sessions

import picocli.CommandLine
import picocli.CommandLine.ArgGroup
import picocli.CommandLine.Spec
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Parameters
import java.util.concurrent.Callable
import kotlin.system.exitProcess

@Command(
    name = "calgen",
    mixinStandardHelpOptions = true,
    version = ["0.1"],
    description = ["TODO"]
)
class CalendarGeneratorCommand : Callable<Int> {

    @ArgGroup(multiplicity = "0..*", exclusive = false)
    var recurrence: List<RecurrenceArgGroup> = mutableListOf()

    class RecurrenceArgGroup {
        @Option(names = ["-r", "--repeat"], required = true)
        var placeholder: Boolean = true

        @Parameters(arity = "2")
        var repeat: List<String> = mutableListOf()
    }

    @Option(
        names = ["-d", "--duration"],
        description = ["Event duration. Valid examples: 1h30m, 45m, 3h (case-insensitive)."]
    )
    var duration: String = "1h"

    @Spec
    lateinit var spec: CommandLine.Model.CommandSpec


    override fun call(): Int {
        spec.commandLine().out.println("recurrence: '${recurrence.map { it.repeat }}'")
        spec.commandLine().out.println("duration: '$duration'")
        return 0
    }
}

fun main(args: Array<String>): Unit = exitProcess(CommandLine(CalendarGeneratorCommand()).execute(*args))