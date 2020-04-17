package com.ddd.library.domain.service

import java.lang.RuntimeException

class BookNotFoundException(message: String?) : RuntimeException(message) {}
