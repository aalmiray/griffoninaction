class BootStrap {
    def init = { servletContext ->
        def authors = [
            new Author(name: 'Octavio', lastname: 'Paz'),
            new Author(name: 'Gabriel', lastname: 'Garcia Marquez'),
            new Author(name: 'Douglas R.', lastname: 'Hofstadter')
        ]

        def books = [
            new Book(title: 'The Labyrinth of Solitude'),
            new Book(title: 'No One Writes to the Coronel'),
            new Book(title: 'Goedel, Escher & Bach'),
            new Book(title: 'One Hundred Years of Solitude')
        ]

        authors[0].addToBooks(books[0]).save()
        authors[1].addToBooks(books[1]).save()
        authors[2].addToBooks(books[2]).save()
        authors[1].addToBooks(books[3]).save()
    }
} 
