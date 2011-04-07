onBootstrapEnd = { app ->
   app.artifactManager.serviceClasses.each { griffonClass ->
       griffonClass.serviceNames.each { method ->
           def mm = griffonClass.metaClass.getMetaMethod(method)
           griffonClass.metaClass."${method}" = { Object... params ->
               println "${griffonClass.clazz.simpleName}.${method}() called at ${new Date()}"
               mm.invoke(delegate, params)
           }
       }
   }
}
