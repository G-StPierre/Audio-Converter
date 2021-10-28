package com.example.view

import com.example.Styles
import com.example.controller.ConverterController
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.layout.BorderPane
import javafx.stage.StageStyle
import tornadofx.*
import java.io.File
import java.lang.NullPointerException

class ConverterView: View("Audio Converter") {

    private val controller: ConverterController by inject()
    private val output = SimpleStringProperty()
    private var userFile: File? = null
    private val selectedExtension = SimpleStringProperty()
    private val items = FXCollections.observableArrayList("MP3", "WAV")
    private val songName = SimpleStringProperty("")

    override val root = BorderPane()

    init {
        with(root) {
            addClass(Styles.box)
            addClass(Styles.vbox)
            center {
                form {
                    vbox(alignment = Pos.CENTER) {
                        addClass(Styles.vbox)
                        fieldset {
                            field("Output File name") {
                                addClass(Styles.inputBox)
                                textfield(output) {
                                    //outputName = this

                                }
                            }
                            field("Output Extension") {
                                addClass(Styles.spinner)
                                combobox(selectedExtension, items)
                            }
                            hbox(alignment = Pos.CENTER) {
                                button("Chose file") {
                                    addClass(Styles.formButton)
                                    action {
                                        try {
                                            userFile = controller.getFile(root)
                                            songName.value = controller.getSongName(userFile)
                                        } catch (e: NullPointerException) {
                                            find<ErrorFragment>().openModal(stageStyle = StageStyle.UTILITY)
                                            songName.value = ""
                                        }
                                    }
                                }
                                label(songName) {
                                    addClass(Styles.songTitle)
                                }
                            }
                        }
                    }
                }
            }
            bottom {
                hbox(alignment = Pos.CENTER) {
                    addClass(Styles.hbox)
                    button("Convert") {
                        addClass(Styles.formButton)
                        action {
                            if (controller.checkParams(
                                    userFile,
                                    selectedExtension.value,
                                    output.value
                                )
                            ) controller.convertAudio2(userFile, output.value, selectedExtension.value)
                            else find<ErrorFragment>().openModal(stageStyle = StageStyle.UTILITY)

                        }
                    }
                }
            }
        }
    }
}