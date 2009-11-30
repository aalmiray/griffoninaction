onBootstrapEnd = { app ->
   app.artifactManager.serviceClasses.each { klass ->
       klass.methods.each { method ->
           if(method.name.contains("\$") ||
              method.name in Object.methods.name ||
              method.name in GroovyObject.methods.name) return
           def mm = klass.metaClass.getMetaMethod(method.name)
           klass.metaClass."${method.name}" = { Object... params = null ->
               println "${klass.simpleName}.${method.name}() called at ${new Date()}"
               mm.invoke(delegate, *params)
           }
       }
   }
}
