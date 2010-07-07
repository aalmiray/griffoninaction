//
// This script is executed by Griffon when the plugin is uninstalled from project.
// Use this script if you intend to do any additional clean-up on uninstall, but
// beware of messing up SVN directories!
//

// check to see if we already have a TracerGriffonAddon
boolean addonIsSet1
builderConfig.each() { prefix, v ->
    v.each { builder, views ->
        addonIsSet1 = addonIsSet1 || 'TracerGriffonAddon' == builder
    }
}

if (addonIsSet1) {
    println 'Removing TracerGriffonAddon from Builder.groovy'
    builderConfigFile.text = builderConfigFile.text - "root.'TracerGriffonAddon'.addon=true\n"
}
