package com.alvinalexander.utils

import scala.io.Source
import scala.collection.mutable.ArrayBuffer

object FileUtils {

  /**
   * Get the contents of a text file while skipping over comment lines and
   * blank lines. This is useful when reading a data file that can have lines
   * beginning with '#', or blank lines, such as a file that looks like this:
   *   -------------------
   *   foo
   *   # this is a comment
   *
   *   bar
   *   -------------------
   */
  def getFileContentsWithoutCommentLines(filename: String): List[String] = {
    (for (line <- Source.fromFile(filename).getLines
      if !line.trim.matches("")
      if !line.trim.matches("#.*")) yield line
    ).toList
  }

}

