package com.example.segundoparcial

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var breedNameTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var descriptionTextView: TextView
    private lateinit var backButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Vistas
        imageView = findViewById(R.id.catImageView)
        breedNameTextView = findViewById(R.id.breedNameTextView)
        weightTextView = findViewById(R.id.weightTextView)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        val backButton = findViewById<Button>(R.id.backButton)

        // Recibir el ID del gato
        val catId = intent.getStringExtra("catId")
        if (catId == null) {
            Log.e("DetailActivity", "Cat ID not received!")
            finish()
            return
        }

        // Buscar el gato por su ID
        val selectedCat = catsData.find { it.id == catId }
        if (selectedCat == null) {
            Log.e("DetailActivity", "No cat found with ID: $catId")
            finish()
            return
        }

        // Mostrar los datos en la pantalla
        Picasso.get().load(selectedCat.url).into(imageView)
        breedNameTextView.text = selectedCat.breeds[0].name
        weightTextView.text = "Peso: ${selectedCat.breeds[0].weight.metric} kg / ${selectedCat.breeds[0].weight.imperial} lbs"
        descriptionTextView.text = selectedCat.breeds[0].description

        // Configurar el botón de retroceso
        backButton.setOnClickListener {
            finish() // Vuelve al listado
        }
    }
}

    // Datos "hardcodeados" para cada gato
    val catsData = listOf(
        Cat(
            id = "ui",
            url = "https://cdn2.thecatapi.com/images/ui.jpg",
            breeds = listOf(
                Breed(
                    name = "Abyssinian",
                    weight = Weight(imperial = "7 - 10 lbs", metric = "3 - 5 kg"),
                    description = "El Abyssinian es fácil de cuidar y un placer tenerlo en tu hogar. Son gatos cariñosos y les encanta estar tanto con personas como con otros animales."
                )
            )
        ),
        Cat(
            id = "5hl",
            url = "https://cdn2.thecatapi.com/images/5hl.jpg",
            breeds = listOf(
                Breed(
                    name = "Siamese",
                    weight = Weight(imperial = "8 - 12 lbs", metric = "3.6 - 5.4 kg"),
                    description = "El Siamese es conocido por su personalidad vocal y afectuosa. Son gatos muy sociales y leales."
                )
            )
        ),
        Cat(
            id = "5pp",
            url = "https://cdn2.thecatapi.com/images/5pp.jpg",
            breeds = listOf(
                Breed(
                    name = "Persian",
                    weight = Weight(imperial = "7 - 12 lbs", metric = "3.2 - 5.4 kg"),
                    description = "El Persian es un gato tranquilo y cariñoso. Disfruta de la compañía humana y es muy independiente."
                )
            )
        ),
        Cat(
            id = "91i",
            url = "https://cdn2.thecatapi.com/images/91i.jpg",
            breeds = listOf(
                Breed(
                    name = "Maine Coon",
                    weight = Weight(imperial = "10 - 25 lbs", metric = "4.5 - 11.3 kg"),
                    description = "El Maine Coon es uno de los gatos más grandes y amigables. Son conocidos por su personalidad juguetona y su inteligencia."
                )
            )
        ),
        Cat(
            id = "9to",
            url = "https://cdn2.thecatapi.com/images/9to.jpg",
            breeds = listOf(
                Breed(
                    name = "Bengal",
                    weight = Weight(imperial = "8 - 15 lbs", metric = "3.6 - 6.8 kg"),
                    description = "El Bengal es un gato activo y energético con un patrón de pelaje similar al de un leopardo. Son excelentes compañeros para personas activas."
                )
            )
        ),
        Cat(
            id = "c1a",
            url = "https://cdn2.thecatapi.com/images/c1a.jpg",
            breeds = listOf(
                Breed(
                    name = "Ragdoll",
                    weight = Weight(imperial = "10 - 20 lbs", metric = "4.5 - 9.1 kg"),
                    description = "El Ragdoll es conocido por su naturaleza tranquila y su amor por el contacto humano. Es un gato muy relajado y afectuoso."
                )
            )
        ),
        Cat(
            id = "d4v",
            url = "https://cdn2.thecatapi.com/images/d4v.jpg",
            breeds = listOf(
                Breed(
                    name = "Scottish Fold",
                    weight = Weight(imperial = "6 - 13 lbs", metric = "2.7 - 5.9 kg"),
                    description = "El Scottish Fold es un gato con orejas dobladas. Son gatos tranquilos, cariñosos y se llevan bien con otros animales y niños."
                )
            )
        ),
        Cat(
            id = "e8d",
            url = "https://cdn2.thecatapi.com/images/e8d.jpg",
            breeds = listOf(
                Breed(
                    name = "Russian Blue",
                    weight = Weight(imperial = "7 - 10 lbs", metric = "3.2 - 4.5 kg"),
                    description = "El Russian Blue es conocido por su pelaje denso y de color azul. Son gatos tranquilos y muy leales."
                )
            )
        ),
        Cat(
            id = "MTgxNTQwNQ",
            url = "https://cdn2.thecatapi.com/images/MTgxNTQwNQ.jpg",
            breeds = listOf(
                Breed(
                    name = "British Shorthair",
                    weight = Weight(imperial = "9 - 17 lbs", metric = "4.1 - 7.7 kg"),
                    description = "El British Shorthair es un gato de cuerpo robusto y temperamento tranquilo. Son conocidos por su independencia y lealtad."
                )
            )
        ),
        Cat(
            id = "e7-hS3gey",
            url = "https://cdn2.thecatapi.com/images/e7-hS3gey.jpg",
            breeds = listOf(
                Breed(
                    name = "Abyssinian",
                    weight = Weight(imperial = "7 - 10 lbs", metric = "3 - 5 kg"),
                    description = "El Abyssinian es un gato activo, enérgico y cariñoso. Les encanta jugar y explorar nuevos lugares."
                )
            )
        )
    )




