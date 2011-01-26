onBootstrapEnd = { app ->
   app.artifactManager.serviceClasses.each { griffonClass ->
       griffonClass.clazz.methods.each { method ->
           if(method.name.contains("\$") ||
              method.name in Object.methods.name ||
              method.name in GroovyObjectSupport.methods.name) return
           griffonClass.metaClass."${method.name}" = { Object... params = null ->
               println "${griffonClass.clazz.simpleName}.${method.name}() called at ${new Date()}"
               method.invoke(delegate, *params)
           }
       }
   }
}
