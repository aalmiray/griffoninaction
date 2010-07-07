import java.beans.*

class TracerGriffonAddon {
    def events = [
        NewInstance: { klass, type, instance ->
            addPropertyChangeListener(instance) 
            injectActionInterceptor(klass, instance) 
        }
    ]

    void addPropertyChangeListener(target) {
        MetaClass mc = target.metaClass
        if(mc.respondsTo(target, 'addPropertyChangeListener', [PropertyChangeListener] as Class[])) {
            target.addPropertyChangeListener({ evt ->
                message "${evt.propertyName}: '${evt.oldValue}' -> '${evt.newValue}'"
            } as PropertyChangeListener)
        } 
    }

    void injectActionInterceptor(klass, target) {
        Introspector.getBeanInfo(klass).propertyDescriptors.each { pd ->
            def propertyName = pd.name
            def oldValue = target."$propertyName"
            if(!oldValue?.getClass() || !Closure.isAssignableFrom(oldValue.getClass())) return
            def newValue = { evt ->
                message "Entering $propertyName ..."
                oldValue(evt) 
            }
            target."$propertyName" = newValue
        }
    }

    void message(msg) {
        println msg
    }
}
