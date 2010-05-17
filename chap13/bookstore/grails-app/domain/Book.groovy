class Book {
    static constraints = {
        title(unique: true)
    }

    String title
    Author author

    static belongsTo = [Author]

    String toString() { title }
}
