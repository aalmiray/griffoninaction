class EventsController {
    void mvcGroupInit(Map args) {
        app.addApplicationEventListener([
            ReadyStart: { a ->
                println "ReadyEnd (via Map event handler)"
            }
        ])
        app.addApplicationEventListener("ReadyEnd") { a ->
            println "ReadyEnd (via Closure event handler)"
        }
    }

    def onReadyEnd = { a ->
        println "ReadyEnd (via Closure property event handler)"
    }

    void onReadyStart(a) {
        println "ReadyStart (via method event handler)"
    }
}
