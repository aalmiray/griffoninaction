package bookclient

class BookclientController {
  def model
  def view

  def search = {
    model.busy = true
    model.status = ''
    model.results.clear()
    execOutside {
      try {
        List results = []
        switch(view.choice.selection.actionCommand) {
          case BookclientModel.AUTHORS:
            results = searchAuthors()
            break
          case BookclientModel.BOOKS:
            results = searchBooks()
            break
        }

        execSync {
          model.status = "Found ${results.size()} result${results.size() != 1 ? 's': ''}"
          if(results) model.results.addAll(results)
        }
      } finally {
        execAsync { model.busy = false }
      }
    }
  }

  private List searchAuthors() {
    withRest(id: 'bookstore') {
      def response = get(path: 'author/search', query: [q: model.query])
      response.data.inject([]) { list, author ->
        author.books.id.collect(list) { bookId ->
          def book = model.books.find{it.id == bookId}
          [title: book.title, name: author.name, lastname: author.lastname]
        }
      }
    }
  }

  private List searchBooks() {
    withRest(id: 'bookstore') {
      def response = get(path: 'book/search', query: [q: model.query])
      response.data.collect([]) { book ->
        def author = model.authors.find{it.id == book.author.id}
        [title: book.title, name: author.name, lastname: author.lastname]
      }
    }
  }

  def onStartupEnd = { app ->
    withRest(id: 'bookstore', uri: 'http://localhost:8080/bookstore/') {
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
    }
  }
}
