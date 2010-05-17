import groovy.beans.Bindable
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList
import java.beans.PropertyChangeListener

class BookclientModel {
  @Bindable String query
  @Bindable String status = ''
  @Bindable boolean busy
  @Bindable boolean enabled = false

  static final AUTHORS = 'author'
  static final BOOKS = 'book'

  EventList authors = new SortedList(new BasicEventList(),
       {a, b -> a.lastname <=> b.lastname} as Comparator)
  EventList books = new SortedList(new BasicEventList(),
       {a, b -> a.title <=> b.title} as Comparator)
  EventList results = new SortedList(new BasicEventList(),
       {a, b -> a.title <=> b.title} as Comparator)

  BookclientModel() {
    addPropertyChangeListener('query', { evt ->
        enabled = evt.newValue?.trim()?.size() ? true : false
    } as PropertyChangeListener)
  }
}
