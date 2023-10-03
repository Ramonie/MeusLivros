package ufrn.edu.meuslivros.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Livro(
    var titulo:String,
    var autor:String,
    var nota: Float,
    var ano:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}