package com.httpain.sessions

import picocli.CommandLine
import picocli.CommandLine.Spec
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import java.util.concurrent.Callable
import kotlin.system.exitProcess
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.toDuration

@Command(name = "foo", mixinStandardHelpOptions = true, version = ["foo 0.1"], description = ["Prints something to STDOUT."])
class FooCommand: Callable<Int> {

    @Option(names = ["-b", "--bar"], description = ["whatever"])
    var bar: String = "N/A"

    @Option(names = ["-d", "--duration"], description = ["something else"])
    var duration: Duration = 1.toDuration(DurationUnit.HOURS)

    @Spec
    lateinit var spec: CommandLine.Model.CommandSpec


    override fun call(): Int {
        spec.commandLine().out.println("bar: '$bar'")
        spec.commandLine().out.println("duration: '$duration'")
        return 0
    }
}

fun main(args: Array<String>) : Unit = exitProcess(CommandLine(FooCommand()).execute(*args))