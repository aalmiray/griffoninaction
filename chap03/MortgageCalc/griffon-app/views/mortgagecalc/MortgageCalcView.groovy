package mortgagecalc

application(title:'Mortgage Calculator', pack:true, locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image] ) {
  panel(border: emptyBorder(6)) {
    
    gridLayout(rows:4, columns:2, hgap:6, vgap:6)

    label('Principal:')
    textField(text: bind(target:model, 'principal',
      value:'$200,000',
      validator: model.validatePrincipal,
      converter: model.convertPrincipal))

    label('Interest Rate:')
    textField(text: bind(target:model, 'monthlyRate',
      value:'6.5%',
      validator: model.validateRate,
      converter: model.convertRate))

    label('Term:')
    textField(text: bind(target:model, 'months',
      value:'30',
      validator: model.validateTerm,
      converter: model.convertTerm))

    label('Monthly Payment (P&I):')
    textField(editable:false,
      text: bind(source: model, sourceProperty: 'payment',
        sourceEvent: 'propertyChange',
        converter: model.convertPayment))
  }
}
