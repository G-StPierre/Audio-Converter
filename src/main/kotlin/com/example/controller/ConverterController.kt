package com.example.controller

import javafx.scene.layout.BorderPane
import javafx.stage.FileChooser
import tornadofx.Controller
import ws.schild.jave.Encoder
import ws.schild.jave.MultimediaObject
import ws.schild.jave.encode.AudioAttributes
import ws.schild.jave.encode.EncodingAttributes
import java.io.File

class ConverterController: Controller() {

    val codecs = mapOf<String, String>(
        "mp3" to "libmp3lame",
        "wav" to "pcm_s16le"

    )

    private val chooser = FileChooser()

    fun writeToDb(inputValue: String) {
        println("Writing $inputValue to database!")
    }

    fun getSongName(file: File?): String {
        return if (file != null) {
            file.name
        } else
            ""
    }

    fun getFile(scene: BorderPane): File {
        return chooser.showOpenDialog(scene.scene.window)
    }


    fun checkParams(audioFile: File?, target: String?, output: String?): Boolean {
        return audioFile != null && target != null && output != null
    }

        fun convertAudio2(source: File?, outputTarget: String?, target: String?) {

            var outputFile = File(source?.absoluteFile?.parent + "\\" + outputTarget + "." + target)

            var audio = AudioAttributes()
            audio.setCodec(codecs[target])

            var encoding = EncodingAttributes()
            encoding.setOutputFormat("wav")
            encoding.setAudioAttributes(audio)

            var encoder = Encoder()
            encoder.encode(MultimediaObject(source), outputFile, encoding)

            println(outputFile)
        }
}