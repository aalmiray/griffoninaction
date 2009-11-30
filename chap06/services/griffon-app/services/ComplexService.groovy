class ComplexService {
   def thing

   def call(String name = "") {
       name ? "complex replies: $name" : thing.value
   }
}
