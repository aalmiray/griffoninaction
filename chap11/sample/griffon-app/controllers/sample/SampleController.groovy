package sample

class SampleController {
    def model

    def click = {
        execInsideUISync { model.enabled = false }
        String a = model.inputA
        String b = model.inputB
      
        try {
            Number o = Double.valueOf(a) + Double.valueOf(b)
            execInsideUISync { model.output = o }      
        } catch(NumberFormatException nfe) {
            execInsideUISync { model.output = Double.NaN }      
        } finally {
            execInsideUIAsync { model.enabled = true }
        }
    }
}
