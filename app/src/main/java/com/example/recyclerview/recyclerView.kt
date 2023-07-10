package com.example.recyclerview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RecyclerViewLayout() {
    //VerticalRecyclerView()
    //HorizontalRecyclerView()
    GridViewLayout()
}

@Composable
fun VerticalRecyclerView() {

    var lists = listOf("ab","cd","ef","gh","ij")


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        //reverseLayout = true, //move from top to bottom
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        /*item {
           // Text(text = "Hello")
            (1..100).forEach{
                Text(text = "Hello $it",
                    modifier = Modifier.padding(20.dp))
            }
        }*/

        /*items(lists){
            Text(text = it, modifier = Modifier.padding(vertical = 20.dp))
        }

        itemsIndexed(lists){index, item ->
            Text(text = item, modifier = Modifier.padding(vertical = 20.dp))
        }*/

        items(items, key = {
            it.id
        }){
            Text(text = it.item,
            modifier = Modifier.padding(vertical = 20.dp))
        }

    }
}


@Composable
fun HorizontalRecyclerView() {

    LazyRow(modifier = Modifier.fillMaxWidth(),
    state = rememberLazyListState(
        7)){
        showContent()
    }

}

//extension function
fun LazyListScope.showContent(){
    items(items, key = {
        it.id
    }){
        Text(text = "${it.item} ${it.id}",
            modifier = Modifier.padding(horizontal = 20.dp))
    }
}

@Composable
fun GridViewLayout() {

   /* LazyVerticalGrid(
        //columns = GridCells.Fixed(3)){
        columns = GridCells.Adaptive(75.dp)){
        items(items, key = {
            it.id
        }){
            Text(text = "${it.item} ${it.id}",
                modifier = Modifier.padding(horizontal = 20.dp))
        }
    }*/

    LazyHorizontalGrid(rows = GridCells.Fixed(4)){
        items(items, key = {
            it.id
        }){
            Text(text = "${it.item} ${it.id}",
                modifier = Modifier.padding(horizontal = 20.dp))
        }
    }
}


data class Item(
    val id: Int,
    val item :String
)

val items = listOf(
    Item(
        1, "abcd"
    ),
    Item(
        2, "abcd"
    ),
    Item(
        3, "abcd"
    ),
    Item(
        4, "abcd"
    ),
    Item(
        5, "abcd"
    ),
    Item(
        6, "abcd"
    ),
    Item(
        7, "abcd"
    ),

)