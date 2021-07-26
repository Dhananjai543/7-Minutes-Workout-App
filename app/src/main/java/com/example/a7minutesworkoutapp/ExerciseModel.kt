package com.example.a7minutesworkoutapp

class ExerciseModel(
        private var id: Int,
        private var name: String,
        private var image: String,
        private var isCompleted: Boolean,
        private var isSelected: Boolean,
        private var url: String
    )  {
    fun getId() : Int{
        return id
    }
    fun setInd(id: Int){
        this.id = id
    }
    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getImage(): String {
        return image
    }


    fun getIsCompleted(): Boolean {
        return isCompleted
    }

    fun setIsCompleted(isCompleted: Boolean) {
        this.isCompleted = isCompleted
    }

    fun getIsSelected(): Boolean {
        return isSelected
    }

    fun setIsSelected(isSelected: Boolean) {
        this.isSelected = isSelected
    }

    fun getUrl(): String {
        return url
    }
}