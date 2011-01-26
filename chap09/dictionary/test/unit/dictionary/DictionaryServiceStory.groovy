package dictionary

import static dictionary.DictionaryService.*

scenario "DictionaryService can find the word 'Griffon'", {
   given "an instance of DictionaryService is available", {
       service = new DictionaryService()
   }

   when "the word 'Griffon' is used as parameter", {
       result = service.findDefinition('Griffon')
   }

   then "the definition should be found", {
      assert result == "Grails inspired desktop application development platform."
   }
}
