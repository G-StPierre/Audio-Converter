package com.example

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.paint.Paint
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val box by cssclass()
        val hbox by cssclass()
        val songTitle by cssclass()
        val spinner by cssclass()
        val vbox by cssclass()
        val inputBox by cssclass()
        val formButton by cssclass()

    }

    init {

        box {
            backgroundColor += Color.LIGHTBLUE
            alignment = Pos.CENTER
        }

        inputBox {
            backgroundColor +=  Color.web("#FFFFFF", 0.0)
            textBoxBorder = Color.web("#000000", 0.45)
            textFill  = Color.web("#FFFFFF", 1.0)
            baseColor = Color.web("#000000", 0.45)
        }

        spinner {

            backgroundColor += Color.web("#000000", 0.0)
            baseColor = Color.web("#000000", 0.45)
            accentColor = Color.web("#000000", 0.0)
        }

        songTitle {
            textFill = Color.WHITE
            padding = box(20.px)
        }

        formButton {
            backgroundColor += Color.web("#214fc6")
            textFill = Color.WHITE
            alignment = Pos.CENTER
            padding = box(10.px)

        }

        hbox {
            backgroundColor += Color.web("#214fc6")
            alignment = Pos.CENTER
            spacing = 25.percent
        }

        vbox {
            backgroundColor += Color.web("#000000", 0.45)
            textFill = Color.WHITE
            padding = box(25.px)
            spacing = 10.px
            vgap = 10.px
        }


    }

}