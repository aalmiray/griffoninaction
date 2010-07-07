package dictionary

import org.fest.swing.fixture.*
import griffon.fest.FestSwingTestCase

class DictionaryTests extends FestSwingTestCase {
    void testInitialState() {
        window.button('search').requireDisabled()
    }

    void testWordIsFound() {
        window.with {
            textBox('word').enterText('griffon')
            button('search').click()
            textBox('result')
                .requireText('griffon: Grails inspired desktop application development platform.')
        }
    }

    void testWordIsNotFound() {
        window.with {
            textBox('word').enterText('spock')
            button('search').click()
            textBox('result')
                .requireText("spock: Word doesn't exist in dictionary")
        }
    }

    protected void onTearDown() {
        app.models.dictionary.with {
            word = ""
            result = ""
        }
    }
}
