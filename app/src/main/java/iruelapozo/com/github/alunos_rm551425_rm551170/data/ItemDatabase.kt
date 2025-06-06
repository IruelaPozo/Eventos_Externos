package iruelapozo.com.github.alunos_rm551425_rm551170.data

import androidx.room.Database
import androidx.room.RoomDatabase
import iruelapozo.com.github.alunos_rm551425_rm551170.model.ItemModel

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {


    abstract fun itemDao(): ItemDao
}