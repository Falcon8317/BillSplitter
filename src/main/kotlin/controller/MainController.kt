package controller

import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleIntegerProperty
import tornadofx.*

class MainController: Controller() {
    var totalPerPerson = SimpleDoubleProperty(0.0)
    var tipPercentageAmount = SimpleDoubleProperty(0.0)
    var sliderPercentageAmount = SimpleIntegerProperty(0)

    fun calculate(billAmtValue: SimpleDoubleProperty, splitByValue: SimpleIntegerProperty,
    tipPercVal: SimpleIntegerProperty) {
        tipPercentageAmount.cleanBind (( billAmtValue * tipPercVal) / 100)
        totalPerPerson.cleanBind((tipPercentageAmount.value.toProperty() + billAmtValue) / splitByValue)
        sliderPercentageAmount.cleanBind(tipPercVal)
    }
}