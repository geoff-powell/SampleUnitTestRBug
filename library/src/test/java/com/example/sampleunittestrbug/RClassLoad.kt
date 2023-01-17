package com.example.sampleunittestrbug

import org.junit.Test

class RClassLoad {
  @Test
  fun loadRClass() {
      val rClass = Class.forName("com.example.sampleunittestrbug.R")
      for (resourceClass in rClass.declaredClasses) {
        println(resourceClass.toString())
      }
  }
}