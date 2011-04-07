package services

class ComplexService {
   def thing

   def doIt(String name = "") {
       name ? "complex replies: $name" : thing.value
   }
}
