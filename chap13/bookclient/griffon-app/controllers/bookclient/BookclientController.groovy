package bookclient

class BookstoreclientController {
    def model
    def view
    def bookstoreService

    def search = {
        execSync {
            model.busy = true
            model.status = ''
            model.results.clear()
        }

        String where = view.domain.selection.actionCommand

        try {
            List results = []
            switch(where) {
                case BookstoreclientModel.AUTHORS:
                  results = bookstoreService.searchAuthors(model)
                  break
                case BookstoreclientModel.BOOKS:
                  results = bookstoreService.searchBooks(model)
                  break
            }
            execSync {
                model.status = 
                  "Found ${results.size()} result${results.size() != 1 ? 's': ''}"
                if(results) model.results.addAll(results)
            }
        } finally {
            execAsync { model.busy = false }
        }
    }

    def onStartupEnd = { app ->
        execOutside { bookstoreService.populateModel(model) }
    }
}
