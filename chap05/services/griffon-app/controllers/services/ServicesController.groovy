package services

class ServicesController {
    def simpleService
    def complexService

    void mvcGroupInit(Map args) {
        assert simpleService.greet("Griffon") == "Hello Griffon"
        assert complexService.doIt("Griffon") == "complex replies: Griffon"
        println complexService.doIt()
    }
}
