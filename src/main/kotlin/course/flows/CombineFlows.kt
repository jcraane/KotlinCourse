package course.flows

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class, FlowPreview::class, ExperimentalCoroutinesApi::class)
fun main() = runBlocking<Unit>{
// Given two flows of integers, combine them into a single flow of pairs
    // Make sure vakues are not outputted to fast

    val flow1 = flowOf(1, 2, 3)
        .map { "$it from flow 1" }
        .onEach { delay(500.milliseconds) }
    val flow2 = flowOf(2, 3, 4)
        .map { "$it from flow 2" }
        .onEach { delay(200.milliseconds) }


//    todo is dit correct?
    /*val combinedFlow = flowOf(flow1, flow2)
        .flatMapMerge { it }
        .sample(500.milliseconds)

    combinedFlow.collect { println(it) }*/

    /*flowOf(flow1, flow2)
        .flattenMerge()
        .sample(500.milliseconds)
        .collect { println(it) }*/

    merge(flow1, flow2)
        .sample(500.milliseconds)
        .collect { println(it) }
}

