package dictionary

import griffon.fest.*
import org.fest.swing.fixture.*

class DictionarySpec extends FestSpec {
    def "Initial state: 'Search' button is disabled"() {
        expect:
            window.button('search').requireDisabled()
    }

    def "Typing in a known word results in the definition being displayed"() {
        when:
            window.with {
                textBox('word').enterText('griffon')
                button('search').click()
            }

        then:
            window.textBox('result')
                .requireText('griffon: Grails inspired desktop application development platform.')
    }

    def "Typing in an unknown word results in an error message"() {
        when:
            window.with {
                textBox('word').enterText('spock')
                button('search').click()
            }

        then:
            window.textBox('result')
                .requireText("spock: Word doesn't exist in dictionary")
    }

    void onCleanup() {
        app.models.dictionary.with {
            word = ""
            result = ""
        }
    }
}
