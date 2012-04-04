package marco

import griffon.transform.EventPublisher

@EventPublisher
class MarcoController {
    def model

    void mvcGroupInit(Map args) {
        def createAPlayerAndRegisterIt = { int id ->
            def player = new Player(id)
            addEventListener(player)
            player.addEventListener(delegate)
        }
        (1..3).each { createAPlayerAndRegisterIt(it) }
        addEventListener(new Player(4))
        new Player(5)
    }

    def marco = { evt = null ->
        execInsideUISync { model.output = '' }
        publishEvent 'Marco'
    }

    def onPolo = { msg ->
        execInsideUIAsync { model.output += msg + '\n' }
    }
}
