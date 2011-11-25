package dictionary

import groovy.beans.Bindable
import griffon.transform.PropertyListener
import griffon.util.GriffonNameUtils

class DictionaryModel {
    @PropertyListener(modelEnabler)
    @Bindable String word
    @Bindable String result
    @Bindable boolean enabled

    def modelEnabler = {
        enabled = !GriffonNameUtils.isBlank(it.newValue)
    }
}
