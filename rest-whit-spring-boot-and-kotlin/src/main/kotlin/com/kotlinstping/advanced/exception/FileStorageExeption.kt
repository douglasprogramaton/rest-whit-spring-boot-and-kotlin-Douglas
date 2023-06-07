package com.kotlinstping.advanced.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class FileStorageExeption:RuntimeException {
    constructor(exception: String): super (exception)
    constructor(exception: String,cause :Throwable): super (cause)
}