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


root.'MiglayoutGriffonAddon'.addon=true

root.'JbusyComponentGriffonAddon'.addon=true
