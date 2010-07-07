package dictionary

import griffon.test.*
import static dictionary.DictionaryService.*

class DictionaryServiceTests extends GriffonUnitTestCase {
    DictionaryService service = new DictionaryService()

    void testServiceCantFindWord() {
        assert service.findDefinition('spock') == FIND_ERROR_MESSAGE
    }

    void testInvalidInput() {
        assert service.findDefinition('') == INPUT_ERROR_MESSAGE
        assert service.findDefinition(' ') == INPUT_ERROR_MESSAGE
    }

    void testServiceContainsWord() {
        ['Groovy', 'Grails', 'Griffon'].each { word ->
            assertValid(service.findDefinition(word))
            assertValid(service.findDefinition(word.toLowerCase()))
            assertValid(service.findDefinition(word.toUpperCase()))
        }
    }

    static assertValid(String definition) {
        assert definition != INPUT_ERROR_MESSAGE 
        assert definition != FIND_ERROR_MESSAGE 
    }
}
