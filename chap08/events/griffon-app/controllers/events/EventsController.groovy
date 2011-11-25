package events

class EventsController {
    void mvcGroupInit(Map params) {
        app.addApplicationEventListener([
            ReadyStart: { a ->
                println "ReadyEnd (via Map closure event handler)"
            },
            ReadyEnd: new RunnableWithArgs() {
                public void run(Object[] args) {
                    println "ReadyEnd (via Map runnable event handler)"
                }
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
