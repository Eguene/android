package com.example.applecturetwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.applecturetwo.ui.theme.AppLectureTwoTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//      Потренуватися створювати екземпляри класів та визивати їх функції та змінні

        val koyote: Animal = Animal("Joey", "Land", 4, true)
        koyote.GetEnvironment()
        koyote.GetLegs()

        val husky: Dog = Dog("Siby", "trained", "land", 4, true)
        husky.isTrained()
        husky.GetName()

        val jay: Bird = Bird("Jay", "omnivore", "air", 2, true)
        jay.GetEnvironment()
        jay.FoodType()

        val cl1 : voice = cat()
        val bq1 : voice = bunny()
        cl1.voiceLoud()
        bq1.voiceQuiet()

    }

    //      Написати клас, в якому є приватні та публічні змінні та функції. Для наочності, нехай
    //      це буде клас Тварина (Animal). У ньому можуть бути абстрактні функції чи змінні.
    open class Animal(var _name: String, var _environment: String, val _number_of_legs: Byte, var _isAlive: Boolean) {
        protected var name: String = _name
        var environment: String = _environment
        var number_of_legs: Byte = _number_of_legs
        private val isAlive: Boolean = _isAlive

        fun GetName(): String
        {
            if (isAlive == true) {
                return("Animal's name is $name")
            } else {
                return("Animal is dead")
            }
        }

        open fun GetEnvironment(): String
        {
            if (isAlive == true) {
                return("Animal's environment is $environment")
            } else {
                return("Animal is dead")
            }
        }

        open fun GetLegs(): String {
            if (isAlive == true) {
                return("Animal has $number_of_legs legs")
            } else {
                return("Animal is dead")
            }
        }

        fun AnimalFreePrint(input: String): String {
            return("Animal is $input")
        }

        private fun IsAnimalAlive(): String {
            return("Is animal alive: $isAlive")
        }
    }


//      Написати класи, які розширюють клас Тварина, наприклад, Собака, Птиця та Риба.
//      Вони можуть містити додаткові функції чи змінні. Також вони можуть перевизначати
//      деякі функції (override).

    class Dog(var dogName: String, var dogIsTrained: String, var dogEnvironment: String = "land", val dog_number_of_legs: Byte = 4, var dogIsAlive: Boolean): Animal(dogName, dogEnvironment, dog_number_of_legs, dogIsAlive)
    {
        fun isTrained(): String
        {
            if (dogIsTrained == "trained")
            {
                return("$dogName is $dogIsTrained")
            }
            else if (dogIsTrained == "not trained")
            {
                return("$dogName is $dogIsTrained")
            }
            else
            {
                return("Training status is unknown. Try lowercase.")
            }
        }

        override fun GetEnvironment(): String {
            return("All dogs live on $dogEnvironment")
        }

        override fun GetLegs(): String {
            return("Dogs usually have $dog_number_of_legs legs")
        }
    }

    class Bird(var birdName: String, val birdFoodType: String,  var birdEnvironment: String = "air", val bird_number_of_legs: Byte = 2, var birdIsAlive: Boolean): Animal(birdName, birdEnvironment, bird_number_of_legs, birdIsAlive)
    {
        fun FoodType(): String
        {
            if(birdFoodType == "carnivore")
            {
                return("Bird is $birdFoodType")
            }
            else if(birdFoodType == "herbivore")
            {
                return("Bird is $birdFoodType")
            }
            else if(birdFoodType == "omnivore")
            {
                return("Bird is $birdFoodType")
            }
            else
            {
                return("Birb food type is unknown. Try lowercase.")
            }
        }

        override fun GetEnvironment(): String {
            return("Most of birds move in $birdEnvironment")
        }

        override fun GetLegs(): String {
            return("Birds usually have $bird_number_of_legs legs")
        }
    }

    class Fish(var fishName: String, var fishWeightKg: Byte, var fishEnvironment: String = "water", val fish_number_of_legs: Byte = 0, var fishIsAlive: Boolean): Animal(fishName, fishEnvironment, fish_number_of_legs, fishIsAlive)
    {
        fun isEnough(): String
        {
            if(fishWeightKg >= 2)
            {
                return("That'd be tasty meal")
            }
            else
            {
                return("That wouldn't be enough, need more")
            }
        }
    }

    //      В тілі якоїсь функції потренуватися використовувати цикли.
    class Test(var number: Int)
    {
        val TestList = listOf('a', 'b', 'c')
        var i: Int = 0
        fun forLoop()
        {
            for(ch in TestList)
            {
                i++
            }
            i = 0
        }
        fun whileLoop(){
            while(i < 10)
            {
                i++
            }
            i = 0
        }
        fun doWhile()
        {
            do{
                i++
            }
                while(i<10)
        }
        fun repeatLoop()
        {
            repeat(5)
            {
                i++
            }
        }
    }

    class cat : voice
    {
        override var name = "Shroomie"
    }

    class bunny : voice
    {

        override var name = "Shroomie"
    }


//      Також потрібно написати інтерфейс з функцією, і цей інтерфейс реалізувати у класах.
//      Наприклад, інтерфейс ПодатиГолос з функціями голосГучний та голосТихий.


    interface voice
    {
        var name: String;
        fun voiceLoud():String
        {
            var i: Byte = 0;
            while(i < 5)
            {
                return("$name shouts loudly!")
                i++
            }
            return("$name is silent.")
        }

        fun voiceQuiet(): String
        {
            var i: Byte = 0;
            while(i < 5)
            {
                return("$name shouts quietly.")
                i++
            }
            return("$name is silent.")
        }
    }
}