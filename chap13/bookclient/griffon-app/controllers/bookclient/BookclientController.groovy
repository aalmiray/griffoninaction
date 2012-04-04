package bookclient

class BookclientController {
    def model
    def view
    def bookstoreService

    def search = {
        execInsideUISync {
            model.enabled = false
            model.status = ''
            model.results.clear()
        }

        String where = view.choice.selection.actionCommand

        try {
            List results = []
            switch(where) {
                case BookclientModel.AUTHORS:
                  results = bookstoreService.searchAuthors(model)
                  break
                case BookclientModel.BOOKS:
                  results = bookstoreService.searchBooks(model)
                  break
            }
            execInsideUISync {
                model.status = 
                  "Found ${results.size()} result${results.size() != 1 ? 's': ''}"
                if(results) model.results.addAll(results)
            }
        } finally {
            execInsideUIAsync { model.enabled = true }
        }
    }

    def onStartupEnd = { app ->
        execOutsideUI { bookstoreService.populateModel(model) }
    }
}
