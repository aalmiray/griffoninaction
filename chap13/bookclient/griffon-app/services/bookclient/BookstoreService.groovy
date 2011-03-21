package bookclient

class BookstoreService {
  List searchAuthors(model) {
    withRest(id: 'bookstoreREST') {
      def response = get(path: 'author/search', query: [q: model.query])
      response.data.inject([]) { list, author ->
        author.books.id.collect(list) { bookId ->
          def book = model.books.find{it.id == bookId}
          [title: book.title, name: author.name, lastname: author.lastname]
  }}}}

  List searchBooks(model) {
    withRest(id: 'bookstoreREST') {
      def response = get(path: 'book/search', query: [q: model.query])
      response.data.collect([]) { book ->
        def author = model.authors.find{it.id == book.author.id}
        [title: book.title, name: author.name, lastname: author.lastname]
  }}}

  void populateModel(model) {
    withRest(id: 'bookstoreREST', uri: 'http://localhost:8080/bookstore/'){
      def response = get(path: 'author')
      def authors = response.data.collect([]) { author ->
        [name: author.name, lastname: author.lastname, id: author.id]
      }
      execSync { model.authors.addAll(authors) }

      response = get(path: 'book')
      def books = response.data.collect([]) { book ->
        [title: book.title, id: book.id]
      }
      execSync { model.books.addAll(books) }
   }}
}
