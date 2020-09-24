package com.example.firebaseauthmvvm.data.firebase

import com.example.firebaseauthmvvm.data.model.PostDTO
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import io.reactivex.Completable

class FirebaseSource {

   private val firebaseAuth: FirebaseAuth by lazy {
      FirebaseAuth.getInstance()
   }

   private val firebaseFireStore: FirebaseFirestore by lazy {
      FirebaseFirestore.getInstance()
   }

   fun login(email: String, password: String) = Completable.create { emitter ->
      firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
         if (!emitter.isDisposed) {
            if (it.isSuccessful)
               emitter.onComplete()
            else
               emitter.onError(it.exception!!)
         }
      }
   }

   fun register(email: String, password: String) = Completable.create { emitter ->
      firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
         if (!emitter.isDisposed) {
            if (it.isSuccessful)
               emitter.onComplete()
            else
               emitter.onError(it.exception!!)
         }
      }
   }

   fun logout() = firebaseAuth.signOut()

   fun currentUser() = firebaseAuth.currentUser

   fun getPost() : CollectionReference {
      return firebaseFireStore.collection("testText")
   }

}