package course.examples

fun main() {
    class LoggingService{
        fun log(reportEntry: String){
            println("Reporting: $reportEntry")
        }
    }

    class AnalyticsService{
        fun report(reportEntry: String){
            println("Reporting Analytics: $reportEntry")
        }
    }

    class Processor{
        fun process(
            data: String,
            service: LoggingService,
            analyticsService: AnalyticsService,
        ){
            processData(data)
            service.log("$data processed")
            analyticsService.report("$data processed")
        }

        private fun processData(data: String){
            println("Processing $data")
        }
    }

    val service = LoggingService()
    val analyticsService = AnalyticsService()
    val processor = Processor()
    with (processor){
        process("Can't this", service, analyticsService)
        process("be done", service, analyticsService)
        process("more elegantly?", service, analyticsService)
    }

    class ProcessorWithReceivers {
        context(LoggingService, AnalyticsService)
        fun process(data: String){
            processData(data)
            log(data)
            report(data)
        }

        private fun processData(data: String){
            println("Processing $data")
        }
    }

    val processorWithReceivers = ProcessorWithReceivers()
    with(LoggingService()){
        with(AnalyticsService()) {
            processorWithReceivers.process("Yes!")
            processorWithReceivers.process("It can")
        }
    }
}
