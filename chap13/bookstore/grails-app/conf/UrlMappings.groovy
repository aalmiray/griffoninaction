class UrlMappings {
    static mappings = {
      "/author/"(controller: 'author', action: 'list')
      "/author/search"(controller: 'author', action: 'search')
      "/author/list"(controller: 'author', action: 'list')
      "/author/$id"(controller: 'author', action: 'show')
      "/book/"(controller: 'book', action: 'list')
      "/book/search"(controller: 'book', action: 'search')
      "/book/list"(controller: 'book', action: 'list')
      "/book/$id"(controller: 'book', action: 'show')
      "/"(view:"/index")
      "500"(view:'/error')
    }
}
