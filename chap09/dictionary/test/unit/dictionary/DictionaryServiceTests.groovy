package dictionary

import griffon.test.*

class DictionaryServiceTests extends GriffonUnitTestCase {
    def service = new DictionaryService()

    void testServiceContainsWord() {
        ['Groovy', 'Grails', 'Griffon'].each { word ->
            isValid(service.findDefinition(word))
            isValid(service.findDefinition(word.toLowerCase()))
            isValid(service.findDefinition(word.toUpperCase()))
        }
    }

    void testServiceCantFindWord() {
        assert service.findDefinition('spock') == DictionaryService.FIND_ERROR_MESSAGE
    }

    void testInvalidInput() {
        assert service.findDefinition('') == DictionaryService.INPUT_ERROR_MESSAGE
        assert service.findDefinition(' ') == DictionaryService.INPUT_ERROR_MESSAGE
    }

    static isValid(String definition) {
        assert definition != DictionaryService.INPUT_ERROR_MESSAGE 
        assert definition != DictionaryService.FIND_ERROR_MESSAGE 
    }
}
