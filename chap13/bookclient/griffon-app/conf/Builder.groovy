root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'RestGriffonAddon'.addon=true

root.'GlazedlistsGriffonAddon'.addon=true

root.'JxlayerGriffonAddon'.addon=true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'JBusyComponentGriffonAddon'.addon=true

root.'MiglayoutGriffonAddon'.addon=true
