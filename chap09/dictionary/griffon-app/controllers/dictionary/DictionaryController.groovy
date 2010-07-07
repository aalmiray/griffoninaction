package dictionary

class DictionaryController {
    def model
    def dictionaryService

    def findDefinition = {
        model.enabled = false
        String word = model.word

        execOutside {
            try {
                String definition = dictionaryService.findDefinition(word)
                execAsync { model.result = "${word}: $definition" }
            } finally {
                execAsync { model.enabled = true }
            }
        }
    }
}
