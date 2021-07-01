package com.example.oshibkinamilliondollarov.ui.detail

class TextImageDivider {
    fun divideTextAndImage(t: String) : DividedTextAndImage {
        var text = t
        val res = DividedTextAndImage()
        var begin = 0
        var start = text.indexOf("<img>")
        while(start >= 0) {
            var end = text.indexOf("</img>")
            var imageName = text.substring(start+5, end)
            res.texts.add(text.substring(begin, start))
            res.images.add(imageName)
            text = text.removeRange(start, end+6)
            begin = start
            start = text.indexOf("<img>")
        }
        if (begin < text.length-1) {
            res.texts.add(text.substring(begin, text.length))
        }
        return res
    }
}