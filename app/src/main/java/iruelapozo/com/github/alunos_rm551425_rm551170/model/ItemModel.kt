package iruelapozo.com.github.alunos_rm551425_rm551170.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity
data class ItemModel(


    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,


    val local: String,
    val evento:String,
    val impacto:String,
    val data:String,
    val afetadas:String
)
