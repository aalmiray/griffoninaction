package sample

class SampleController {
    def model

    def click = {
        execSync { model.enabled = false }
        String a = model.inputA
        String b = model.inputB
      
        try {
            Number o = Double.valueOf(a) + Double.valueOf(b)
            execSync { model.output = o }      
        } catch(NumberFormatException nfe) {
            execSync { model.output = Double.NaN }      
        } finally {
            execAsync { model.enabled = true }
        }
    }
}
