package dictionary

import spock.lang.Unroll
import griffon.spock.*

class DictionaryServiceSpec extends UnitSpec {
    def service = new DictionaryService()

    def "No input results in an error"() {
        expect:
            service.findDefinition('') == DictionaryService.INPUT_ERROR_MESSAGE
    }

    def "Wrong input results in an error"() {
        expect:
            service.findDefinition('spock') == DictionaryService.FIND_ERROR_MESSAGE
    }

    @Unroll("Entering '#word' results in '#definition'")
    def "Correct input results in a definition being found"() {
        expect:
            definition == service.findDefinition(word)

        where:
            word      | definition
            'Groovy'  | 'An agile and dynamic language for the Java platform.'
            'Grails'  | 'A full stack web application development platform.'
            'Griffon' | 'Grails inspired desktop application development platform.'
            
    }
}
