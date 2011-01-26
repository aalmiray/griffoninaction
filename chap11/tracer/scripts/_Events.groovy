def eventClosure1 = binding.variables.containsKey('eventSetClasspath') ? eventSetClasspath : {cl->}
eventSetClasspath = { cl ->
    eventClosure1(cl)
    if(compilingPlugin('tracer')) return
    griffonSettings.dependencyManager.flatDirResolver name: 'griffon-tracer-plugin', dirs: "${tracerPluginDir}/addon"
    griffonSettings.dependencyManager.addPluginDependency('tracer', [
        conf: 'compile',
        name: 'griffon-tracer-addon',
        group: 'org.codehaus.griffon.plugins',
        version: tracerPluginVersion
    ])
}

