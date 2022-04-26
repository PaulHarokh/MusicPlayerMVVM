package by.paulharokh.musicplayer.data.remote

import by.paulharokh.musicplayer.data.entities.Song
import by.paulharokh.musicplayer.othet.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song>{
        return try{
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e:Exception){
            emptyList()
        }
    }
}