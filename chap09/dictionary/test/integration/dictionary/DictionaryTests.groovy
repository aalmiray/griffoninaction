package dictionary

import org.fest.swing.fixture.*
import griffon.fest.FestSwingTestCase

class DictionaryTests extends FestSwingTestCase {
    void testInitialState() {
        window.button('search').requireDisabled()
    }

    void testWordIsFound() {
        window.textBox('word').enterText('griffon')
        window.button('search').click()
        window.textBox('result')
            .requireText('griffon: Grails inspired desktop application development platform.')
    }

    void testWordIsNotFound() {
        window.textBox('word').enterText('spock')
        window.button('search').click()
        window.textBox('result')
            .requireText("spock: Word doesn't exist in dictionary")
    }

    protected void onTearDown() {
        app.models.dictionary.word = ""
        app.models.dictionary.result = ""
    }
}
