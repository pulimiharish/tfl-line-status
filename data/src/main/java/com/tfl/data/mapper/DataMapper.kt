package com.tfl.data.mapper

interface DataMapper<T, R> {
    fun map(data: T): R
}