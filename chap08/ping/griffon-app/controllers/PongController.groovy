class PongController {
    int count = 0

    def onPing = {
        app.event("Pong", ["Pong! Pong! (${++count})"])
    }
}
