package iruelapozo.com.github.alunos_rm551425_rm551170.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import iruelapozo.com.github.alunos_rm551425_rm551170.data.ItemDao
import iruelapozo.com.github.alunos_rm551425_rm551170.data.ItemDatabase
import iruelapozo.com.github.alunos_rm551425_rm551170.model.ItemModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch




class ItemsViewModel(application: Application) : AndroidViewModel(application) {


    private val itemDao: ItemDao


    val itemsLiveData: LiveData<List<ItemModel>>

    init {

        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()


        itemDao = database.itemDao()


        itemsLiveData = itemDao.getAll()
    }


    fun addItem(local: String, evento:String, impacto:String, data:String, afetadas:String) {

        viewModelScope.launch(Dispatchers.IO) {

            val newItem = ItemModel(local = local, evento = evento, impacto = impacto, data = data , afetadas = afetadas)

            itemDao.insert(newItem)
        }
    }


    fun removeItem(item: ItemModel) {

        viewModelScope.launch(Dispatchers.IO) {

            itemDao.delete(item)
        }
    }
}