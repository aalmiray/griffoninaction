import groovy.beans.Bindable
import java.beans.*

class SampleModel {
    @Bindable String inputA
    @Bindable String inputB
    @Bindable String output
    @Bindable boolean enabled = false

    SampleModel() {
        addPropertyChangeListener({ evt ->
           if(evt.propertyName in ['enabled', 'output']) return
           enabled = inputA && inputB
        } as PropertyChangeListener)
    }
}
