//
// This script is executed by Griffon after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/griffon-app/jobs")
//

// Update the following configuration if your addon
// requires a different prefix or exposes nodes in
// a different way.
// Remember to apply the reverse changes in _Uninstall.groovy
//
// check to see if we already have a TracerGriffonAddon
// def configText = '''root.'TracerGriffonAddon'.addon=true'''
// if(!(builderConfigFile.text.contains(configText))) {
//     println 'Adding TracerGriffonAddon to Builder.groovy'
//     builderConfigFile.append("""
// $configText
// """)
// }