package dictionary

import static griffon.util.GriffonNameUtils.isBlank

class DictionaryService {
    static String INPUT_ERROR_MESSAGE = "Please enter a valid word"
    static String FIND_ERROR_MESSAGE = "Word doesn't exist in dictionary"

    static final Map WORDS = [
        groovy: "An agile and dynamic language for the Java platform.",
        grails: "A full stack web application development platform.",
        griffon: "Grails inspired desktop application development platform.",
        devoxx: 'Where all the cool Java kids hang out.'
    ]

    String findDefinition(String word) {
        if(isBlank(word)) return INPUT_ERROR_MESSAGE
        WORDS[word.toLowerCase()] ?: FIND_ERROR_MESSAGE
    }
}
