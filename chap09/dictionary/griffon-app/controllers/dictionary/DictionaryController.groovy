package dictionary

class DictionaryController {
    def model
    def dictionaryService

    def search = {
        String word = model.word
        execSync { model.enabled = false }
        try {
            String definition = dictionaryService.findDefinition(word)
            execAsync { model.result = "${word}: $definition" }
        } finally {
            execAsync { model.enabled = true }
        }
    }
}
