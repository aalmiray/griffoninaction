
isFloat = { value ->
  try {
    Float.parseFloat(value)
    return true
  } catch (Exception e) {
    return false
  }
}

currencyFormat = java.text.NumberFormat.currencyInstance
isCurrency = {value ->
  try {
    return currencyFormat.parse(value) instanceof Number
  } catch (Exception e) {
    return false
  }
}

application(title:'Mortgage Calculatr', pack:true, locationByPlatform:true) {
  panel(border: emptyBorder(6)) {
    
    gridLayout(rows:4, columns:2, hgap:6, vgap:6)

    label('Principal:')
    textField(text: bind(target:model, 'principal',
      value:'$330,000',
      validator: isCurrency,
      converter: currencyFormat.&parse))

    label('Interest Rate:')
    textField(text: bind(
      target:model, 'monthlyRate', value:'6.0',
      validator: isFloat,
      converter: { Float.parseFloat(it) / 1200 }))

    label('Term (Years):')
    textField(text: bind(
      target:model, 'months', value:'30',
      validator: isFloat,
      converter: { Float.parseFloat(it) * 12 }))

    label('Monthly Payment (P&I) :')
    textField(editable:false,
      text: bind(source: model, sourceProperty: 'payment',
        sourceEvent: 'propertyChange',
        converter: currencyFormat.&format ))
  }
}
