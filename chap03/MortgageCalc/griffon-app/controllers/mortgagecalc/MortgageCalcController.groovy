package mortgagecalc

import java.text.NumberFormat
import java.text.DecimalFormat

class MortgageCalcController {
  def currencyFormat = NumberFormat.currencyInstance
  def percentFormat = new DecimalFormat('0.00%')

  def validatePrincipal = {
    try {
      float principal = currencyFormat.parse(it)
      return principal > 0
    } catch (Exception e) {
      return false
    }
  }
  def convertPrincipal = currencyFormat.&parse

  def validateRate = {
    try {
      float rate = percentFormat.parse(it)
      return rate > 0 && rate < 0.30
    } catch (Exception e) {
      return false
    }
  }
  def convertRate = {
    return percentFormat.parse(it) / 12
  }

  def validateTerm = {
    try {
      def term = Float.parseFloat(it)
      return term > 0 && term < 100
    } catch (Exception e) {
      return false
    }
  }
  def convertTerm = {
    return Float.parseFloat(it) * 12
  }

  def convertPayment = {
    return currencyFormat.format(it)
  }
}
