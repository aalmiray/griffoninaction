class SampleController {
    def model

    def click = {
        model.enabled = false
        String a = model.inputA
        String b = model.inputB
      
        doOutside {
            try {
                Number o = Double.valueOf(a) + Double.valueOf(b)
                edt { model.output = o }      
            } finally {
                doLater { model.enabled = true }
            }
        }
    }
}
