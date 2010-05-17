class Author {
    static constraints = {
        name(blank: false)
        lastname(blank: false)
    }

    String name
    String lastname
    
    static hasMany = [books: Book]

    String toString() { "$name $lastname" }
}
