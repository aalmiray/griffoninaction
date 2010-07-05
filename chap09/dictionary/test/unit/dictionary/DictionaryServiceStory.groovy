package dictionary



scenario "Hello Groovy", {
   given "A prefix string 'Hello '", {
      prefix = "Hello "
   }

   and "A name is chosen, such as 'Groovy'", {
      name = "Groovy"
   }

   when "Both the prefix and name are concatenated into a greeting", {
      greeting = prefix + name
   }

   then "The greeting should be equal to 'Hello Groovy'", {
      greeting.shouldBe "Hello Groovy"
   }
}
