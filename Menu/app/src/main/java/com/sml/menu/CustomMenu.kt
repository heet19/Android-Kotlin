package com.sml.menu

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu

class CustomMenu {
    
    fun customeMenu(context : Context, view : View){
        
        val pop = PopupMenu(context, view)
        pop.inflate(R.menu.menu)
        
        pop.setOnMenuItemClickListener { 
            when(it!!.itemId){
                R.id.edit -> { Toast.makeText(context, "This is Edit", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.delete -> { Toast.makeText(context, "This is Delete", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.shared -> { Toast.makeText(context, "This is Share", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        try {
            val fieldMpopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMpopup.isAccessible = true
            val mPopup = fieldMpopup.get(pop)
            mPopup.javaClass
                .getDeclaredMethod("setFoeceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)
        } catch (e:Exception) {

        } finally {
            pop.show()
        }

    }
}