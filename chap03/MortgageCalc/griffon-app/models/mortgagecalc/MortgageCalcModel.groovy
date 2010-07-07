package mortgagecalc
import groovy.beans.Bindable

class MortgageCalcModel {
    @Bindable float principal
    @Bindable float monthlyRate
    @Bindable float months

    public float getPayment() {
      return principal * monthlyRate /
        (1-Math.pow(1/(1+monthlyRate),months))
    }
}
