package sample

import groovy.beans.Bindable
import griffon.beans.Listener

@Listener(enabler)
class SampleModel {
    @Bindable String inputA
    @Bindable String inputB
    @Bindable String output
    @Bindable boolean enabled = false

    private enabler = { evt ->
        if(evt.propertyName in ['enabled', 'output']) return
        enabled = inputA && inputB
    }
}
