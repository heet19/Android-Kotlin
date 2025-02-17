package com.sml.loginandsignupwithfirebase

data class NoteItem(val title : String, val description : String, val noteId : String) {
constructor(): this("","","")
}
