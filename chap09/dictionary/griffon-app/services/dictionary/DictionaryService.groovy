package dictionary

import griffon.util.GriffonNameUtils

class DictionaryService {
    static String INPUT_ERROR_MESSAGE = "Please enter a valid word"
    static String FIND_ERROR_MESSAGE = "Word doesn't exist in dictionary"

    static final Map WORDS = [
        groovy: "An agile and dynamic language for the Java platform.",
        grails: "A full stack web application development platform.",
        griffon: "Grails inspired desktop application development platform."
    ]

    String findDefinition(String word) {
        if(GriffonNameUtils.isBlank(word)) return INPUT_ERROR_MESSAGE
        WORDS[word.toLowerCase()] ?: FIND_ERROR_MESSAGE
    }
}
