package marco

import griffon.util.EventPublisher

@EventPublisher
class Player {
    private final int id

    Player(int id) {
        this.id = id
    }
 
    def onMarco = {
        println "Player ($id) got a Marco!"
        publishEvent 'Polo', ["Polo! ($id)"]
    }
}
