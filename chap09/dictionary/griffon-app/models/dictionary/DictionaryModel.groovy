package dictionary

import groovy.beans.Bindable
import griffon.beans.Listener
import griffon.util.GriffonNameUtils

class DictionaryModel {
    @Listener(modelEnabler)
    @Bindable String word
    @Bindable String result
    @Bindable boolean enabled

    def modelEnabler = {
        enabled = !GriffonNameUtils.isBlank(it.newValue)
    }
}
