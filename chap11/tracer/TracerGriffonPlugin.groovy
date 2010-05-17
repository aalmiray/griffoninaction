class TracerGriffonPlugin {
    def version = 0.1
    def griffonVersion = "0.3 > *" 
    def dependsOn = [:]
    // optional. Valid values are: swing, javafx, swt, pivot, gtk
    // def toolkits = ['swing']
    // optional. Valid values are linux, windows, macosx, solaris
    // def platforms = []

    // TODO Fill in these fields
    def author = "Your name"
    def authorEmail = ""
    def title = "Plugin summary/headline"
    def description = '''\\
Brief description of the plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://griffon.codehaus.org/Tracer+Plugin"
}
