package ufrn.edu.meuslivros.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Livro(
    val titulo:String,
    val autor:String,
    val nota:Double,
    val ano:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0
}