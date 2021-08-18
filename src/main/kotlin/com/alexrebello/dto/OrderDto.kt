package com.alexrebello.dto


data class OrderDto(
    val id: Long,
    val client: ClientDto,
    val productList: MutableList<ProductDto>
)