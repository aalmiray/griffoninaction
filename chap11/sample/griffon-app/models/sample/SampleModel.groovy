package sample

import groovy.beans.Bindable
import griffon.transform.PropertyListener

@PropertyListener(enabler)
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
