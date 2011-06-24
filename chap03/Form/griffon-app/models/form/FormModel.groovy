package form

import groovy.beans.Bindable
import griffon.transform.PropertyListener
import static griffon.util.GriffonNameUtils.isBlank

@Bindable
@PropertyListener(enabler)
class FormModel {
  String name
  String lastName
  String address

  boolean submitEnabled
  boolean resetEnabled

  private enabler = { e ->
    submitEnabled = !isBlank(name) && !isBlank(lastName) && !isBlank(address)
    resetEnabled = !isBlank(name) || !isBlank(lastName) || !isBlank(address)     
  }
}
