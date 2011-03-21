import grails.converters.JSON

class AuthorController {
    static defaultAction = 'list'

    def list = {
        render(Author.list(params) as JSON)
    }

    def show = {
        def author = Author.get(params.id)
        if (!author) {
            redirect(action: 'list')
        } else {
            render(author as JSON)
        }
    }

    def search = {
        def list = []
        if (params.q) {
            list = Author.findAllByNameLike("%${params.q}%")
            if(!list) list = Author.findAllByLastnameLike("%${params.q}%")
        }
        render(list as JSON)
    }
}
