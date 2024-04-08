package page

import com.codeborne.selenide.SelenideElement

interface IButton {

    abstract clickButton(def element)

    abstract getButtonName()

    abstract getButtonState()

}