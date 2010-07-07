import grails.converters.JSON

class BookController {
    def index = {
        redirect(action: 'list', params: params)
    }

    def list = {
        render(Book.list(params) as JSON)
    }

    def show = {
        def book = Book.get(params.id)
        if (!book) {
            redirect(action: 'list')
        } else {
            render(book as JSON)
        }
    }

    def search = {
        def list = []
        if (params.q) {
            list = Book.findAllByTitleLike("%${params.q}%")
        }
        render(list as JSON)
    }
}
