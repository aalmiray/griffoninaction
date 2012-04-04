package dictionary

class DictionaryController {
    def model
    def dictionaryService

    def search = {
        String word = model.word
        execInsideUISync { model.enabled = false }
        try {
            String definition = dictionaryService.findDefinition(word)
            execInsideUIAsync { model.result = "${word}: $definition" }
        } finally {
            execInsideUIAsync { model.enabled = true }
        }
    }
}
