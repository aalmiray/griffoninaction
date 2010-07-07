package sample

class SampleController {
    def model

    def click = {
        model.enabled = false
        String a = model.inputA
        String b = model.inputB
      
        execOutside {
            try {
                Number o = Double.valueOf(a) + Double.valueOf(b)
                execSync { model.output = o }      
            } finally {
                execAsync { model.enabled = true }
            }
        }
    }
}
