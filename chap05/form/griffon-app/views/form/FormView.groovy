package form

import griffon.util.GriffonNameUtils as GNU

application(title: 'Form',
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    borderLayout()
    panel(constraints: CENTER,
          border: titledBorder(title: 'Person')) {
        migLayout()
        model.griffonClass.propertyNames.each { name ->
            label(GNU.getNaturalName(name), constraints: 'left')
            textField(columns: 20, constraints: 'growx, wrap',
                text: bind(name, target: model, mutual: true))
        }
    }
    panel(constraints: EAST,
          border: titledBorder(title: 'Actions')) {
        migLayout()
        controller.griffonClass.actionNames.each { name ->
            button(GNU.getNaturalName(name),
                actionPerformed: controller."$name",
                constraints: 'growx, wrap')
        }
    }
}
