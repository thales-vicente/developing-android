package com.udacity.shoestore.shoeList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel(){
    val shoes: MutableLiveData<List<Shoe>> = MutableLiveData()
    fun addImage() {
        val listShoes = listOf(
            Shoe(
                name = "Shoe 1",
                size = "$90,00",
                company = "Company 1",
                description = "Description 1",
                images = listOf("https://img.freepik.com/fotos-gratis/close-up-em-tenis-futuristas_23-2151005669.jpg?t=st=1739467833~exp=1739471433~hmac=9ff615c16b33e4fa6aae3dfd290280db94a7442ab789a8385f3ad814ed39d0a4&w=1060")
            ),
            Shoe(name = "Shoe 2", size = "$130,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/vista-de-sapatos-graficos-3d_23-2150849253.jpg?t=st=1739468802~exp=1739472402~hmac=73844cf44698168f8f294bce75691cf8c2d35f5762969b0460a923814663bbdb&w=740")),

            Shoe(name = "Shoe 3", size = "$80,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/equipamento-desportivo-branco_23-2151920905.jpg?t=st=1739468957~exp=1739472557~hmac=63d29dd4d50e09898818c08a13dc80a2cdbf2b4f4131f36a4475376ecfd03fbe&w=360")),

            Shoe(name = "Shoe 4", size = "$110,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/close-up-em-tenis-futuristas_23-2151005670.jpg?t=st=1739469027~exp=1739472627~hmac=6621f4201acbe920f1aa87d7aaeab4eb7416534c6f8c4cbbdb0f38df3066ae7b&w=360")),

            Shoe(name = "Shoe 5", size = "$70,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/sapatos-masculinos_1203-8389.jpg?t=st=1739469112~exp=1739472712~hmac=5f661cfd9fe48951b0136ea89d07a3275cf71babaa53a662f6ae1ba17d504314&w=1060")),

            Shoe(name = "Shoe 6", size = "$150,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/sapatos-masculinos_1203-8385.jpg?t=st=1739469566~exp=1739473166~hmac=301a2fcbefe97d070a30e55b5c4c3f3fae0576b5bb3e31604328c1fe23777f46&w=1060")),

            Shoe(name = "Shoe 7", size = "$80,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/sapatos-masculinos_1203-8699.jpg?t=st=1739469625~exp=1739473225~hmac=95d8d482cbaa945aa0195f0621869135dd7b926ba0802fd679e38975e5a4ec09&w=1060")),

            Shoe(name = "Shoe 8", size = "$100,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/sapatos_1203-8149.jpg?t=st=1739469792~exp=1739473392~hmac=1919797c72a0fc1f4dda099a6ff60fb2946c36e88b861efd792c604ca192cf7a&w=1060")),

            Shoe(name = "Shoe 9", size = "$110,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/desporto-sapatilhas-da-forma-nova-do-estilo-de-vida_1203-6399.jpg?t=st=1739469886~exp=1739473486~hmac=42547d1e2a016073a7ea45d0d00211b409f7ca0a9305ad66415a86c3c4876233&w=1060")),

            Shoe(name = "Shoe 10", size = "$90,00", company = "Company 2", description = "Description 2", images = listOf("https://img.freepik.com/fotos-gratis/um-moderno-e-elegante-par-de-calcados-esportivos-de-couro-gerado-por-ia_188544-19645.jpg?t=st=1739470006~exp=1739473606~hmac=5b51a9d394464aae84a2fe6190cb96dff86034dbd1e6caa930313586962925cd&w=1380")),


        )
            shoes.value = listShoes
    }
    val navigateToSelectedShoe: MutableLiveData<Shoe?> = MutableLiveData()
    fun displayShoeDetails(shoe: Shoe) {
        navigateToSelectedShoe.value = shoe
    }
    fun displayShoeDetailsComplete() {
        navigateToSelectedShoe.value = null

    }
}